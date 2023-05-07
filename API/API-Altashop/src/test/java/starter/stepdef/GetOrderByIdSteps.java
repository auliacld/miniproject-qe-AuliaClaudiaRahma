package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.GetOrderByIdPage;

public class GetOrderByIdSteps {

    @Steps
    GetOrderByIdPage getOrderbyID;

    @Given("user have Endpoint Auth")
    public void userHaveEndpointAuth() {
        getOrderbyID.SettingEndpointAuth();
    }

    @When("user  send Edpoint Auh")
    public void userSendEdpointAuh() {
        getOrderbyID.SENDEndpointAuth();
    }
    @When("user has endpoint to get order by id")
    public void userHasEndpointToGetOrderById() {
        getOrderbyID.setEndpointOrder();
    }

    @And("user get detail order by id")
    public void userGetDetailOrderById() {
        getOrderbyID.sendEndpointOrder();
    }

    @Then("user get detail order by id with status code {int}")
    public void userGetDetailOrderByIdWithStatusCode(int arg0) {
        getOrderbyID.checkStatusResponse();
    }

}
