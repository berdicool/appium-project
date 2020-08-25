package com.techtorial.appiumIntro.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private MainPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    public static MainPage getMainPage(AndroidDriver driver){
        return new MainPage(driver);
    }
    @AndroidFindBy(xpath = "//*[@text='Accessibility']")
    public AndroidElement accessibility;
    @AndroidFindBy(uiAutomator = "text(\"Animation\")")
    public AndroidElement animation;
    @AndroidFindBy(accessibility = "App")
    public AndroidElement app;
    @AndroidFindBy(accessibility = "Content")
    public AndroidElement content;
    @AndroidFindBy(accessibility = "Graphics")
    public AndroidElement graphics;
    @AndroidFindBy(accessibility = "Hardware")
    public AndroidElement hardware;
    @AndroidFindBy(accessibility = "Media")
    public AndroidElement media;
    @AndroidFindBy(accessibility = "NFC")
    public AndroidElement nfc;
    @AndroidFindBy(accessibility = "OS")
    public AndroidElement os;
    @AndroidFindBy(accessibility = "Preference")
    public AndroidElement preference;
    @AndroidFindBy(accessibility = "Security")
    public AndroidElement security;
    @AndroidFindBy(accessibility = "Text")
    public AndroidElement text;
    @AndroidFindBy(accessibility = "Views")
    public AndroidElement views;
}
