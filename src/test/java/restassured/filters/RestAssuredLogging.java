package restassured.filters;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredLogging {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().none()
                .log().all()
                .get("https://httpbin.org/uuid")
                .then().log().body().extract().response();
    }
}
