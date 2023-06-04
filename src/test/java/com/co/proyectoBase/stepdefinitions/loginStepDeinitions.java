package com.co.proyectoBase.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.co.proyectoBase.stepdefinitions.setupConfiguration.User;
import static com.co.proyectoBase.task.LoginTask.withCredentials;
import static com.co.proyectoBase.task.OpenPage.openPage;

public class loginStepDeinitions {
    @Given("that the user is in the application")
    public void that_the_user_is_in_the_application() {
        String url = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
        User.attemptsTo(openPage(url));
        User.attemptsTo(withCredentials("user","user"));
    }
    @When("the user logs in successfully")
    public void the_user_logs_in_successfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should see a success message displayed")
    public void the_user_should_see_a_success_message_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
