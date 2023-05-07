package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostNewRatingPage;

public class PostNewRatingSteps {
    @Steps
    PostNewRatingPage newRating;

    @Given("user posses endpoint auth")
    public void userPossesEndpointAuth() {
        newRating.possesEndpointAuth();
    }

    @When("user define and send endpoint auth")
    public void userDefineAndSendEndpointAuth() {
        newRating.KirimEndpointAuth();
    }

    @When("user has endpoint create new rating products")
    public void userHasEndpointCreateRatingProducts() {
        newRating.setEndpointRatings();
    }

    @And("user send request for create new rating product")
    public void userSendRequestForCreateRatingProduct() {
        newRating.sendEndpointCreateRatings();
    }

    @Then("user has response code {int}")
    public void userHasResponseCode(int arg0) {
        newRating.gainStatusCOde();
    }

    @And("I receive valid data for new rating")
    public void iReceiveValidDataForNewRating() {
        newRating.validateData();
    }

    @When("user has invalid endpoint for create new rating products")
    public void userHasInvalidEndpointForCreateNewRatingProducts() {
        newRating.setInvalidEndpointRating();
    }

    @And("user send request to invalid endpoint for create new rating product")
    public void userSendRequestToInvalidEndpointForCreateNewRatingProduct() {
        newRating.setReqToEndpointRating();
    }

    @Then("user can see error code {int}")
    public void userCanSeeErrorCode(int arg0) {
        newRating.seeErrorCode();
    }

    @Then("user has Response code {int}")
    public void HasResponseCode(int arg0) {
        newRating.hasResponCode();
    }
}
