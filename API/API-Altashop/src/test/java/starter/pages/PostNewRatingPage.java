package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostNewRatingPage {
    protected static String email="dummy@gmail.com2";
    protected static String password="aa";
    public String token ="";
    public String endpointAuth = "https://altashop-api.fly.dev/api";

    @Step("I have endpoint auth")
    public String possesEndpointAuth(){
        return endpointAuth + "/auth/login";
    }

    @Step ("I Send endpoint auth")
    public void KirimEndpointAuth(){
        String body = "{\n" +
                "    \"email\":" + email + ",\n" +
                "    \"password\":" + password + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(possesEndpointAuth());
        token = lastResponse().getBody().jsonPath().get("data");
    }

    @Step ("I set endpoint ratings")
    public String setEndpointRatings() {
        return endpointAuth + "/products/13369/ratings";
    }

    @Step ("I set invalid endpoint ratings")
    public String setInvalidEndpointRating() {
        return endpointAuth + "/products/13369/rating";
    }

    @Step ("I send POST HTTP Request")
    public void sendEndpointCreateRatings() {
        String count = "3";

        String body = "{\n" +
                "    \"count\":" + count + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);
        SerenityRest.given().header("Authorization", "Bearer "+token).body(reqBody.toString()).post(setEndpointRatings());
    }

    @Step("i see status code 200")
    public void gainStatusCOde() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("i see my product rating is")
    public void validateData() {
        Response response = SerenityRest.lastResponse();
        int Ratings = response.getBody().jsonPath().get("data.Ratings");
        Assert.assertEquals(Ratings, 3);
    }

    @Step ("i send request to invalid endpoint")
    public void setReqToEndpointRating() {
        String count = "3";

        String body = "{\n" +
                "    \"count\":" + count + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);
        SerenityRest.given().header("Authorization", "Bearer "+token).body(reqBody.toString()).post(setInvalidEndpointRating());
    }

    @Step ("i can see error response 404")
    public void seeErrorCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step ("i can see error response 401")
    public void hasResponCode() {
        restAssuredThat(response -> response.statusCode(401));
    }
}

