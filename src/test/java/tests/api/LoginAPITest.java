package tests.api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base.BaseAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginAPITest extends BaseAPI {

    @Test
    public void loginApi() {
        Response response=given()
            .contentType(ContentType.JSON)
        .when()
            .get("/products")
        .then()
            .statusCode(200)
            .extract().response();
        System.out.println(response.asPrettyString());
    }
}
