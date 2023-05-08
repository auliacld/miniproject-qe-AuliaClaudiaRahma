package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostNewUserLoginPage;
import starter.pages.PostNewUserRegisterPage;

public class PostNewUserLoginSteps {

    @Steps
    PostNewUserLoginPage login;
    @Given("user has endpoint post new user login")
    public void userHasEndpointPostNewUserLogin() {
        login.setPostEndpoint();
    }

    @When("user send request for create new user login")
    public void userSendPostNewUserLogin() {
        login.sendPostHttpRequest();
    }

    @Then("login user get status code {int}")
    public void loginUserGetStatusCode(int arg0) {
        login.validateHttpResponseCode200();
    }

    @And("I receive valid data for new login")
    public void iReceiveValidDataForNewLogin() { login.validateDataLogin();
    }

    @Given("user has invalid endpoint for create new user login")
    public void userHasInvalidEndpointForCreateNewUserLogin() { login.invalidEndpointLogin();
    }
}
