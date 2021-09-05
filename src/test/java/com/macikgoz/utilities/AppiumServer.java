package com.macikgoz.utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AppiumServer {

    /**
     * the following dependencies have to be imported to the pom file.
     *
     *            <artifactId>slf4j-simple</artifactId>
     *             <artifactId>slf4j-api</artifactId>
     *             <artifactId>commons-lang3</artifactId>
     *             <artifactId>commons-io</artifactId>
     *             <artifactId>commons-validator</artifactId>
     *
     */



    private static AppiumDriverLocalService appiumService;
    private  static int port = Integer.parseInt(ConfigurationReader.getProperty("port").trim());

    public static AppiumDriverLocalService start()
    {

        killService();

        if ( ! IsServerRunning() )  // --> appiumService.isRunning() can also be used
        {
            appiumService = AppiumDriverLocalService.buildDefaultService();
            appiumService.start();
        }

        System.out.println("Appium Server is  starting ....");
        return appiumService;

    }


    public static void stop()
    {
        System.out.println("Trying to  shut the server down !!");

        if ( appiumService == null)
            return;

        appiumService.stop();
        System.out.println("Server is shutting down !!");

        Driver.closeDriver();
        System.out.println("Driver is being shut down !!");

    }



    public static boolean IsServerRunning()
    {
        boolean isServerRunning = false;
        ServerSocket serverSocket;

        try
        {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }
        catch (IOException ex)
        {
            isServerRunning = true;
        }
        finally {
            serverSocket = null;
        }

        return isServerRunning;

    }

    public static void killService()
    {
        String command = "taskkill /F /IM node.exe";
        try {

            Runtime.getRuntime().exec(command);
            Thread.sleep(6000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


} // class
