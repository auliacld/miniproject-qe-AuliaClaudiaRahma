package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.RegisterPage;

public class RegisterSteps {
    @Steps
    RegisterPage register;
    @Given("user on register page")
    public void userOnRegisterPage() { register.onRegisterPage();
    }

    @When("user input valid complete name")
    public void userInputValidCompleteName() { register.inputCompleteName("Aulia Claudia Rahma");
    }

    @And("user input valid email")
    public void userInputValidEmail() { register.inputEmail("auliacld18@gmail.comxx");
    }

    @And("user input valid password")
    public void userInputValidPassword() { register.inputPassword("123456");
    }

    @And("user click login button")
    public void userClickLoginButton() { register.clickLoginButton();
    }

    @Then("user on login page")
    public void userOnLoginPage() { register.onLoginPage();
    }

    @And("user input existing email")
    public void userInputExistingEmail() { register.inputExistingEmail("auliacld18@gmail.com");
    }

    @Then("user see error message")
    public void userSeeErrorMessage() { register.userSeeErrorMessage();
    }

    @When("user input empty complete name")
    public void userInputEmptyCompleteName() { register.userInputEmptyCompleteName("");
    }

    @And("user input empty email")
    public void userInputEmptyEmail() { register.userInputEmptyEmail("");
    }

    @And("user input empty password")
    public void userInputEmptyPassword() { register.userInputEmptyPassword("");
    }
}
