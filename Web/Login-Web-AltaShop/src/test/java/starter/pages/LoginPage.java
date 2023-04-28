package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    // =============================== Locator ===============================
    private By emailField() {
        return By.id("input-18");
    }

    private By passwordField() {
        return By.id("input-21");
    }

    private By loginBtn() {
        return By.xpath("//span[text()='Login']");}

    private By titleProducts() {

        return By.id("11303");
    }
    private By errorMessage() {
        return By.xpath("//div[@class='v-alert__wrapper']");
    }

    //=============================================== Functional ======================================================
    @Step
    public void onLoginPage() {
        open();
        $(loginBtn()).shouldBeVisible();
    }

    @Step
    public void inputEmail(String email) {
        $(emailField()).type(email);
}
    @Step
    public void inputPassword(String password) {
        $(passwordField()).type(password);
    }

    @Step
    public void ClickLoginBtn() { $(loginBtn()).click();}

    @Step
    public void onProductPage() {
        $(titleProducts()).shouldBeVisible();
    }

    @Step
    public void inputInvalidUsername(String invalidUser) {
        $(emailField()).type(invalidUser);
    }

    @Step
    public void errorMessageIsDispalyed() {
        $(errorMessage()).shouldBeVisible();
    }

    public void inputEmptyEmail(String email) {
        $(emailField()).type(email);
    }

    public void inputEmptyPassword(String password) {
        $(passwordField()).type(password);}
}
