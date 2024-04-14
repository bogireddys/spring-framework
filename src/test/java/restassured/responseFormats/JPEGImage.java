package restassured.responseFormats;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JPEGImage {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured.given()
                .auth().none()
                .baseUri("https://httpbin.org")
                .get("/image/jpeg")
                .then().extract().response();
        System.out.println("Response code : " +response.getStatusCode());
        System.out.println("Response body : " +response.getBody().asString());
        System.out.println("Expected Content-Type : " +response.getContentType());

        File file = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\demo.jpeg");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(response.getBody().asString());

        fileWriter.close();
    }
}
