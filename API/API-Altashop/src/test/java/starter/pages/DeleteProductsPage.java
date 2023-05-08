package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProductsPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";

    @Step("I have endpoint auth")
    public String PossesEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void ExplainEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(PossesEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint delete products")
    public String setEndpointDeleteProduct() {
        return endpointAuth + "/products/13392";
    }

    @Step ("I set invalid endpoint delete products")
    public String setInvalidEndpointProduct() {
        return endpointAuth + "/product/13392";
    }

    @Step ("i set invalid or not found id product")
    public String setInvalidID() {
        return  endpointAuth + "/product/1";
    }
    @Step ("I send delete HTTP Request")
    public void sendReqDeleteProduct() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setEndpointDeleteProduct());    }

    @Step("i see status code 200")
    public void GainHttpResponseCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("I send request to invalid endpoint")
    public void sendRequestToInvalidEndpoint() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setInvalidEndpointProduct());
    }
    @Step ("i see status code 404")
    public void seeErrorResponseCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    public void sendReqInvalidID() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(setInvalidID());
    }

    public void seeErrorCode() { restAssuredThat(response -> response.statusCode(401));
    }
}
