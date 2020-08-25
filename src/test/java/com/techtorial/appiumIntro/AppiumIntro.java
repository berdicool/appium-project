package com.techtorial.appiumIntro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumIntro {

    @Test
    public void intro1(){
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        File apkFile=new File("src\\test\\resources\\AppiumPractice.apk");
        desiredCapabilities.setCapability("deviceName","berdicoolPixel2");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        URL url;
        try {
            url= new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        AndroidDriver<AndroidElement> androidDriver=new AndroidDriver(url,desiredCapabilities);
        AndroidElement element=androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']"));
        element.click();
        androidDriver.navigate().back();
        androidDriver.findElement(By.xpath("Animation")).click();
        androidDriver.navigate().back();
//        androidDriver.findElement(By.xpath("android.widget.TextView")).click();
    }
}
