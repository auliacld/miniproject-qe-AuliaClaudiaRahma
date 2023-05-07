package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostNewProductPage {
    public String endpoint = "https://altashop-api.fly.dev/api/products";
    public String InvalidEndpoint ="https://altashop-api.fly.dev/api/product";
    @Step ("I have endpoint post new product")
    public String setPostEndpoint(){
        return endpoint;
    }

    @Step ("i have invalid endpoint")
    public String setInvalidEndpoint() {
        return  InvalidEndpoint;
    }

    @Step ("I send post new product")
    public void sendPostHttpRequest(){
        String name = "Product Aulia 3";
        String description = "ini product aulia 3";

        String body = "{\n" +
                "    \"name\":" + name + ",\n" +
                "    \"description\":" + description + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpoint());
    }

    @Step("i see status code 200")
    public void validateHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step ("i see valid data with my request")
    public void ValidateDataNewProduct() {
        Response response = SerenityRest.lastResponse();
        String Name = response.getBody().jsonPath().get("data.Name");
        String Description = response.getBody().jsonPath().get("data.Description");
        Assert.assertEquals(Name, "Product Aulia 3");
        Assert.assertEquals(Description, "ini product aulia 3");
    }

    @Step ("i send request")
    public void sendReqToInvalidEndpoint() {
        String name = "Product Aulia 3";
        String description = "ini product aulia 3";

        String body = "{\n" +
                "    \"name\":" + name + ",\n" +
                "    \"description\":" + description + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setInvalidEndpoint());
    }
    @Step ("i see status code 404")
    public void seeErrorCode() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step ("i send invalid request")
    public void invalidRequest() { String name = "Product Aulia 3";
        String description = "ini product aulia 3";

        String body = "{\n" +
                "    \"\":" + name + ",\n" +
                "    \"description\":" + description + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setInvalidEndpoint());
    }

    @Step ("i get status error code 404")
    public void getStatusCode() {
        restAssuredThat(response -> response.statusCode(404));
    }
}

