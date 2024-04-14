package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationClass {
    public static void main(String[] args) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri("https://httpbin.org")
                .auth().none().relaxedHTTPSValidation();
        Response getResponse = requestSpecification.request(Method.GET, "/get").then().extract().response();
        System.out.println("GET Request response is : " + getResponse.getBody().asPrettyString());

        Response postResponse = requestSpecification.request(Method.POST, "/post").then().extract().response();
        System.out.println("POST Request response is : " + postResponse.getBody().asPrettyString());

        Response putResponse = requestSpecification.request(Method.PUT, "/put").then().extract().response();
        System.out.println("PUT Request response is : " + putResponse.getBody().asPrettyString());

        Response deleteResponse = requestSpecification.request(Method.DELETE, "/delete").then().extract().response();
        System.out.println("DELETE Request response is : " + putResponse.getBody().asPrettyString());
    }
}
