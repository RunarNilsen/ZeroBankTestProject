package com.zerobank.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends BasePage {

    @FindBy(linkText = "Pay Bills")
    public WebElement payBillsModule;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayeeTab;

    @FindBy(css = "#np_new_payee_name")
    public WebElement payeeNameBox;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddressBox;

    @FindBy(css = "#np_new_payee_account")
    public WebElement payeeAccountBox;

    @FindBy(css = "#np_new_payee_details")
    public WebElement payeeDetailsBox;

    @FindBy(css = "#add_new_payee")
    public WebElement addButton;

    @FindBy(css = "#alert_content")
    public WebElement alertText;







}
