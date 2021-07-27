package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // converting this class to the page object model
    public LoginPage(){
        // PageFactory class allows us to use driver object with Selenium Page Object Model annotations
        PageFactory.initElements(Driver.get(), this); // "this" means pointing  the element in this page
    }

    @FindBy(id = "user_login")   // It represents driver.findElement method
    public WebElement usernameInput;

    @FindBy(id = "user_password")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement loginButton;

    // It will do common actions for Login module
    public void login(String username, String password) throws InterruptedException {
        // reaching username element and send keys
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click(); // clicking the login button

    }


}
