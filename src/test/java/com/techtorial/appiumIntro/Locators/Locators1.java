package com.techtorial.appiumIntro.Locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Locators1 {
    AndroidDriver<AndroidElement> driver;
    @Before
    public void setup() throws MalformedURLException {
        File apkFile=new File("src/test/resources/AppiumPractice.apk");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","berdicoolPixel2");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("newCommandTime","600");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(serverUrl,desiredCapabilities);
    }
    @Test
    public void test1(){
        //xpath
        //className[@attribute='value']
        AndroidElement views=driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        views.click();

    }
    @Test
    public void test2(){
        //id in android driver is resource-id
        AndroidElement views=driver.findElement(By.id("//android:id/text1"));
        //id locator is not unique in this case
        views.click();
    }
    @Test
    public void test3(){
        //accessibilityId
        AndroidElement views=driver.findElementByAccessibilityId("Views");
        views.click();
    }
    @Test
    public void test4(){
        //findElementByAndroidUIAutomator - Andorid sepcific locator
        AndroidElement content=driver.findElementByAndroidUIAutomator("text(\"Content\")");
        content.click();
        AndroidElement storage=driver.findElementByAndroidUIAutomator("text(\"Storage\")");
        storage.click();
        AndroidElement externalStorage=driver.findElementByAndroidUIAutomator("text(\"External Storage\")");
        externalStorage.click();
        List<AndroidElement> deleteButtons=driver.findElementsByAndroidUIAutomator("text(\"DELETE\")");
    }
    @Test
    public void test5(){
        //Selenium name equals to text
        AndroidElement hardware=driver.findElement(By.name("Hardware"));
        hardware.click();
    }

}
