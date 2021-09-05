package com.macikgoz.pages.android.google.browser;

import com.macikgoz.utilities.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {

    public HomePage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    @FindBy(xpath="//input[@name='q']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[contains(text(), 'Advanced')]")
     public WebElement AdvancedBtn;

    @FindBy(xpath = "//*[contains(text(), 'Proceed to www')]")
    public WebElement ProceedLnk;


}
