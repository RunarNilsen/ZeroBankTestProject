package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage extends BasePage{
    WebDriverWait wait;
    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(), this);
        wait = new WebDriverWait(Driver.get(), 10);
    }

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionTab;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDate;

    @FindBy(css = "#aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement findButton;

    @FindBy(css = "#aa_description")
    public WebElement descriptionBox;

    @FindBy(css = "#filtered_transactions_for_account>table>tbody>tr:first-child>td")
    public WebElement firstDate;


    @FindBy(css = "#filtered_transactions_for_account>table>tbody>tr:last-child>td")
    public WebElement lastDate;

   String tableLocatorAddress="#filtered_transactions_for_account>table>tbody>tr";




    public List<WebElement> getRowsOfTableAsWebelement(String tableCssLocatorAddress){
        /**
         This method gets the rows of a table as a List<WebElement>

         Parameters:
         tableCssLocatorAddress: Css locator of the table

         Return: A List<WebElement>
         */
        List<WebElement> tableRows = Driver.get().findElements(By.cssSelector(tableCssLocatorAddress));
        return tableRows;
    }

    public List<String> getTransactionsDates(){
        /**
         This method gets the transaction dates that are placed first column of a table,
         and stores them in a String List

         Parameters:

         Return: A Sring list that contains the dates
         */
        List<String> dateList = new ArrayList<>();
        int totalRowNumber = getRowsOfTableAsWebelement(tableLocatorAddress).size();
        System.out.println("totalRowNumber = " + totalRowNumber);
        for (int i=1; i<= totalRowNumber; i++) {
           String date= Driver.get().findElement(By.cssSelector("#filtered_transactions_for_account>table>tbody>tr:nth-child("+i+")>td")).getText();
            dateList.add(date);
        }

        return dateList;
    }

    public void clickFindButton(){
        /**
         This method clicks the "find" button and waits until the located element is presence
         */
        findButton.click();
        //till table shows up
        BrowserUtils.waitFor(1);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#filtered_transactions_for_account>table")));
    }

    public List<Date> convertDatesInListStringToDateInListDate(List<String> dateListAsString) throws ParseException {
        /**
         This method converts String List to Date List

         Parameters:
         dateListAsString: The String list of the dates

         Return: Dates as Date List
         */
        List<Date> dateListAsDate = new ArrayList<>();
        for (String dateAsString : dateListAsString) {
            dateListAsDate.add(new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString));
        }
        return dateListAsDate;
    }

    public boolean isFromMostRecentDate(List<String> dateListAsString){
        /**
         This method is checking if the dates are sorted by most recent date

         Parameters:
         dateListAsString: The String list of the dates

         Return: true or false
         */

        List<String> copyOfList = new ArrayList<>();
        for (String s : dateListAsString) {
            copyOfList.add(s);
        }

        Collections.sort(copyOfList);
        int size = dateListAsString.size();
        for (int i = size - 1; i >= 0 ; i--) {
            if (!dateListAsString.get(i).equals(copyOfList.get(size - i - 1))){
                return false;
            }
        }
        return true;
    }


    public Date convertDateFromString(String dateAsString) throws ParseException {
        /**
         This method converts string type to date type

         Parameters:
         dateAsString  : Last date of the specified date range
         dateListAsString: The String list of the dates

         Return: date type
         */
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateAsString);
        return date;
    }

    public boolean isInDateRange(String fromDateAsString, String toDateAsString, List<String> dateListAsString) throws ParseException {
        /**
        This method is checking if the dates in the String list are between specified two dates

        Parameters:
        fromDateAsString: First date of the specified date range
        toDateAsString  : Last date of the specified date range
        dateListAsString: The String list of the dates

        Return: true or false
         */
        Date fromDate = convertDateFromString(fromDateAsString);
        Date toDate = convertDateFromString(toDateAsString);
        System.out.println("here1");
        List<Date> dateList = convertDatesInListStringToDateInListDate(dateListAsString);
        System.out.println("here2");
        for (Date date : dateList) {
            System.out.println("here3");
            if ((date.compareTo(fromDate) >= 0) && (date.compareTo(toDate) <= 0)){
                System.out.println("here4");
                continue;
            }else{
                return false;
            }
        }
        System.out.println("here5");
        return true;


    }

    public List<String> getTransactionsDescription(){
        /**
         This method gets the transaction description that are placed second column of a table,
         and stores them in a String List

         Parameters:
         Return: A String list that contains the descriptions of transactions
         */
        List<String> descriptionList = new ArrayList<>();
        int totalRowNumber = getRowsOfTableAsWebelement(tableLocatorAddress).size();
        System.out.println("totalRowNumber = " + totalRowNumber);
        for (int i=1; i<= totalRowNumber; i++) {
            String description= Driver.get().findElement(By.cssSelector("#filtered_transactions_for_account>table>tbody>tr:nth-child("+i+")>td:nth-child(2)")).getText();
            descriptionList.add(description);
        }
        return descriptionList;
    }

    public boolean checkListContaining(List<String> listOfDescriptions, String desiredString){
        for (String listOfDescription : listOfDescriptions) {
            if (listOfDescription.startsWith(desiredString)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }








}
