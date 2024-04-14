package restassured.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET {
    public static void main(String[] args) {
        Response response = RestAssured
                .given().auth().none()
                .when().get("https://httpbin.org/get")
                .then().extract().response();
        System.out.println("Response status code for GET : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for GET : " +response.body().asPrettyString());
    }
}
