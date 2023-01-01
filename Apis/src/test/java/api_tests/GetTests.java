package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GetTests {

    @Test
    public void testStatusCode() {
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()   // assertions
                .log().all()
                .and()
                .statusCode(200)
                .and()
                .body("data[0].id", equalTo(7));
    }

    @Test
    public void testUser2Objects() {
        when().
                get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200)
                .and()
                .body("data.email", equalTo("janet.weaver@reqres.in"));
    }

    @Test
    public void testUser2ObjectsWithTestNG() {
        Response response = when().get("https://reqres.in/api/users/2").then().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("data.email").toString(), "janet.weaver@reqres.in");
        Assert.assertEquals(response.jsonPath().get("data.last_name").toString(), "Weaver");

    }

    @Test
    public void testUser23IsNotFound() {
        Response response = when().get("https://reqres.in/api/users/23").then().extract().response();

        Assert.assertEquals(response.statusCode(), 404);
        Assert.assertNull(response.jsonPath().get("data"));

    }

    @Test
    public void testCreateNewUser() {
        String requestBody = "{\n" +
                "    \"name\": \"Kareem\",\n" +
                "    \"job\": \"tester\"\n" +
                "}";


        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .and()
                        .body(requestBody)
                        .post("https://reqres.in/api/users").then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Kareem");
        Assert.assertEquals(response.jsonPath().get("job").toString(), "tester");


    }

    @Test
    public void testUpdateExistingUserUsingPut() {
        String requestBody = "{\n" +
                "    \"name\": \"Alaa\",\n" +
                "    \"job\": \"Pilot\"\n" +
                "}";


        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .and()
                        .body(requestBody)
                        .put("https://reqres.in/api/users/2").then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Alaa");
        Assert.assertEquals(response.jsonPath().get("job").toString(), "Pilot");


    }

    @Test
    public void testUpdateExistingUserUsingPatch() {
        String requestBody = "{\n" +
                "    \"name\": \"Hossam\",\n" +
                "    \"job\": \"Pilot\"\n" +
                "}";


        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .and()
                        .body(requestBody)
                        .patch("https://reqres.in/api/users/2").then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name").toString(), "Hossam");
        Assert.assertEquals(response.jsonPath().get("job").toString(), "Pilot");


    }

    @Test
    public void testDeleteExistingUser() {

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .and()
                        .delete("https://reqres.in/api/users/2").then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 204);

    }

    @Test
    public void testCreateToken() {
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .and()
                        .post("https://reqres.in/api/login").then().log().all().extract().response();

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");

    }


}
