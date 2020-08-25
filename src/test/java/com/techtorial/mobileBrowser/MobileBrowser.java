package com.techtorial.mobileBrowser;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MobileBrowser {
    AndroidDriver driver;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"berdicoolPixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        desiredCapabilities.setBrowserName(BrowserType.CHROME);
        desiredCapabilities.setCapability("chromedriverExecutable",
                "C:\\Users\\berdi\\IdeaProjects\\appium\\src\\test\\resources\\chromedriver.exe");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(url,desiredCapabilities);
    }
    @Test
    public void test1(){
        driver.get("https://www.google.com");
        //rest is selenium

    }
}
