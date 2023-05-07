package starter.pages;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostNewCategoryPage {
    public String endpoint = "https://altashop-api.fly.dev/api/categories";

    @Step ("I have endpoint post new user")
    public String setPostEndpoint(){
        return endpoint;
    }

    @Step ("I send post new user")
    public void sendPostHttpRequest(){
        String name = "Category Aulia";
        String description = "ini category aulia";

        String body = "{\n" +
                "    \"name\":" + name + ",\n" +
                "    \"description\":" + description + ",\n" +
                "}";
        JSONObject reqBody = new JSONObject(body);

        SerenityRest.given().header("Content-Type", "application/json").body(reqBody.toString()).post(setPostEndpoint());
    }

    @Step ("i validate data new category")
    public void validateDataNewCategory() {
        Response response = SerenityRest.lastResponse();
        String Name = response.getBody().jsonPath().get("data.Name");
        String Description = response.getBody().jsonPath().get("data.Description");
        Assert.assertEquals(Name, "Category Aulia");
        Assert.assertEquals(Description, "ini category aulia");
    }
}
