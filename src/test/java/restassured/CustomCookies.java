package restassured;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.Map;

public class CustomCookies {
    public static void main(String[] args) {
        Response response = RestAssured.given()
                .auth().none()
                .cookies("Cookie1", "CookieValue")
                .get("https://httpbin.org/cookies")
                .then().extract().response();

        System.out.println("GET Request response is : " + response.getBody().asPrettyString());
        System.out.println("Validation custom cookies are present or not : " + response.getBody().asPrettyString().contains("cookies"));
        Cookies cookies = response.detailedCookies();
        for(Cookie cookie : cookies.asList()) {
            System.out.println("Cookie name : " + cookie.getName());
            System.out.println("Cookie value : " + cookie.getValue());
            System.out.println("Cookie path : " + cookie.getPath());
            System.out.println("Cookie comment : " + cookie.getComment());
        }


    }
}
