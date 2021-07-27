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

}
