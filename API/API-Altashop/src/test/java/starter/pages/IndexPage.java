package starter.pages;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class IndexPage {
    public String EndpointIndex = "https://altashop-api.fly.dev/api/hello";

    @Step("I set GET api endpoint")
    public String setEndpointIndex() {
        return EndpointIndex;
    }

    @Step("I send GET HTTP Request")
    public void sendEnpointIndex() {
        SerenityRest.given().get(setEndpointIndex());
    }

    @Step("I receive valid HTTP Response code 200")
    public void GETStatusCodeIndex() {
        restAssuredThat(response -> response.statusCode(200));
    }

}