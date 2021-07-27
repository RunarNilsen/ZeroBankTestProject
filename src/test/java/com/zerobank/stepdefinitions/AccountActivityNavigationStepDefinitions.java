package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityNavigationPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefinitions{

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountActivityNavigationPage accountActivityNavigationPage = new AccountActivityNavigationPage();
        accountActivityNavigationPage.savingText.click();
        BrowserUtils.waitFor(5);
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        AccountActivityNavigationPage activityPage = new AccountActivityNavigationPage();
        String actualText = activityPage.accountActivityTab.getText();
        String expectedText = "Account Activity";
        Assert.assertEquals("Account Activity is supposed to be seen",expectedText,actualText);

    }

    @Then("Account drop down should have selected {string}")
    public void account_drop_down_should_have_selected(String expectedText)  {
        AccountActivityNavigationPage activityPage = new AccountActivityNavigationPage();
        Select dropDown = new Select(activityPage.dropdownMenu);
        String selected = dropDown.getFirstSelectedOption().getText();
        String expected = expectedText;
        Assert.assertEquals(expected,selected);

    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountActivityNavigationPage accActivityPage= new AccountActivityNavigationPage();
        accActivityPage.BrokerageText.click();
        BrowserUtils.waitFor(3);
    }

}
