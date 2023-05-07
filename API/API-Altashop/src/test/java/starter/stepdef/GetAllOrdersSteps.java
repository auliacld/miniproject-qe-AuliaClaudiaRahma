package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.pages.GetAllOrderPage;

public class GetAllOrdersSteps {

    @Steps
    GetAllOrderPage allOrder;

    @Given("user has endpoint auth")
    public void userHasEndpointAuth() {
        allOrder.SetEndpointAuth();
    }

    @When("user can send endpoint auth")
    public void userCanSendEndpointAuth() {
        allOrder.SendEndpointAuth();
    }

    @When("user has endpoint to get all orders")
    public void userHasEndpointToGetAllOrders() {
        allOrder.setEndpointOrders();
    }

    @And("user get detail all orders")
    public void userGetDetailAllOrders() {
        allOrder.sendGetDetailOrder();
    }

    @Then("user get user detail all orders with status code {int}")
    public void userGetUserDetailAllOrdersWithStatusCode(int arg0) {
        allOrder.validateStatusCode200();
    }
}
