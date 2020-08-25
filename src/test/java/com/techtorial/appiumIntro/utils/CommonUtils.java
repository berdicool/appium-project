package com.techtorial.appiumIntro.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class CommonUtils {
    private static AndroidDriver<AndroidElement> driver;

    public static DesiredCapabilities getDesiredCapabilities(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        File apkFile=new File("src\\test\\resources\\AppiumPractice.apk");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"berdicoolPixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        return desiredCapabilities;
    }
    public static AndroidDriver<AndroidElement> getAndroidDriver() throws MalformedURLException {
        if (driver==null) {
            URL url = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(url, getDesiredCapabilities());
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }
        return driver;
    }
}
