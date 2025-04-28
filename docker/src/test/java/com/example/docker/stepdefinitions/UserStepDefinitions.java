package com.example.docker.stepdefinitions;

import com.example.docker.model.User;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class UserStepDefinitions {

    private static String baseUrl = "http://localhost:8080/api/users";
    private User user;
    private int userId;  // To store the ID of the created user

    @When("I create a new user with name {string} and email {string}")
    public void createNewUser(String name, String email) {
        user = new User();
        user.setName(name);
        user.setEmail(email);

        // Send a POST request to create the user
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(baseUrl);

        // Assert status code 201 (Created)
        response.then().statusCode(201);

        // Extract the ID of the newly created user
        userId = response.jsonPath().getInt("id");  // Assuming the response includes the user's ID
    }

    @Then("the user should be created with name {string} and email {string}")
    public void verifyUserCreated(String name, String email) {
        // Send a GET request to fetch the user by ID
        RestAssured.given()
                .when()
                .get(baseUrl + "/" + userId)  // Use the userId to get the specific user
                .then()
                .statusCode(200)
                .body("name", equalTo(name))  // Verify name
                .body("email", equalTo(email));  // Verify email
    }
}
