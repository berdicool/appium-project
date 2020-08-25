package com.techtorial.mobileBrowser;

import com.techtorial.appiumIntro.pages.eCommerce.MainPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class eCommerceApp {
    AndroidDriver<AndroidElement> driver;
    MainPage mainPage;
    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        File apkFile=new File("src\\test\\resources\\Store.apk");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"berdicoolPixel2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,600);
        URL url = new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(url,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage=MainPage.getMainPage(driver);
    }
    @Test
    public void test1(){
        mainPage.countryDropdown.click();
        AndroidElement brazil=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Brazil\"));");
        brazil.click();
    }
    @Test
    public void test2(){
        mainPage.countryDropdown.click();
        mainPage.albania.click();
        mainPage.nameField.sendKeys("Akyl");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(tapOptions().withElement(element(mainPage.letsShopButton))).perform();
    }
    @Test
    public void test3(){
        mainPage.letsShopButton.click();
        AndroidElement toastMessage=driver.findElementByXPath("//android.widget.Toast");
        Assert.assertEquals("Please enter your name", toastMessage.getAttribute("name"));

    }
}
