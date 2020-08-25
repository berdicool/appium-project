package com.techtorial.appiumIntro.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class StoragePage {
    public StoragePage(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(accessibility = "External Storage")
    public AndroidElement externalStorage;
    @AndroidFindBy(xpath = "//*[@resource-id='io.appium.android.apis:id/label']//following-sibling::" +
            "android.widget.LinearLayout/android.widget.Button[@text='CREATE']")
    public AndroidElement created1;
    @AndroidFindBy(xpath = "//*[@text='File getExternalFilesDir']//following-sibling::" +
            "android.widget.LinearLayout/android.widget.Button[@text='CREATE']")
    public AndroidElement created3;
    @AndroidFindBy(xpath = "//*[@text='File getExternalFilesDir']//following-sibling::" +
            "android.widget.LinearLayout/android.widget.Button[@text='DELETE']")
    public AndroidElement deleted3;

}
