package starter.pages;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllOrderPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";

    @Step ("I have endpoint auth")
    public String SetEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void SendEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(SetEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint order")
        public String setEndpointOrders(){
            return endpointAuth + "/orders";
    }
    @Step ("I set invalid endpoint order")
    public String invalidEndpoint() {
        return endpointAuth + "/order";
    }
    @Step ("I send GET HTTP Request")
    public void sendGetDetailOrder() {
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointOrders());
    }

    public void validateStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

}
