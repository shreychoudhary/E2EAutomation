package tests.api;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import base.BaseAPI;
import io.restassured.http.ContentType;

public class LoginAPITest extends BaseAPI {

    @Test
    public void loginApi() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"email\":\"eve.holt@reqres.in\",\"password\":\"cityslicka\"}")
        .when()
            .post("/api/login")
        .then()
            .statusCode(200);
    }
}
