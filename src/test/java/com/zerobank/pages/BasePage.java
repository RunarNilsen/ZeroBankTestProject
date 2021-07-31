package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public WebElement user;

    @FindBy(css = "#logout_link")
    public WebElement logOut;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']")
    public List<WebElement> menuOptions;


    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(user);
        BrowserUtils.clickWithJS(logOut);
    }

    public void navigateToModule(String tab) {
        // MAKE SURE THAT GİVE ENOUGH TİME TO WAIT

        String tabLocator = tab.toLowerCase().replace(" ", "_") + "_tab";
        try {
            BrowserUtils.waitForClickablility(By.id(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.id(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.id(tabLocator), 5);
        }

    }

    public void navigateToTab(WebElement element){
        new Actions(Driver.get()).moveToElement(element).pause(200).doubleClick(element).build().perform();
    }





}
