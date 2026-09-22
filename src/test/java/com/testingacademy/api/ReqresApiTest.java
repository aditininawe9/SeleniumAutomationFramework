package com.testingacademy.api;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ReqresApiTest {
    @Test
    public void verifyGetUserStatusCode() {
        given()
                .when()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200);
    }

    @Test
    public void verifyGetUserDetails() {
        given()
                .when()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200)
                    .body("data.first_name", equalTo("Janet"))
                    .body("data.id", equalTo(2));
    }

    @Test
    public void verifyCreateUser() {
        given()
        .contentType("application/json")
                .body("""
        {
            "name": "Aditi",
            "job": "QA Engineer"
        }
        """)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Aditi"))
                .body("job", equalTo("QA Engineer"));

    }

    @Test
    public void verifyUpdateUser() {
        given()
                .contentType("application/json")
                .body("""
        {
            "name": "Aditi S",
            "job": "QA Engineer"
        }""")
                .when()
                .put("https://reqres.in/api/users/2")
                .then().statusCode(200).body("name", equalTo("Aditi S"));
    }

    @Test
    public void verifyDeleteUser() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }

}
