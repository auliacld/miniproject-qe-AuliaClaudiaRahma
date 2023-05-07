package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetUserInfoPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api/auth";

    @Step ("I have endpoint auth")
    public String setPostEndpointAuth(){
        return endpointAuth + "/login";
    }

    @Step ("I Send endpoint auth")
    public void sendEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint get")
    public String setEndpointGet(){
        return endpointAuth + "/info";
    }

    @Step ("I send GET HTTP Request")
    public void sendGetUserInfo(){
        SerenityRest.given().header("Authorization", "Bearer " + token).get(setEndpointGet());
    }

    @Step ("I receive valid HTTP Response code 200")
    public void validateGetResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("I receive valid data")
    public void validateData() {
        Response response = SerenityRest.lastResponse();
        String Email = response.getBody().jsonPath().get("data.Email");
        String Password = response.getBody().jsonPath().get("data.Password");
        Assert.assertEquals(Email, "dummy@gmail.com2");
        Assert.assertEquals(Password, "aa");
    }
}