package starter.pages;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostOrderPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";

    @Step("I have endpoint auth")
    public String ownEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void SenddEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(ownEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint get new order")
    public String setEndpointNewOrder() {
        return endpointAuth + "/orders";
    }

    @Step ("I send POST HTTP Request")
    public void userSendEndpointNewOrder() {
        String productid = "13384";
        String quantity = "3";

        String body = "    {\n" +
                "        \"product_id\":13384,\n" +
                "        \"quantity\":1\n" +
                "    }";

        JSONObject reqBody = new JSONObject(body);
        SerenityRest.given().header("Authorization", "Bearer "+token).contentType("application/json").body("[\n" + reqBody.toString() + "\n]").post(setEndpointNewOrder());

    }

    public void gainResponseCode() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
