package com.macikgoz.tests;

import com.macikgoz.utilities.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class BaseTest extends Base {

    boolean real_device = Boolean.parseBoolean(ConfigurationReader.getProperty("real_device").trim());


    @BeforeSuite
    public void setupBeforeTest()
    {
        if ( !real_device )
        {
            Emulator.launchEmulator();
        }
    }


    @AfterSuite //@AfterTest
    public void tearDown() throws InterruptedException {

        if ( !real_device )
        {
            Emulator.closeEmulator();
        }

            Thread.sleep(10000);
    }


    @BeforeMethod
    public void BeforeTestExecution() throws InterruptedException {
        AppiumServer.start();
        driver = Driver.getDriver();
        Thread.sleep(5000);
        System.out.println(" -->> App is running :"+ isAppRunning());
    }


    private boolean isAppRunning() throws InterruptedException {
        String appId = driver.getCurrentPackage();
        System.out.println(" -->> appId = " + appId);

        ApplicationState state = driver.queryAppState(appId);
        System.out.println(" -->> App state = " + state.toString());

        return state.equals(ApplicationState.RUNNING_IN_FOREGROUND);
    }


    @AfterMethod
    public void AfterTestExecution() throws InterruptedException {

        Thread.sleep(10000);
        Driver.getDriver().closeApp();
        AppiumServer.stop();
        Thread.sleep((2000));
    }


}
