package restassured.filters;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;

public class LogConfigTest {
    public static void main(String[] args) {
        RestAssured.config = RestAssured.config()
                .logConfig(LogConfig.logConfig()
                        .blacklistDefaultSensitiveHeaders()
                        .blacklistHeader("Accept")
                        .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
                        .enablePrettyPrinting(true));
        Response response = RestAssured.given()
                .auth().none()
                .log().all()
                .get("https://httpbin.org/uuid")
                .then().log().body().extract().response();
    }
}
