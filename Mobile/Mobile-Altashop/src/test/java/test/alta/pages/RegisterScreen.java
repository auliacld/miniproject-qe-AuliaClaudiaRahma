package test.alta.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.alta.pageobject.BasePageObject;

public class RegisterScreen extends BasePageObject {

    private By clickRegister(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }
    private By nameField(){
        return MobileBy.xpath("\t\n" + "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]");
    }

    private By EmailField(){
        return MobileBy.xpath("\t\n" + "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]");
    }

    private By PasswordField(){
        return MobileBy.xpath("\t\n" + "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]");
    }

    private By RegisterButton(){
        return MobileBy.xpath("//android.widget.Button[@content-desc=\"Register\"]");
    }

    private By AlertMessage(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.support.v7.widget.LinearLayoutCompat/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView");
    }

    private By Alert(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.support.v7.widget.LinearLayoutCompat/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView");
    }
    private By FullNameAlertMessage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"fullname can not empty\"]");
    }
    private By EmailAlertMessage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"email can not empty\"]");
    }
    private By PasswordAlertMessage(){
        return MobileBy.xpath("//android.view.View[@content-desc=\"password can not empty\"]");
    }

   /* @Step
    public boolean OnLoginPage(){
        return waitUntilVisible(RegisterButton()).isDisplayed();
    } */

    @Step
    public void clickRegisterButton(){
        onClick(clickRegister());
    }

    @Step
    public void InputName(String Name) {
        onType(nameField(), Name);
    }

    @Step
    public void InputEmail(String Email){
        onType(EmailField(), Email);
    }

    @Step
    public void InputPassword(String Password){
        onType(PasswordField(), Password);
    }

    @Step
    public void ClickRegisterButton(){
        onClick(RegisterButton());
    }

    @Step
    public String getAlertMessage() {
        return waitUntilVisible(AlertMessage()).getText();
    }

    @Step
    public String getAlert() {
        return waitUntilVisible(Alert()).getText();
    }

    @Step
    public String getFullNameAlertMessage() {
        return waitUntilVisible(FullNameAlertMessage()).getText();
    }
    @Step
    public String getEmailAlertMessage() {
        return waitUntilVisible(EmailAlertMessage()).getText();
    }
    @Step
    public String getPasswordAlertMessage() {
        return waitUntilVisible(PasswordAlertMessage()).getText();
    }
}
