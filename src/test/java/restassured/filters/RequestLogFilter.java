package restassured.filters;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.matching.MultipartValuePatternBuilder;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;

import java.io.File;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RequestLogFilter {
    public static WireMockServer wireMockServer;

    public static void main(String[] args) {
        RequestLoggingFilter requestLoggingFilter =
                new RequestLoggingFilter(LogDetail.ALL);

        wireMockServer = new WireMockServer();
        wireMockServer.start();

        MultipartValuePatternBuilder multipartValuePatternBuilder = aMultipart().withName("file")
                .withHeader("Content-Type", containing(ContentType.MULTIPART.toString()));

        String jsonResponse = "{\n" +
                "  \"firstname\": \"John\",\n" +
                "  \"email\": \"john.doe@email.com\",\n" +
                "  \"lastname\": \"Doe\"\n" +
                "}";

        stubFor(post(urlEqualTo("/upload")).withMultipartRequestBody(multipartValuePatternBuilder)
                .willReturn(aResponse().withStatus(200)
                        .withBody(jsonResponse)));

        File file = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\file.txt");

        MultiPartSpecification multiPartSpecBuilder = new MultiPartSpecBuilder(file)
                .fileName(file.getName())
                .controlName("file")
                .mimeType("multipart/form-data")
                .build();

        Response response = RestAssured.given()
                .baseUri(wireMockServer.baseUrl())
                .auth().none()
                .filter(requestLoggingFilter)
                .contentType(ContentType.MULTIPART)
                .multiPart(multiPartSpecBuilder)
                .post("/upload").then()
                .extract().response();
        System.out.println("Response code for POST : " + response.getStatusCode());
        System.out.println("Response body for POST : " + response.getBody().asPrettyString());
        wireMockServer.stop();
    }
}
