package com.macikgoz.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver extends Base {

    private Driver(){}

    public static AndroidDriver <AndroidElement> getDriver()  {

        if (driver == null) {

            DesiredCapabilities caps = new DesiredCapabilities();


            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

            Boolean isRealDevice =Boolean.parseBoolean(ConfigurationReader.getProperty("real_device").trim());
            Boolean isMobileBrowser =Boolean.parseBoolean(ConfigurationReader.getProperty("mobile_browser").trim());

            if (isRealDevice) {
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidUtils Device");
                System.out.println("Real Device is set");
            }
            else {
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationReader.getProperty("device_name").trim());
                System.out.println("Emulator is set");
            }


            if (isMobileBrowser){
                caps.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);

                // Handling “Your connection to this site is not private” popup on Chrome using Selenium
                caps.setCapability (MobileCapabilityType.ACCEPT_SSL_CERTS, true);

                System.out.println("Mobile Browser is set");
            }
            else
            {
                File appDir = new File("src\\test\\resources");
                File app = new File(appDir, ConfigurationReader.getProperty("app").trim());

                caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath() );
                System.out.println("-->> "+ app.getAbsoluteFile());
            }


            // To let it wait for XX secs fro client to send a command.
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 150);

            try {
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
                System.out.println("-->> " + "driver is instantiated! ");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

         return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver = null;
        }
    }

}
