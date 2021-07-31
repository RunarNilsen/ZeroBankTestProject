package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityNavigationPage extends BasePage{

    @FindBy(linkText = "Savings")   // It represents driver.findElement method
    public WebElement savingText;

    @FindBy(xpath = "//li[@id='account_activity_tab'][@class='active']")
    public WebElement accountActivityTab;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement dropdownMenu;

    @FindBy(linkText = "Brokerage")   // It represents driver.findElement method
    public WebElement BrokerageText;

    @FindBy(linkText = "Checking")   // It represents driver.findElement method
    public WebElement CheckingText;

    @FindBy(linkText = "Credit Card")   // It represents driver.findElement method
    public WebElement creditCardText;

    @FindBy(linkText = "Loan")   // It represents driver.findElement method
    public WebElement loanText;

}
