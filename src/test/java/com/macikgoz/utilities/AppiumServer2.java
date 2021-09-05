package com.macikgoz.utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer2 {


    private static AppiumDriverLocalService appiumService;
    private static int port = 4723;
    private static String nodeJS_Path = "C:/Program Files/NodeJS/node.exe";
    private static String appiumJS_Path = "C:/Program Files/Appium/node_modules/appium/bin/appium.js";

    private static String osName = System.getProperty("os.name");

    public static void start()
    {
        if (osName.contains("Mac"))
        {
            appiumService = AppiumDriverLocalService.buildService (
                    new AppiumServiceBuilder()
                        .usingDriverExecutable(new File(("/usr/local/bin/node")))
                        .withAppiumJS(new File (("usr/local/bin/appium")))
                        .withIPAddress("0.0.0.0")
                        .usingPort(port)
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withLogFile(new File("build/appium.log")));
        }
        else if (osName.contains("Windows"))
        {

            appiumService = AppiumDriverLocalService.buildService (
                    new AppiumServiceBuilder()
                            .usingDriverExecutable(new File(nodeJS_Path))
                            .withAppiumJS(new File (appiumJS_Path))
                            .withIPAddress("0.0.0.0")
                            .usingPort(port)
                            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                            .withLogFile(new File("build/appium.log")));

        }

        appiumService.start();
    }


    public static void stop()
    {
        System.out.println("Trying to  shut the server down !!");

        if ( appiumService == null)
            return;

        appiumService.stop();
        appiumService = null;
        System.out.println("Server is shutting down !!");

        Driver.closeDriver();
        System.out.println("Driver is being shut down !!");

    }

} // class
