package com.macikgoz.utilities;

import java.io.PrintWriter;

public class Emulator2 {
    /*
    *  This class is replaced with Emulator. It still works but it is obselete now.
    *
    */

    public static void start()  {
//        String command = "emulator -avd " + ConfigurationReader.getProperty("device_name");
        String command = "emulator -avd "+ ConfigurationReader.getProperty("device_name") +" & adb wait-for-device";
//        String command = "emulator -avd "+ ConfigurationReader.getProperty("device_name") +" & adb wait-for-device shell 'while [[ -z $(getprop sys.boot_completed) ]]; do sleep 1; done;'";
        String appDir = "C:\\Users\\myUser\\AppData\\Local\\AndroidUtils\\Sdk\\emulator";


        try {

            PrintWriter writer = new PrintWriter("startEmulator.bat", "UTF-8");
            writer.println("cd "+ appDir);
            writer.println(command);
            writer.close();

            Thread.sleep(3000);
            System.out.println("Emulator is starting...");
            Runtime.getRuntime().exec("startEmulator.bat");
            Thread.sleep(60000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close()
    {
        String command = "taskkill /F /IM qemu-system-x86_64.exe";

        try {

            Runtime.getRuntime().exec(command);
            Thread.sleep(6000);
            System.out.println("Emulator is shutting down");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

} // class
