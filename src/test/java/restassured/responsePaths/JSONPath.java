package restassured.responsePaths;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONPath {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured.given()
                .auth().none()
                .get("https://httpbin.org/json")
                .then().extract().response();
        System.out.println("Status code for GET : " +response.getStatusCode());
        System.out.println("Response body for GET : " +response.getBody().asPrettyString());
        File jsonFile = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\JSONFile.json");
        FileWriter fileWriter = new FileWriter(jsonFile);
        fileWriter.write(response.asPrettyString());
        fileWriter.close();

        System.out.println("Response body for GET : " +response.getContentType());
        System.out.println("Validating JSON path : " +response.getBody().jsonPath().getString("slideshow.author").equals("Yours Truly"));
        System.out.println("Validating JSON path : " +response.getBody().jsonPath().getString("slideshow.date"));
    }
}
