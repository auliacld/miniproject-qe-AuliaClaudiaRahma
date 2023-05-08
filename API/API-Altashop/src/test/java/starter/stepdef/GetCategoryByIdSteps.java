package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.GetCategoryByIdPage;
import starter.pages.GetProductPage;

public class GetCategoryByIdSteps {
    @Steps
    GetCategoryByIdPage categoryID;

    @Given("user has endpoint get category api")
    public void userHasEndpointGetCategoryApi() {
        categoryID.getEndpointGetCategoryApi();
    }

    @When("user set endpoint category by id")
    public void userGetCategoryById() {
        categoryID.getRequestGetCategoryById();
    }

    @Then("user get category status code {int}")
    public void userGetCategoryStatusCode(int arg0) {
        categoryID.GetCategorybyIDResponseCode200();
    }

    @Given("user has endpoint to get detail category")
    public void userHasEndpointToGetDetailCategory() {
        categoryID.getApiAllCategory();
    }

    @When("user get all detail category")
    public void userGetAllDetailCategory() {
        categoryID.getAllCategory();
    }

    @And("I receive valid data for all category")
    public void iReceiveValidDataForAllCategory() { categoryID.validateDataAllCategory();
    }

    @And("I receive valid data for category by id")
    public void iReceiveValidDataForCategoryById() { categoryID.validateDataCategoryByID();
    }

    @Given("user has invalid endpoint for get detail category")
    public void userHasInvalidEndpointForGetDetailCategory() { categoryID.invalidEndpoint();
    }

    @Given("user has invalid endpoint category by id")
    public void userHasInvalidEndpointCategoryById() { categoryID.invalidEndpointByID();
    }
}
