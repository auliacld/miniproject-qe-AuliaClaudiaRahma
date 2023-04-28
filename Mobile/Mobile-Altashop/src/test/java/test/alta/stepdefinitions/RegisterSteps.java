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

    @When("user click Create One button")
    public void ClickCreateButton() {
        registerScreen.clickCreateButton();
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

    @And("user input confirm password {string} on confirm password field")
    public void InputConfirmPassword(String ConfirmPassword) {
        registerScreen.InputConfirmPassword(ConfirmPassword);
    }

    @And("user click register button")
    public void ClickRegisterButton() {
        registerScreen.ClickRegisterButton();
    }

    @Then("user see validate message {string}")
    public void userSeeValidateMessage(String validate) {
        Assert.assertEquals(validate, registerScreen.getValidateMessage());
    }

    @Then("user see error alert message {string}")
    public void userSeeErrorAlertMessage(String alert) {
        Assert.assertEquals(alert, registerScreen.getAlertMessage());
    }

    @Then("user see alert message {string}")
    public void userSeeAlertMessage(String alertMessage) {
        Assert.assertEquals(alertMessage, registerScreen.getAlert());
    }
}
