package restassured.responseFormats;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Denied {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured
                .given().auth().none()
                .contentType(ContentType.JSON)
                .when().get("https://httpbin.org/deny")
                .then().extract().response();
        System.out.println("Response status code for GET : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for GET : " +response.body().asPrettyString());
        System.out.println("Response Content-Type for GET : " +response.getContentType());

        File outputFile = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\deny.txt");
        System.out.println("Brotli file created : " +outputFile.createNewFile());

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write(response.body().asPrettyString());

        fileWriter.close();

    }
}
