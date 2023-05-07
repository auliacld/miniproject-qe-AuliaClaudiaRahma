package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostCommentProductsPage;

public class PostCommentProductSteps {
    @Steps
    PostCommentProductsPage commentProduct;

    @Given("user Own endpoint auth")
    public void userOwnEndpointAuth() {
        commentProduct.PosessesEndpointAuth();
    }

    @When("user Clarify and send endpoint auth")
    public void userClarifyAndSendEndpointAuth() {
        commentProduct.ClarifyEndpointAuth();
    }

    @When("user has endpoint create new comment for product")
    public void userHasEndpointCreateNewCommentForProduct() {
        commentProduct.setEndpointComment();
    }

    @And("user send request for create new comment for product")
    public void userSendRequestForCreateNewCommentForProduct() {
        commentProduct.sendEndpointComment();
    }

    @Then("user can see http response code {int}")
    public void userCanSeeHttpResponseCode(int arg0) {
        commentProduct.gainHTPPcode();
    }

    @And("I receive valid data for product comment")
    public void iReceiveValidDataForProductComment() { commentProduct.validateDataComment();
    }
}
