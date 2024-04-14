package restassured.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PUT {
    public static void main(String[] args) {
        Response response = RestAssured
                .given().auth().none()
                .when().put("https://httpbin.org/put")
                .then().extract().response();
        System.out.println("Response status code for PUT : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for PUT : " +response.body().asPrettyString());
    }
}
