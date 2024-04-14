package restassured.responsePaths;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HTMLPath {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().none().pathParam("value", "SFRUUEJJTiBpcyBhd2Vzb21l")
                .get("https://httpbin.org/base64/{value}")
                .then().extract().response();
        System.out.println("Status code for GET : " +response.getStatusCode());
        System.out.println("Response body for GET : " +response.getBody().asPrettyString());
        System.out.println("Response body for GET : " +response.getContentType());
        System.out.println("Verifying response body for GET : " +response.htmlPath().getString("body").equals("HTTPBIN is awesome"));
    }
}
