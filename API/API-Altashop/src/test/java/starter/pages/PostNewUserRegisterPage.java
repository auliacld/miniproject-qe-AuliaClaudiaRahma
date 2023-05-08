package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostNewUserRegisterPage {
    public String endpoint = "https://altashop-api.fly.dev/api/auth/register";
    public String endpointInvalid = "https://altashop-api.fly.dev/api/auth/regis";
    @Step ("I have endpoint post new user")
    public String setPostEndpoint(){
        return endpoint;
    }

    @Step ("I set invalid endpoint")
    public String invalidEndpointRegis() { return  endpointInvalid;
    }
    @Step ("I send post new user")
    public void sendPostHttpRequest(){
        String email = "auliacld101@gmail.comx";
        String password = "aa";
        String fullname = "Aulia Claudia Rahma";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "    \"fullname\":" + fullname + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpoint());
    }

    @Step ("i validate response code")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("i validate data new register")
    public void validateDataRegister() {
        Response response = SerenityRest.lastResponse();
        String Email = response.getBody().jsonPath().get("data.Email");
        String Password = response.getBody().jsonPath().get("data.Password");
        String Fullname = response.getBody().jsonPath().get("data.Fullname");
        Assert.assertEquals(Email, "auliacld101@gmail.comx");
        Assert.assertEquals(Password, "aa");
        Assert.assertEquals(Fullname, "Aulia Claudia Rahma");
    }

}
