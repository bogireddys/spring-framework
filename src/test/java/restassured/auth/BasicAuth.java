package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BasicAuth {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().basic("user", "passwd")
                .baseUri("https://httpbin.org/")
                .pathParams("username", "user")
                .pathParams("password", "passwd")
                .get("basic-auth/{username}/{password}")
                .then().extract()
                .response();
        System.out.println("Response Status code is : " + response.getStatusCode());
        System.out.println("Response Status line is : " + response.getStatusLine());
        System.out.println("Response body is : " + response.body().asPrettyString());
    }
}
