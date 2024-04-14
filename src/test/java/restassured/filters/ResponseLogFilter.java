package restassured.filters;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseLogSpecification;

public class ResponseLogFilter {
    public static void main(String[] args) {
        ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter(LogDetail.ALL);

        Response response = RestAssured.given()
                .auth().none()
                .filter(responseLoggingFilter)
                .baseUri("https://httpbin.org")
                .contentType(ContentType.URLENC)
                .formParam("custname", "Bogireddy Gnanendra Reddy")
                .formParam("custtel", "0000000000")
                .formParam("custemail", "meetxxxxxxxxxhere@gmail.com")
                .formParam("size", "medium")
                .formParam("topping", "cheese")
                .formParam("topping", "mushroom")
                .formParam("delivery", "19:00")
                .formParam("comments", "Dont ring the bell")
                .post("/post").then().extract().response();
    }
}
