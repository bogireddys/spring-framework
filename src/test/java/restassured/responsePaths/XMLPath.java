package restassured.responsePaths;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class XMLPath {
    public static WireMockServer wireMockServer;

    public static void main(String[] args) throws IOException {
        wireMockServer = new WireMockServer();
        wireMockServer.start();

        String sampleXML = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        stubFor(get(urlEqualTo("/xmlpath")).withBasicAuth("username", "password")
                .withHeader("Content-Type", containing("application/xml"))
                .willReturn(aResponse().withStatus(200)
                        .withBody(sampleXML)));

        Response response = RestAssured.given()
                .baseUri(wireMockServer.baseUrl())
                .auth().none()
                .contentType(ContentType.XML)
                .header("Authorization", "Basic dXNlcm5hbWU6cGFzc3dvcmQ=")
                .get("/xmlpath")
                .then().extract().response();

        System.out.println("Status code for GET : " + response.getStatusCode());
        System.out.println("Response body for GET : " + response.getBody().asPrettyString());

        File xmlFile = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\XMLFile.xml");
        FileWriter fileWriter = new FileWriter(xmlFile);
        fileWriter.write(response.asPrettyString());
        fileWriter.close();

        System.out.println("Verifying response body for GET : " + response.getBody().xmlPath().getString("note.heading").equals("Reminder"));
        System.out.println("Parsing XML response : " + response.xmlPath().getString(("note.heading")));

        wireMockServer.stop();
    }
}
