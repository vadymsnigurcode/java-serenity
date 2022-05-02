import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class CountriesSearchSteps {
    private String ISO_CODE_SEARCH = "http://localhost:8080/JSON/";
    private Response response;

    @Step
    public void searchCountryByCode(String code){
        try {
            response = SerenityRest.rest()
                    .contentType("application/json").when().get(ISO_CODE_SEARCH + code);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Step
    public void searchIsExecutedSuccesfully(){
        response.then().statusCode(200);
    }

    @Step
    public void iShouldFindCountry(String country){
        response.then().body("name", is(country));
    }
}
