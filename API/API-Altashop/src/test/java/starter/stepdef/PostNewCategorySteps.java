package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.PostNewCategoryPage;

public class PostNewCategorySteps {
    @Steps
    PostNewCategoryPage category;

    @Given("user has endpoint post new category")
    public void userHasEndpointPostNewCategory() {
        category.setPostEndpoint();
    }

    @When("user send request for create new category")
    public void userSendPostNewCategory() {
        category.sendPostHttpRequest();
    }

    @And("I receive valid data for new category")
    public void iReceiveValidDataForNewCategory() {
        category.validateDataNewCategory();
    }

    @Given("user has invalid endpoint for create new category")
    public void userHasInvalidEndpointForCreateNewCategory() { category.invalidEndpointCategory();
    }
}
