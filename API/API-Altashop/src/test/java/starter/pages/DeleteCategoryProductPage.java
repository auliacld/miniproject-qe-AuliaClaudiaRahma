package starter.pages;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategoryProductPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";

    @Step("I have endpoint auth")
    public String SETEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void DescEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(SETEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint delete category")
    public String SETEndpointDelete() {
        return endpointAuth + "/categories/11301";
    }

    @Step ("I send delete HTTP Request")
    public void SENDEndpointDelete() {
        SerenityRest.given().header("Authorization", "Bearer " + token).delete(SETEndpointDelete());    }

    @Step("i see status code 200")
    public void gainHTTPCode() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
