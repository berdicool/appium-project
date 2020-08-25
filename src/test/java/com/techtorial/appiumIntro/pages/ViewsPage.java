package com.techtorial.appiumIntro.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewsPage {
    private  ViewsPage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static ViewsPage getViewsPage(AndroidDriver driver){
        return new ViewsPage(driver);
    }

    @AndroidFindBy(accessibility = "Expandable Lists")
    public AndroidElement expandableLists;
    @AndroidFindBy(accessibility = "1. Custom Adapter")
    public AndroidElement customAdapterButton;
    @AndroidFindBy(uiAutomator = "text(\"Fish Names\")")
    public AndroidElement fishNamesButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fish Names']/" +
            "following-sibling::android.widget.TextView")
    public List<AndroidElement> fishNames;
    @AndroidFindBy(uiAutomator = "text(\"Dog Names\")")
    public AndroidElement dogNamesButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[position()>1]")
    public List<AndroidElement> allText;
    @AndroidFindBy(uiAutomator = "text(\"People Names\")")
    public AndroidElement peopleNames;
    @AndroidFindBy(id = "android:id/title")
    public AndroidElement sampleMenu;


}
