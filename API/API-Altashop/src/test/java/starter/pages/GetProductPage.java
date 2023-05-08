package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetProductPage {
    public String endpoint = "https://altashop-api.fly.dev/api/products";

    public String InvalidEndpoint = "https://altashop-api.fly.dev/api/product";

    @Step ("I set GET API endpoint by id")
    public String setByIDApiEndpoint(){
        return endpoint + "/13675";
    }


    @Step ("I set GET api endpoint")
    public String setApiEndpoint(){
        return endpoint;
    }
    @Step ("I set GET api endpoint with invalid id")
    public String setInvalidID() { return endpoint + "/111";
    }
    @Step ("I set GET invalid api endpoint")
    public String setInvalidApiEndpoint(){
        return InvalidEndpoint;
    }

    @Step ("I send GET HTTP Request")
    public void sendGetHttpRequest(){
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step ("I receive valid HTTP Response code 200")
    public void validateHttpResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("I send GET HTTP Request")
    public void sendGetDetailById() {
        SerenityRest.given().get(setByIDApiEndpoint());
    }

    @Step ("I send GET HTTP Request")
    public void SendGetHttpRequest() {
        SerenityRest.given().get(setInvalidApiEndpoint());
    }
    @Step ("I receive valid HTTP Response code 404")
    public void getResponseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step ("I receive valid data for all products")
    public void validateDataAllProducts() {
        Response response = SerenityRest.lastResponse();
        int ID = response.getBody().jsonPath().get("data.ID[0]");
        String Name = response.getBody().jsonPath().get("data.Name[0]");
        int Price = response.getBody().jsonPath().get("data.Price[0]");
        Assert.assertEquals(ID,13361);
        Assert.assertEquals(Name, "Sony PS5");
        Assert.assertEquals(Price, 299);
    }
    @Step ("I receive valid data for id products")
    public void validateDataIDProducts() {
        Response response = SerenityRest.lastResponse();
        int ID = response.getBody().jsonPath().get("data.ID");
        String Name = response.getBody().jsonPath().get("data.Name");
        int Price = response.getBody().jsonPath().get("data.Price");
        int Ratings = response.getBody().jsonPath().get("data.Ratings");
        Assert.assertEquals(ID,13675);
        Assert.assertEquals(Name, "Product Aulia 3");
        Assert.assertEquals(Price, 0);
        Assert.assertEquals(Ratings, 0);
    }

    @Step
    public String setInvalidEndpoint() {
        return InvalidEndpoint;
    }

    @Step
    public void sendRequestToInvalidEndpoint() {
        SerenityRest.given().get(setInvalidApiEndpoint());
    }

    @Step
    public void seeStatusCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    public void sendReqInvalidID() {
        SerenityRest.given().get(setInvalidID());
    }

}
