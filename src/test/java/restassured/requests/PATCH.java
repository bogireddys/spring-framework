package restassured.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PATCH {
    public static void main(String[] args) {
        Response response = RestAssured
                .given().auth().none()
                .when().patch("https://httpbin.org/patch")
                .then().extract().response();
        System.out.println("Response status code for PATCH : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for PATCH : " +response.body().asPrettyString());
    }
}
