package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DeleteProductsPage;

public class DeleteProducts {

    @Steps
    DeleteProductsPage deleteProduct;
    @Given("user posses Endpoint auth")
    public void userPossesEndpointAuth() {
        deleteProduct.PossesEndpointAuth();
    }

    @When("user explain and send endpoint auth")
    public void userExplainAndSendEndpointAuth() {
        deleteProduct.ExplainEndpointAuth();
    }

    @When("user has endpoint delete endpoint product")
    public void userHasEndpointDeleteEndpointProduct() {
        deleteProduct.setEndpointDeleteProduct();
    }

    @And("user send request for delete product")
    public void userSendRequestForDeleteProduct() {
        deleteProduct.sendReqDeleteProduct();
    }

    @Then("user see HTTP Response code {int}")
    public void userSeeHTTPResponseCode(int arg0) {
        deleteProduct.GainHttpResponseCode();
    }

    @When("user has invalid endpoint delete endpoint product")
    public void userHasInvalidEndpointDeleteEndpointProduct() {
        deleteProduct.setInvalidEndpointProduct();
    }

    @And("user send request to invalid endpoint delete product")
    public void userSendRequestToInvalidEndpointDeleteProduct() {
        deleteProduct.sendRequestToInvalidEndpoint();
    }

    @Then("user see error Response code {int}")
    public void userSeeErrorResponseCode(int arg0) {
        deleteProduct.seeErrorResponseCode();
    }

    @When("user set endpoint product with invalid id")
    public void userSetEndpointProductWithInvalidId() {
        deleteProduct.setInvalidID();
    }

    @And("user send request for delete product with invalid id")
    public void userSendRequestForDeleteProductWithInvalidId() {
        deleteProduct.sendReqInvalidID();
    }

    @Then("user see error response code {int}")
    public void SeeErrorResponseCode(int arg0) {
        deleteProduct.seeErrorCode();
    }
}
