package com.macikgoz.pages.android.apiDemos.nativeapp;

import com.macikgoz.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.ParametersAreNullableByDefault;
import java.util.List;

public class PreferencePage {

    public PreferencePage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
    public WebElement dependencies;

    @AndroidFindBy(id="android:id/checkbox")
    public WebElement checkbox;

    @AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
    public WebElement wifiSettings;


    @AndroidFindBy(className="android.widget.EditText")
    public WebElement wifiSettingsInput;

    @AndroidFindBy(className="android.widget.Button")
    public List<WebElement> CancelOKBtn;

}
