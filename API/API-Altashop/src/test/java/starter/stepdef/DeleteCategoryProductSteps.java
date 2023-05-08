package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DeleteCategoryProductPage;

public class DeleteCategoryProductSteps {

    @Steps
    DeleteCategoryProductPage deleteCategory;
    @Given("user set endpoint auth")
    public void userSetEndpointAuth() {
        deleteCategory.SETEndpointAuth();
    }

    @When("user desc and send endpoint auth")
    public void userDescAndSendEndpointAuth() {
        deleteCategory.DescEndpointAuth();
    }

    @When("user has endpoint delete endpoint category product")
    public void userHasEndpointDeleteEndpointCategoryProduct() {
        deleteCategory.SETEndpointDelete();
    }

    @And("user send request for delete category product")
    public void userSendRequestForDeleteCategoryProduct() {
        deleteCategory.SENDEndpointDelete();
    }

    @Then("user see HTTP code {int}")
    public void userSeeHTTPCode(int arg0) {
        deleteCategory.gainHTTPCode();
    }

    @When("user has invalid endpoint for delete endpoint category product")
    public void userHasInvalidEndpointForDeleteEndpointCategoryProduct() { deleteCategory.invalidEndpointDelete();
    }

    @Then("user see HTTP respon code {int}")
    public void userSeeHTTPResponCode(int arg0) { deleteCategory.seeErrorMessage();
    }
}
