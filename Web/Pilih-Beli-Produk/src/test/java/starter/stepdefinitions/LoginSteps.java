package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;

public class LoginSteps {
        @Steps
        LoginPage login;

        @Given("user on login page")
        public void userOnLoginPage() {
            login.onLoginPage();
        }

        @When("user input valid email")
        public void userInputValidEmail() {
            login.inputEmail("aulia");
        }

        @When("user input valid password")
        public void userInputValidPassword() {
            login.inputPassword("123");
        }
        @When("user click login button")

        public void userClickLoginButton() {
            login.ClickLoginBtn();
        }

        @And("user on products page")
        public void userOnProductsPage() {
            login.onProductPage();
        }
}
