package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostNewProductPage;

public class PostNewProductSteps {
    @Steps
    PostNewProductPage user;

    @Given("user has endpoint post new product")
    public void userHasEndpointPostNewProduct() {
        user.setPostEndpoint();
    }

    @When("user send post new product")
    public void userSendPostNewProduct() {
        user.sendPostHttpRequest();
    }

    @Then("user see status code {int}")
    public void userSeeStatusCode(int arg0) {
        user.validateHttpResponseCode200();
    }

    @And("I receive valid data for new product")
    public void iReceiveValidDataForNewProduct() {
        user.ValidateDataNewProduct();
    }

    @Given("user has invalid endpoint new product")
    public void userHasInvalidEndpointNewProduct() {
        user.setInvalidEndpoint();
    }

    @When("user send request to invalid endpoint product")
    public void userSendRequestToInvalidEndpointProduct() {
        user.sendReqToInvalidEndpoint();
    }

    @Then("user can see error status code {int}")
    public void userCanSeeErrorStatusCode(int arg0) {
        user.seeErrorCode();
    }

    @When("user send invalid request to endpoint product")
    public void userSendInvalidRequestToEndpointProduct() {
        user.invalidRequest();
    }

    @Then("user get Status Code {int}")
    public void userGetStatusCode(int arg0) {
        user.getStatusCode();
    }
}
