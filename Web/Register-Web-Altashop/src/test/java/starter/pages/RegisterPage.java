package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {
    // =============================== Locator ===============================
    private By completenameField() {
        return By.id("input-18");
    }

    private By emailField() {
        return By.id("input-21");
    }

    private By passwordField() {
        return By.id("input-24");
    }

    private By loginBtn() {
        return By.xpath("//span[text()='Register']");
    }

    private By titleLogin() {
        return By.xpath("//span[text()='Login']");
    }

    private By errorMessage() {
        return By.xpath("//div[@class='v-alert__content']");
    }

    //=============================================== Functional ====================================================
    public void onRegisterPage() {
        open();
        $(loginBtn()).shouldBeVisible();
    }

    public void inputCompleteName(String CompleteName) { $(completenameField()).type(CompleteName);
    }


    public void inputEmail(String email) { $(emailField()).type(email);
    }

    public void inputPassword(String password) { $(passwordField()).type(password);
    }

    public void clickLoginButton() { $(loginBtn()).click();
    }

    public void onLoginPage() { $(titleLogin()).shouldBeVisible();
    }

    public void inputExistingEmail(String email) { $(emailField()).type(email);
    }

    public void userSeeErrorMessage() { $(errorMessage()).shouldBeVisible();
    }

    public void userInputEmptyCompleteName(String CompleteName) { $(completenameField()).type(CompleteName);
    }

    public void userInputEmptyEmail(String email) { $(emailField()).type(email);
    }

    public void userInputEmptyPassword(String password) {
        $(passwordField()).type(password);
    }
}
