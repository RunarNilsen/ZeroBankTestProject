package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyPage extends BasePage{

    public Select select;

    public PurchaseForeignCurrencyPage(){

    }

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropdownMenu;



    public List<String> getForeignCurrencyList(){
        select = new Select(currencyDropdownMenu);
        List<WebElement> dropdownMenuList = select.getOptions();
        List<String> actualCurrencyList = BrowserUtils.getElementsText(dropdownMenuList);
        return actualCurrencyList;
    }



}
