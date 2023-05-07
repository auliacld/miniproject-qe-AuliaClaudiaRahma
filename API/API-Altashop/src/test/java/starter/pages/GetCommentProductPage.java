package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
public class GetCommentProductPage {
    public String endpoint = "https://altashop-api.fly.dev/api/products";

    @Step ("I set GET API Product Comments Endpoint")
    public String getApiProductCommentEndpoint() {
        return endpoint + "/13370" + "/comments";
    }

    @Step ("I send GET HTTP Request")
    public void sendGetCommentHttpRequest(){
        SerenityRest.given().get(getApiProductCommentEndpoint());
    }

    @Step ("i see status code")
    public void validateGetProductCommentResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("i see validate data")
    public void validateDataProductComment() {
        Response response = SerenityRest.lastResponse();
        String Content = response.getBody().jsonPath().get("data.Content[0]");
        Assert.assertEquals(Content, "this is comment");
    }
}
