package starter.pages;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetOrderByIdPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";
    @Step ("I have endpoint auth")
    public String SettingEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void SENDEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(SettingEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }
    @Step("I set endpoint get")
    public String setEndpointOrder(){
        return endpointAuth + "/orders/10941";
    }
    @Step ("I send GET HTTP Request")
    public void sendEndpointOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointOrder());
    }

    public void checkStatusResponse() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
