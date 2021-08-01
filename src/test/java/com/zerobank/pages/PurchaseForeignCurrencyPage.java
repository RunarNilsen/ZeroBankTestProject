package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyPage extends BasePage{

    public Select select;

    public PurchaseForeignCurrencyPage(){
        select = new Select(currencyDropdownMenu);
    }

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropdownMenu;

    @FindBy(css = "#pc_amount")
    public WebElement amountBox;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calculateCostButton;




    public List<String> getForeignCurrencyList(){
        List<WebElement> dropdownMenuList = select.getOptions();
        List<String> actualCurrencyList = BrowserUtils.getElementsText(dropdownMenuList);
        return actualCurrencyList;
    }



}
