package com.zerobank.stepdefinitions;


import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class LoginStepDefinitions {
    @Given("navigate login page")
    public void navigate_login_page() throws InterruptedException {
        System.out.println("I open browser and navigate to vytrack login page");
        String url = ConfigurationReader.get("url");
        Driver.get().get(url); // navigating to the webpage
    }

    @Then("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }



}
