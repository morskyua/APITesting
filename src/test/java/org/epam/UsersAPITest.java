package org.epam;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsersAPITest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
    }

    @Test
    public void statusCodeTest() {
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void headerTest() {
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test
    public void sizeTest() {
        given()
                .when()
                .get()
                .then()
                .assertThat()
                .body("size()", equalTo(10));
    }

    @Test
    public void deleteTest() {
        given()
                .when()
                .delete("/1")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void patchTest() {
        given()
                .body("""
                        {
                        "name": "John"
                        }
                        """)
                .when()
                .patch("/1")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void postTest() {
        String s = """
                    "name": "Leanne Graham",
                    "username": "Brat",
                    "email": "Sincere@april.biz",
                    "address": {
                      "street": "Kulas Light",
                      "suite": "Apt. 556",
                      "city": "Gwenborough",
                      "zipcode": "92998-3874",
                      "geo": {
                        "lat": "-37.3159",
                        "lng": "81.1496"
                      }
                    },
                    "phone": "1-770-736-8031 x56442",
                    "website": "hildegard.org",
                    "company": {
                      "name": "Romaguera-Crona",
                      "catchPhrase": "Multi-layered client-server neural-net",
                      "bs": "harness real-time e-markets"
                    }
                """;
        given()
                .body(s)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED);
    }

}
