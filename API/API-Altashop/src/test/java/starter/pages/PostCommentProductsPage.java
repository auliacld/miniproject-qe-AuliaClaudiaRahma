package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCommentProductsPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";

    @Step("I have endpoint auth")
    public String PosessesEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void ClarifyEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(PosessesEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint get ratings")
    public String setEndpointComment() {
        return endpointAuth + "/products/13370/comments";
    }

    @Step ("I send POST HTTP Request")
    public void sendEndpointComment() {
        String content = "this is comment";

        String body = "{\n" +
                "    \"content\":" + content + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);
        SerenityRest.given().header("Authorization", "Bearer "+token).body(reqBody.toString()).post(setEndpointComment());
    }

    @Step("i see status code 200")
    public void gainHTPPcode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("i validate data comment")
    public void validateDataComment() {
        Response response = SerenityRest.lastResponse();
        String Content = response.getBody().jsonPath().get("data.Content");
        Assert.assertEquals(Content, "this is comment");
    }
}
