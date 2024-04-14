package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class BinaryUpload {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\sample.jpg");

        Response response = RestAssured.given()
                .baseUri("https://httpbin.org")
                .auth().none()
                .body(file)
                .post("/anything").then()
                .extract().response();

        System.out.println("Response code for POST : " + response.getStatusCode());
        System.out.println("Response body for POST : " + response.getBody().asPrettyString());
    }
}
