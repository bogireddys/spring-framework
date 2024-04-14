package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class CustomHeaders {
    public static void main(String[] args) {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Header1", "Value1");
        headersMap.put("Header2", "Value2");

        Response response = RestAssured.given()
                .headers(headersMap)
                .auth().none()
                .get("https://httpbin.org/headers")
                .then().extract().response();

        System.out.println("GET Request response is : " + response.getBody().asPrettyString());
        System.out.println("Validation custom headers are present or not : " + response.getBody().asPrettyString().contains("Header1"));
        Headers responseHeaders = response.getHeaders();
        for (Header header : responseHeaders) {
            System.out.println("Custom Header Keys are : " + header.getName());
            System.out.println("Custom Header Value's are : " + header.getValue());
        }

    }
}
