package com.macikgoz.utilities;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emulator {


//    private static String sdkPath = "/Applications/adt-bundle-mac-x86_64-20140702/sdk/";
//    or for windows D:/AndroidUtils/adt-bundle-windows-x86_64-20140702/sdk/

    private static String sdkPath =  "C:\\Users\\myUser\\AppData\\Local\\Android\\Sdk";
    private static String adbPath = sdkPath + File.separator + "platform-tools" + File.separator + "adb";
    private static String emulatorPath = sdkPath + File.separator + "emulator" + File.separator + "emulator";

    /**
     * Starts an emulator for the provided AVD name
     *
     * @param nameOfAVD
     *
     * Source : http://aksahu.blogspot.com/search/label/Appium
     *          http://aksahu.blogspot.com/2016/01/start-or-launch-android-emulator.html
     */
    public static void launchEmulator() {
        String nameOfAVD = ConfigurationReader.getProperty("device_name").trim();
        System.out.println("Starting emulator for '" + nameOfAVD + "' ...");
        String[] aCommand = new String[] { emulatorPath, "-avd", nameOfAVD };
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(45, TimeUnit.SECONDS);
            System.out.println("Emulator launched successfully!");


            SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");
            System.out.println("Emulator is running : " + isEmulatorOrDeviceRunning() + " Time : "+ formatter.format(new Date()) );
//            waitForEmulatorToBeReady();
//            System.out.println("Waited for emulator to be ready" + " Time : "+ formatter.format(new Date()) );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     /**
     * Kills all running emulators
     *
     *
     * Source : http://aksahu.blogspot.com/2016/01/stop-or-kill-android-emulator.html
     */
    public static void closeEmulator() {
        System.out.println("Killing emulator...");
        String[] aCommand = new String[] { adbPath, "emu", "kill" };
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            System.out.println("Emulator closed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * Checks if an emulator or a device is already launched or plugged in
     *
     * Example:

     * List of devices attached

     * 192.168.56.101:5555 device

     * emulator-5554 device
     *
     * @return
     */
    public static boolean isEmulatorOrDeviceRunning() {

        try {
            String[] commandDevices = new String[] { adbPath, "devices" };
            Process process = new ProcessBuilder(commandDevices).start();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String output = "";
            String line = null;
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
                output = output + line;
            }
            if (!output.replace("List of devices attached", "").trim().equals("")) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }




    /**
     * Waits for the emulator to be ready
     */
    public static void waitForEmulatorToBeReady() {
        try {
            String[] commandBootComplete = new String[] { adbPath, "shell", "getprop", "dev.bootcomplete" };
            Process process = new ProcessBuilder(commandBootComplete).start();
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // wait till the property returns '1'
            while (!inputStream.readLine().equals("1")) {
                process.waitFor(1, TimeUnit.SECONDS);
                process = new ProcessBuilder(commandBootComplete).start();
                inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            }

            String[] commandBootAnim = new String[] { adbPath, "shell", "getprop", "init.svc.bootanim" };
            process = new ProcessBuilder(commandBootAnim).start();
            inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // wait till the property returns 'stopped'
            while (!inputStream.readLine().equals("stopped")) {
                process.waitFor(1, TimeUnit.SECONDS);
                process = new ProcessBuilder(commandBootAnim).start();
                inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            }

            System.out.println("Emulator is ready to use!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

} // class
