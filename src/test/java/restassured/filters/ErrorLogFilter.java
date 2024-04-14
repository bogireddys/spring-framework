package restassured.filters;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.response.Response;

public class ErrorLogFilter {
    public static void main(String[] args) {
        ErrorLoggingFilter errorLoggingFilter = new ErrorLoggingFilter();

        Response response = RestAssured.given()
                .auth().none()
                .filter(errorLoggingFilter)
                .pathParam("codes", "404")
                .baseUri("https://httpbin.org")
                .get("/status/{codes}")
                .then().extract().response();
    }
}
