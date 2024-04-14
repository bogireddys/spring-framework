package restassured.responseFormats;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OctetStreamEncoding {
    public static void main(String[] args) throws IOException {
        Response response = RestAssured.given()
                .auth().none()
                .pathParam("n", "100")
                .get("https://httpbin.org//stream-bytes/{n}")
                .then().extract().response();
        System.out.println("Response Body is : " +response.getBody().asPrettyString());

        File octetFile = new File("C:\\Users\\gnanendra.bogireddy\\Desktop\\Spring\\octet.txt");
        FileWriter fileWriter = new FileWriter(octetFile);
        fileWriter.write(response.getBody().asPrettyString());
        fileWriter.close();
    }
}
