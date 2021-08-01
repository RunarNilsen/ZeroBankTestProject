package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefinitions {

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyList) {
        PurchaseForeignCurrencyPage currencyPage = new PurchaseForeignCurrencyPage();
        List<String> actualCurrencyList = currencyPage.getForeignCurrencyList();
        System.out.println(actualCurrencyList);
        actualCurrencyList.remove(0);
        System.out.println(actualCurrencyList);
        System.out.println(expectedCurrencyList);
        Assert.assertTrue(actualCurrencyList.containsAll(expectedCurrencyList));
        }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PurchaseForeignCurrencyPage currencyPage = new PurchaseForeignCurrencyPage();
        currencyPage.calculateCostButton.click();
    }

    @Given("user enters the Amount")
    public void user_enters_the_Amount() {
        PurchaseForeignCurrencyPage currencyPage = new PurchaseForeignCurrencyPage();
        currencyPage.amountBox.sendKeys("100");
    }


    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        try {
            // switch to JS alert
            Alert alert = Driver.get().switchTo().alert();
            String expectedAlertText = "Please, ensure that you have filled all the required fields with valid values.";
            String actualAlertText = alert.getText();
            Assert.assertEquals("Verify alert pops up: ",expectedAlertText, actualAlertText);
            alert.accept();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PurchaseForeignCurrencyPage currencyPage = new PurchaseForeignCurrencyPage();
        currencyPage.currencyDropdownMenu.click();
        currencyPage.select.selectByVisibleText("Eurozone (euro)");
        currencyPage.calculateCostButton.click();
    }




}



