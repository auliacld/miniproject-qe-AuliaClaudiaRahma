package test.alta.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import test.alta.pageobject.BasePageObject;
import test.alta.pages.LoginScreen;
import test.alta.pages.RegisterScreen;

public class RegisterSteps {

    @Steps
    RegisterScreen registerScreen;

    /* @Given("user on the login page before click")
    public void userOnTheLoginPageBeforeClick() {
        Assert.assertTrue(registerScreen.OnLoginPage());
    } */

    @When("user click Register button")
    public void ClickCreateButton() {
        registerScreen.clickRegisterButton();
    }

    @And("user input name {string} on name field")
    public void InputName(String Name) {
        registerScreen.InputName(Name);
    }

    @And("user input email {string} on email field")
    public void InputEmail(String Email) {
        registerScreen.InputEmail(Email);
    }

    @And("user input password {string} on password field")
    public void InputPassword(String Password) {
        registerScreen.InputPassword(Password);
    }

    @And("user click register button")
    public void ClickRegisterButton() {
        registerScreen.ClickRegisterButton();
    }

    @Then("user see error alert message {string}")
    public void userSeeErrorAlertMessage(String alert) {
        Assert.assertEquals(alert, registerScreen.getAlertMessage());
    }

    @Then("user see alert message {string}")
    public void userSeeAlertMessage(String alertMessage) {
        Assert.assertEquals(alertMessage, registerScreen.getAlert());
    }

    @Then("user see alert fullname message {string}")
    public void userSeeAlertFullnameMessage(String fullNameAlert) {
        Assert.assertEquals(fullNameAlert, registerScreen.getFullNameAlertMessage());
    }

    @Then("user see alert email message {string}")
    public void userSeeAlertEmailMessage(String EmailAlert) {
        Assert.assertEquals(EmailAlert, registerScreen.getEmailAlertMessage());
    }

    @Then("user see alert password message {string}")
    public void userSeeAlertPasswordMessage(String PasswordAlert) {
        Assert.assertEquals(PasswordAlert, registerScreen.getPasswordAlertMessage());
    }
}
