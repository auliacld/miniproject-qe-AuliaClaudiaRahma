package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.IndexPage;

public class IndexSteps {
    @Steps
    IndexPage index;
    @Given("user has endpoint index")
    public void userHasEndpointIndex() {
        index.setEndpointIndex();
    }

    @When("user send request get detail index")
    public void userSendRequestGetDetailIndex() {
        index.sendEnpointIndex();
    }

    @Then("user get index status code {int}")
    public void userGetIndexStatusCode(int arg0) {
        index.GETStatusCodeIndex();
    }
}
