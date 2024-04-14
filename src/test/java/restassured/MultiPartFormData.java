package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.matching.MultipartValuePatternBuilder;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;

import java.io.File;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MultiPartFormData {
    public static WireMockServer wireMockServer;

    public static void main(String[] args) {
        wireMockServer = new WireMockServer();
        wireMockServer.start();

        MultipartValuePatternBuilder multipartValuePatternBuilder = aMultipart().withName("file")
                .withHeader("Content-Disposition", containing("file.txt"))
                .withBody(equalTo("File content"))
                .withHeader("Content-Type", containing("text/plain"));

        String jsonResponse = "{\n" +
                "  \"firstname\": \"John\",\n" +
                "  \"email\": \"john.doe@email.com\",\n" +
                "  \"lastname\": \"Doe\"\n" +
                "}";

        stubFor(post(urlEqualTo("/upload")).withMultipartRequestBody(multipartValuePatternBuilder)
                .willReturn(aResponse().withStatus(200)
                        .withBody(jsonResponse)));

        File file = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\file.txt");

        MultiPartSpecification multiPartSpecification = new MultiPartSpecBuilder(file)
                .fileName("file.txt")
                .controlName("file")
                .mimeType("text/plain")
                .build();

        Response response = RestAssured.given()
                .baseUri(wireMockServer.baseUrl())
                .auth().none()
                .multiPart(multiPartSpecification)
                .post("/upload").then()
                .extract().response();
        System.out.println("Response code for POST : " + response.getStatusCode());
        System.out.println("Response body for POST : " + response.getBody().asPrettyString());
        wireMockServer.stop();
    }

}
