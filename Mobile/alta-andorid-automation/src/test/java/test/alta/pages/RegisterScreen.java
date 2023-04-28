package test.alta.pages;

import io.appium.java_client.MobileBy;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import test.alta.pageobject.BasePageObject;

public class RegisterScreen extends BasePageObject {

    private By clickCreate(){
        return MobileBy.id("textViewLinkRegister");
    }
    private By nameField(){
        return MobileBy.id("textInputEditTextName");
    }

    private By EmailField(){
        return MobileBy.id("textInputEditTextEmail");
    }

    private By PasswordField(){
        return MobileBy.id("textInputEditTextPassword");
    }

    private By ConfirmPasswordField(){
        return MobileBy.id("textInputEditTextConfirmPassword");
    }

    private By RegisterButton(){
        return MobileBy.id("appCompatButtonRegister");
    }

    private By ValidateMessage(){
        return MobileBy.id("snackbar_text");
    }
    private By AlertMessage(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.support.v7.widget.LinearLayoutCompat/TextInputLayout[1]/android.widget.LinearLayout/android.widget.TextView");
    }

    private By Alert(){
        return MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.support.v7.widget.LinearLayoutCompat/TextInputLayout[2]/android.widget.LinearLayout/android.widget.TextView");
    }
   /* @Step
    public boolean OnLoginPage(){
        return waitUntilVisible(RegisterButton()).isDisplayed();
    } */

    @Step
    public void clickCreateButton(){
        onClick(clickCreate());
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
    public void InputConfirmPassword(String ConfirmPassword){
        onType(ConfirmPasswordField(), ConfirmPassword);
    }
    @Step
    public void ClickRegisterButton(){
        onClick(RegisterButton());
    }

    @Step
    public String getValidateMessage() {
        return waitUntilVisible(ValidateMessage()).getText();
    }

    public String getAlertMessage() {
        return waitUntilVisible(AlertMessage()).getText();
    }

    public String getAlert() {
        return waitUntilVisible(Alert()).getText();
    }
}
