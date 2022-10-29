import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

class GlobalVals{
    static final String urlLanguages = "https://countries.trevorblades.com/";
    static final String queryLanguages = "{\"query\":\"query {\\r\\n  languages(filter:\\r\\n  {\\r\\n    code:\\r\\n    {\\r\\n      eq:\\\"pt\\\"\\r\\n    }\\r\\n  })\\r\\n  {\\r\\n    code\\r\\n    name\\r\\n    native\\r\\n    rtl\\r\\n  \\r\\n  }\\r\\n}\",\"variables\":{}}";
    static final String queryInvalidLanguage = "qualquercoisaaí";
}

public class Utils {

    public Utils(String queryLanguages, String url) {
    }

    public static Response makeRequest(String queryLanguages, String url){
        Response response = given().
                header("Content-Type","application/json").
                and().
                body(queryLanguages).
                when().
                post(url);
        return response;
    }

}
