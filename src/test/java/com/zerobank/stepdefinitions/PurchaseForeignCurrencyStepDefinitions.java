package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
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



    }



