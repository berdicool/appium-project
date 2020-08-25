package com.techtorial.appiumIntro.pages.eCommerce;

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

    @AndroidFindBy(className = "android.widget.Spinner")
    public AndroidElement countryDropdown;
    @AndroidFindBy(uiAutomator = "text(\"Albania\")")
    public AndroidElement albania;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement letsShopButton;
}
