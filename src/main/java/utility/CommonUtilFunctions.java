package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {

    public static JsonPath jsonPath;

    public static String getResponsekeyvalue(String response_body, String response_key) {
        jsonPath = new JsonPath(response_body);
        String key = jsonPath.get(response_key);
        return key;

    }

    public static int getStatusCode(Response response) {
        int statuscode = response.getStatusCode();

        return statuscode;
    }
}
