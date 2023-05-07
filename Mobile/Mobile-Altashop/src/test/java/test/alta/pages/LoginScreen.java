package test.alta.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.alta.pageobject.BasePageObject;

public class LoginScreen extends BasePageObject {
    private By ButtonLogin() {
        return  MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button");
    }
    private By emailField(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }
    private By passwordField(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]   ");
    }

    private By loginButton(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Login\"]");
    }

    private By titleHomePage(){ return MobileBy.xpath("//android.view.View[@content-desc=\"Products\"]");
    }

    private By snackbarError(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"Email atau password tidak valid.\"]");
    }

    private  By validateMessage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"email can not empty\"]");
    }
    private  By ValidateMessage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"password can not empty\"]");
    }

    @Step
    public boolean isOnLoginPage(){
        return waitUntilVisible(loginButton()).isDisplayed();
    }

    @Step
    public void inputEmail(String email){
        onType(emailField(), email);
    }

    @Step
    public void inputPassword(String password){
        onType(passwordField(), password);
    }

    @Step
    public void clickLoginButton(){
        onClick(loginButton());
    }

    @Step
    public String getErrorMessage() {
        return waitUntilVisible(snackbarError()).getText();
    }

    @Step
    public boolean homePage() {
        return waitUntilVisible(titleHomePage()).isDisplayed();
    }
    @Step
    public void clickButtonLogin() {
        onClick(ButtonLogin());
    }

    @Step
    public String getValidateMessage() {
        return waitUntilVisible(validateMessage()).getText();
    }

    @Step
    public String SeeValidateMessage() {
        return waitUntilVisible(ValidateMessage()).getText();
    }
}
