package restassured.responseFormats;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BrotliEncode {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured
                .given().auth().none()
                .when().get("https://httpbin.org/brotli")
                .then().extract().response();
        System.out.println("Response status code for GET : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for GET : " +response.body().asPrettyString());

        File outputFile = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\brotli.br");
        System.out.println("Brotli file created : " +outputFile.createNewFile());

        FileWriter fileWriter = new FileWriter(outputFile);
        fileWriter.write(response.body().asPrettyString());

        fileWriter.close();

    }
}
