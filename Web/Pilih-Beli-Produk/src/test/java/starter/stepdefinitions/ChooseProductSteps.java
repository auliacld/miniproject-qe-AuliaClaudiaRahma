package starter.stepdefinitions;

import io.cucumber.java.en.And;
import starter.pages.ChooseProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ChooseProductSteps {
    @Steps
    ChooseProductPage chooseProduct;

    @Given("user on main page")
    public void userOnMainPage() { chooseProduct.mainPage();
    }

    @When("user click button Beli")
    public void userClickButtonBeli() { chooseProduct.clickBeli();
    }

    @Then("the product has been successfully selected")
    public void theProductHasBeenSuccessfullySelected() { chooseProduct.successAddToCart();
    }

    @And("user click cart")
    public void userClickCart() { chooseProduct.clickCart();
    }

    @When("user click button Detail")
    public void userClickButtonDetail() { chooseProduct.clickDetail();
    }

    @Then("user can see detail product")
    public void userCanSeeDetailProduct() { chooseProduct.seeDetail();
    }

    @And("user click Bayar")
    public void userClickBayar() { chooseProduct.clickBayar();
    }

    @Then("the order has been successfully and user see history transactions")
    public void theOrderHasBeenSuccessfullyAndUserSeeHistoryTransactions() { chooseProduct.seeHistoryTransactions();
    }
}
