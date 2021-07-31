package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityNavigationPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefinitions {

    @Given("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() throws InterruptedException {
        new AccountActivityNavigationPage().navigateToModule("Account Activity");
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        new AccountActivityNavigationPage().navigateToTab(transactionsPage.findTransactionTab);

    }

    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String fromDate, String toDate) {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        transactionsPage.fromDate.clear();
        transactionsPage.fromDate.sendKeys(fromDate);
        transactionsPage.toDate.clear();
        transactionsPage.toDate.sendKeys(toDate);
    }

    @And("clicks search")
    public void clicksSearch() {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        transactionsPage.clickFindButton();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String fromDate1, String toDate1) throws ParseException {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        List<String> dateListAsString = transactionsPage.getTransactionsDates();
        System.out.println("dateListAsString = " + dateListAsString);
        Assert.assertTrue(transactionsPage.isInDateRange(fromDate1, toDate1, dateListAsString));

    }

    @And("the results should be sorted by most recent date")
    public void theResultsShouldBeSortedByMostRecentDate() throws ParseException {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        // getting the dates of the each row as list of String
        List<String> listOfDates = transactionsPage.getTransactionsDates();
        BrowserUtils.waitFor(3);
        // checking the if dates are sorted by most recent date
        transactionsPage.isFromMostRecentDate(listOfDates);
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String date) {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        List<String> listOfDates = transactionsPage.getTransactionsDates();
        Assert.assertFalse("Verify that specified date is not placed in the String list",listOfDates.contains(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        transactionsPage.descriptionBox.clear();
        transactionsPage.descriptionBox.sendKeys(string);
    }


    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        FindTransactionsPage transactionsPage = new FindTransactionsPage();
        List<String> listOfDescriptions = transactionsPage.getTransactionsDescription();
        boolean bool = transactionsPage.checkListContaining(listOfDescriptions, string);
        Assert.assertTrue("Check is a list has specified string",bool);
    }


    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }







}
