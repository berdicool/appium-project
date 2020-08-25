package com.techtorial.appiumIntro;

import com.techtorial.appiumIntro.pages.MainPage;
import com.techtorial.appiumIntro.pages.ViewsPage;
import com.techtorial.appiumIntro.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class AppiumPractice1 {
    AndroidDriver<AndroidElement> driver;
    MainPage mainPage;
    ViewsPage viewsPage;
    DesiredCapabilities desiredCapabilities;
    @Before
    public void setup() throws MalformedURLException {
        driver= CommonUtils.getAndroidDriver();
        mainPage=MainPage.getMainPage(driver);
        viewsPage=ViewsPage.getViewsPage(driver);
        desiredCapabilities=CommonUtils.getDesiredCapabilities();
    }
    @Test
    public void test1(){
        mainPage.views.click();
        viewsPage.expandableLists.click();
        viewsPage.customAdapterButton.click();
        viewsPage.fishNamesButton.click();
        for (AndroidElement x:viewsPage.fishNames){
            System.out.println(x.getText());
        }
    }
    @Test
    public void test2(){
        mainPage.views.click();
        viewsPage.expandableLists.click();
        viewsPage.customAdapterButton.click();
        viewsPage.dogNamesButton.click();
        for (AndroidElement x:viewsPage.allText) {
            String text=x.getText();
            if(!text.contains("Names")){
                System.out.println(text);
            }
        }
    }
}
