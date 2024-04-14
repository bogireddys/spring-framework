package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MultipartURLEncoded {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().none()
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

        System.out.println("Response code for POST Request for URL Encode Req : " + response.getStatusCode());
        System.out.println("Response body for POST Request for URL Encode Req : " + response.getBody().asString());

    }
}
