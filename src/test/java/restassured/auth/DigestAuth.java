package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DigestAuth {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().digest("user", "passwd")
                .baseUri("https://httpbin.org/")
                .pathParam("qop", "qop")
                .pathParams("username", "user")
                .pathParams("password", "passwd")
                .get("/digest-auth/{qop}/{username}/{password}")
                .then().extract()
                .response();
        System.out.println("Response Status code is : " + response.getStatusCode());
        System.out.println("Response Status line is : " + response.getStatusLine());
        System.out.println("Response body is : " + response.body().asPrettyString());
    }
}
