package com.macikgoz.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Base {

    protected static AndroidDriver<AndroidElement> driver ;

    public static Integer implicitlyWaitTime = Integer.parseInt(ConfigurationReader.getProperty("implicitWaitTime"));
    public static Integer shortWaitTime = Integer.parseInt(ConfigurationReader.getProperty("shortWaitTime"));
    public static Integer pageLoadTimeoutTime = Integer.parseInt(ConfigurationReader.getProperty("pageLoadTimeoutTime"));

    protected static final String baseUrl = ConfigurationReader.getProperty("baseUrl").trim();

}
