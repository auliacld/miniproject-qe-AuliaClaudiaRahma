package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetCategoryByIdPage {
    public String endpoint = "https://altashop-api.fly.dev/api/categories";

    @Step ("I set GET Category endpoint by id")
    public String getEndpointGetCategoryApi(){
        return endpoint + "/12505";
    }

    @Step ("I set GET Category endpoint")
    public String getApiAllCategory() {
        return endpoint;
    }

    @Step ("I send GET Category HTTP Request")
    public void getRequestGetCategoryById(){
        SerenityRest.given().get(getEndpointGetCategoryApi());
    }

    @Step ("I receive valid HTTP Response code 200")
    public void GetCategorybyIDResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("I send GET Category HTTP Request")
    public void getAllCategory() {
        SerenityRest.given().get(getApiAllCategory());
    }

    @Step ("i validate data category")
    public void validateDataAllCategory() {
        Response response = SerenityRest.lastResponse();
        int ID = response.getBody().jsonPath().get("data.ID[0]");
        String Name = response.getBody().jsonPath().get("data.Name[0]");
        String Description = response.getBody().jsonPath().get("data.Description[0]");
        Assert.assertEquals(ID, 12505);
        Assert.assertEquals(Name, "Furniture");
        Assert.assertEquals(Description, "for gaming purposes");
    }

    @Step ("i validate data category by id")
    public void validateDataCategoryByID() {
        Response response = SerenityRest.lastResponse();
       // String Name = response.getBody().jsonPath().get("data.Name[0]");
        String Description = response.getBody().jsonPath().get("data.Description");
       // Assert.assertEquals(Name, "Furniture");
        Assert.assertEquals(Description, "for gaming purposes");
    }
}
