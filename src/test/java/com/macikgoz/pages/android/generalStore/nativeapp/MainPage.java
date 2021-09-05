package com.macikgoz.pages.android.generalStore.nativeapp;

import com.macikgoz.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public MainPage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(id="android:id/text1")
    public WebElement dropDownBox;


    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    public WebElement editBox;


    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    public WebElement femaleRadioBtn;


    public WebElement selectCountry(String country)
    {
        String path = "//android.widget.TextView[@text=\"" + country + "\"]";
        System.out.println("xpath : " + path);
        WebElement element  = Driver.getDriver().findElementByXPath(path);
        return element;
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public WebElement letsShopBtn;


    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public WebElement ToastMessage;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/rvProductList")
    public WebElement productsListId;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName" )
    public List<WebElement> productNames;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart" )
    public List<WebElement> productAddToCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice" )
    public List<WebElement> productPrices;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl" )
    public WebElement totalPurchaseAmount;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    public WebElement Cart;

    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement checkBox;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Please read our terms of conditions\"")
    public WebElement consent;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    public WebElement contextSwitchBtn;

}
