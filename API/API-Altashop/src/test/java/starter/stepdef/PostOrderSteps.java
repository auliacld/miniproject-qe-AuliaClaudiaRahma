package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostOrderPage;

public class PostOrderSteps {
    @Steps
    PostOrderPage createOrder;
    @Given("user own endpoint auth")
    public void userOwnEndpointAuth() {
        createOrder.ownEndpointAuth();
    }

    @When("user clarify and send endpoint auth")
    public void userClarifyAndSendEndpointAuth() {
        createOrder.SenddEndpointAuth();
    }

    @When("user has endpoint create new order")
    public void userHasEndpointCreateNewOrder() {
        createOrder.setEndpointNewOrder();
    }

    @And("user send request for create new order")
    public void userSendRequestForCreateNewOrder() {
        createOrder.userSendEndpointNewOrder();
    }

    @Then("user see http response code {int}")
    public void userSeeHttpResponseCode(int arg0) {
        createOrder.gainResponseCode();
    }
}
