import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class CountriesSearchTestsClassic {
    @Test
    public void verifyThatWeCanFindUnitedStatesOfAmericaUsingTheCodeUS(){
        RestAssured.
                when().get("http://localhost:8080/JSON/data").
                then().assertThat().statusCode(200).
                //and().body("", is("United States of America"));
                and().body("name", is("United States of America"));
    }
}