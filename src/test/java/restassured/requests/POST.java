package restassured.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POST {
    public static void main(String[] args) {
        Response response = RestAssured
                .given().auth().none()
                .when().post("https://httpbin.org/post")
                .then().extract().response();
        System.out.println("Response status code for POST : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for POST : " +response.body().asPrettyString());
    }
}
