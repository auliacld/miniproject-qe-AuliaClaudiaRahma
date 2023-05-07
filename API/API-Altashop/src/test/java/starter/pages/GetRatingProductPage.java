package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
public class GetRatingProductPage {
    public String endpoint = "https://altashop-api.fly.dev/api/products";

    @Step ("I set GET API endpoint by id")
    public String getApiEndpoint(){
        return endpoint + "/13358" + "/ratings";
    }

    @Step ("I send GET HTTP Request")
    public void sendGetRatingHttpRequest(){
        SerenityRest.given().get(getApiEndpoint());
    }

    @Step ("i see response code 200")
    public void validateGetResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("i see data rating product")
    public void validateDataRating() {
        Response response = SerenityRest.lastResponse();
        int data = response.getBody().jsonPath().get("data");
        Assert.assertEquals(data, 3);

    }
}
