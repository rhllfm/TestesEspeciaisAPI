import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.instanceOf;
public class CountriesQueriesTest {

    @Test
    public void shouldDo() {
        Response response = given().
                header("Content-Type", "application/json").
                body("{\"query\":\"query {\\n  country(code:\\\"BE\\\")\\n  {\\n    code\\n    name\\n    native\\n    phone\\n    languages\\n    {\\n        code\\n        name\\n    }\\n  }\\n}\",\"variables\":{}}").
                when().
                post("https://countries.trevorblades.com/");

        response.then().assertThat().statusCode(200).body("data.country.code",equalTo("BE"));
        response.then().log().body();
        String countries = response.jsonPath().get("data.country.name").toString();
        System.out.println(countries);
        response.then().body("data.country.code", equalTo("BE"));
        response.then().body("data.country.name", instanceOf(String.class));
    }

}
