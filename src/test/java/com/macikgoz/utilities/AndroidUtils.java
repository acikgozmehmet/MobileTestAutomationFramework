package com.macikgoz.utilities;

import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AndroidUtils {

    public static  void pressBackBtn()
    {
        Driver.getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void changeContextToNativeApp()
    {
        if (! Driver.getDriver().getContext().equals("NATIVE_APP"))
            Driver.getDriver().context("NATIVE_APP");
    }


    // This is the only gesture in android mobile browser. This is not possible with iOS
    public static void scroll()
    {
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.scrollBy(0,1000)","");
    }



    // Hardware KeyEvents ...
    public static void pressKey(String keyStr)
    {
        KeyEvent keyEvent = null;
        switch (keyStr.toLowerCase())
        {
            case "back":
                keyEvent = new KeyEvent(AndroidKey.BACK);
                break;
            case "home":
                keyEvent = new KeyEvent(AndroidKey.HOME);
                break;
            case "forward":
                keyEvent = new KeyEvent(AndroidKey.FORWARD);
                break;

        }
        Driver.getDriver().pressKey(keyEvent);

    }


    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}
