package com.macikgoz.pages.android.apiDemos.nativeapp;

import com.macikgoz.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
    public WebElement Preferences;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
    public WebElement Views;

}
