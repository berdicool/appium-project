package com.techtorial.appiumIntro.Gestures;

import com.techtorial.appiumIntro.pages.MainPage;
import com.techtorial.appiumIntro.pages.ViewsPage;
import com.techtorial.appiumIntro.utils.CommonUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class GesturesIntro {
    DesiredCapabilities desiredCapabilities;
    AndroidDriver<AndroidElement> driver;
    TouchAction touchAction;
    MainPage mainPage;
    ViewsPage viewsPage;

    @Before
    public void setup() throws MalformedURLException {
        driver= CommonUtils.getAndroidDriver();
        desiredCapabilities=CommonUtils.getDesiredCapabilities();
        touchAction=new TouchAction(driver);

        mainPage=MainPage.getMainPage(driver);
        viewsPage=ViewsPage.getViewsPage(driver);

    }
    @Test
    public void gesture1(){
        touchAction.tap(tapOptions().withElement(element(mainPage.app))).perform();
        //Tapping once
        driver.navigate().back();
        touchAction.tap(tapOptions().withElement(element(mainPage.os))).perform();
        driver.navigate().back();
        touchAction.tap(tapOptions().withElement(element(mainPage.text))).perform();
        driver.navigate().back();
        touchAction.tap(tapOptions().withElement(element(mainPage.views))).perform();
        driver.navigate().back();
    }
    @Test
    public void test2(){
        //long press
        touchAction.tap(tapOptions().withElement(element(mainPage.views))).perform()
        .tap(tapOptions().withElement(element(viewsPage.expandableLists))).perform()
        .tap(tapOptions().withElement(element(viewsPage.customAdapterButton))).perform()
        .longPress(longPressOptions().withDuration(Duration.ofSeconds(2))
                .withElement(element(viewsPage.peopleNames))).perform();
        Assert.assertEquals("Sample menu", viewsPage.sampleMenu.getText());
    }
}
