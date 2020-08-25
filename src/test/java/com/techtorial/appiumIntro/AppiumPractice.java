package com.techtorial.appiumIntro;

import com.techtorial.appiumIntro.pages.ContentPage;
import com.techtorial.appiumIntro.pages.MainPage;
import com.techtorial.appiumIntro.pages.StoragePage;
import com.techtorial.appiumIntro.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;


public class AppiumPractice {
    private AndroidDriver<AndroidElement> driver;
    MainPage mainPage;
    ContentPage contentPage;
    StoragePage storagePage;
    @Before
    public void setup() throws MalformedURLException {
        driver=CommonUtils.getAndroidDriver();
        mainPage=MainPage.getMainPage(driver);
        contentPage=new ContentPage(driver);
        storagePage=new StoragePage(driver);
    }
    @Test
    public void test1(){
        mainPage.content.click();
        contentPage.storage.click();
        storagePage.externalStorage.click();
        Assert.assertTrue(storagePage.created1.isDisplayed());
        Assert.assertTrue(storagePage.created3.isEnabled());
        Assert.assertTrue(!storagePage.deleted3.isEnabled());
        storagePage.created3.click();
        Assert.assertTrue(storagePage.deleted3.isEnabled());
    }
}
