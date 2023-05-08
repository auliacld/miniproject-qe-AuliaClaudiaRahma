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
            login.inputEmail("aulia@gmail.com");
        }
        @When("user input valid password")
        public void userInputValidPassword() {
            login.inputPassword("aulia");
        }
        @When("user click login button")
        public void userClickLoginButton() {
            login.ClickLoginBtn();
        }
        @Then("user on products page")
        public void userOnProductsPage() {
            login.onProductPage();
        }

    @When("user input invalid username")
    public void userInputInvalidUsername() { login.inputInvalidUsername("aul");
    }

    @Then("user see error message")
    public void userSeeErrorMessage() { login.errorMessageIsDispalyed();
    }

    @When("user input empty email")
    public void userInputEmptyEmail() {login.inputEmptyEmail("");
    }

    @And("user input empty password")
    public void userInputEmptyPassword() {login.inputEmptyPassword("");
    }
}
