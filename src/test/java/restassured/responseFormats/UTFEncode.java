package restassured.responseFormats;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UTFEncode {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured
                .given().auth().none()
                .when().get("https://httpbin.org//encoding/utf8")
                .then().extract().response();
        System.out.println("Response status code for GET : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for GET : " +response.body().asPrettyString());
        System.out.println("Response Content-Type for GET : " +response.contentType());

        File outputFile = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\utf.html");
        System.out.println("HTML file created : " +outputFile.createNewFile());

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write(response.body().asPrettyString());

        fileWriter.close();
    }
}
