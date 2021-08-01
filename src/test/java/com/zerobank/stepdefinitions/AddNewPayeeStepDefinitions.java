package com.zerobank.stepdefinitions;

import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class AddNewPayeeStepDefinitions {

    @When("the user clicks on {string} module")
    public void the_user_clicks_on_module(String string) {
        AddNewPayeePage payeePage = new AddNewPayeePage();
        payeePage.navigateToModule(string);
    }

    @Given("Navigate {string} tab")
    public void navigate_tab(String string) {
        AddNewPayeePage payeePage = new AddNewPayeePage();
        payeePage.navigateToTab(Driver.get().findElement(By.linkText(string)));

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeInformation) {
        AddNewPayeePage payeePage = new AddNewPayeePage();
        payeePage.payeeNameBox.sendKeys(payeeInformation.get("Payee Name"));
        payeePage.payeeAddressBox.sendKeys(payeeInformation.get("Payee Address"));
        payeePage.payeeAccountBox.sendKeys(payeeInformation.get("Account"));
        payeePage.payeeDetailsBox.sendKeys(payeeInformation.get("Payee Details"));
        payeePage.addButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String string) {
        AddNewPayeePage payeePage = new AddNewPayeePage();
        String actualText= payeePage.alertText.getText();
        Assert.assertEquals("Verify that actual text is the same with expected text: ", string, actualText);
    }




}
