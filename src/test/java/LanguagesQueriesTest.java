import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class LanguagesQueriesTest {

    @Test
    public void shouldReturnLanguageName(){
        Response response = Utils.makeRequest(GlobalVals.queryLanguages,GlobalVals.urlLanguages);
        response.then().assertThat().body("data.languages[0].name", equalTo("Portuguese"));
    }

    @Test
    public void shouldBeInstanceOfStringClass(){
        Response response = Utils.makeRequest(GlobalVals.queryLanguages,GlobalVals.urlLanguages);
        response.then().assertThat().body("data.languages[0].name", instanceOf(String.class));
    }

    @Test
    public void shouldReturnStatus200(){
        Response response = Utils.makeRequest(GlobalVals.queryLanguages,GlobalVals.urlLanguages);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void shouldReturnStatus400(){
        Response response = Utils.makeRequest(GlobalVals.queryInvalidLanguage,GlobalVals.urlLanguages);
        response.then().assertThat().statusCode(400);
    }
}
