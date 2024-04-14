package restassured.requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE {
    public static void main(String[] args) {
        Response response = RestAssured
                .given().auth().none()
                .when().delete("https://httpbin.org/delete")
                .then().extract().response();
        System.out.println("Response status code for DELETE : " +response.getStatusCode() + "  status line is : " +response.getStatusLine());
        System.out.println("Response body for DELETE : " +response.body().asPrettyString());
    }
}
