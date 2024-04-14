package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BearerAuth {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().none()
                .baseUri("https://httpbin.org/")
                .header("Authorization", "Bearer Authorization")
                .get("bearer")
                .then().extract()
                .response();
        System.out.println("Response Status code is : " + response.getStatusCode());
        System.out.println("Response Status line is : " + response.getStatusLine());
        System.out.println("Response body is : " + response.body().asPrettyString());
    }
}
