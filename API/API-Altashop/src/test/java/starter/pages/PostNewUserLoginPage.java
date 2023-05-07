package starter.pages;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.asynchttpclient.Param;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
public class PostNewUserLoginPage {
    public String endpoint = "https://altashop-api.fly.dev/api/auth/login";

    @Step ("I have endpoint post new user")
    public String setPostEndpoint(){
        return endpoint;
    }

    @Step ("I send post new user")
    public void sendPostHttpRequest(){
        String email = "dummy@gmail.com2";
        String password = "aa";

        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpoint());
    }

    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    public void validateDataLogin() {
        Response response = SerenityRest.lastResponse();
        String data = response.getBody().jsonPath().get("data");
        Assert.assertEquals(data, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6ImF1bGlhIGNsYXVkaWEiLCJFbWFpbCI6ImR1bW15QGdtYWlsLmNvbTIifQ.tA_eR6yTnMB4IR88uXOz9RkReKqfeE_l8wlGIDnWWAg");
    }
}
