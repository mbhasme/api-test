package basic.testcase;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapibase.BaseClass;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.pojoclasses.createRepoPOJO;
import utility.*;

import java.io.IOException;

public class createRepo {
    Response response;
    ObjectMapper objectmapper;
    // @Test
    public void createRepotestcase() throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        RestFWLogger.startTestCase("Start CreateRepo Testcase---");
        String endpoint = createURL.getBaseURI("/user/repos");
        String req_payload = payloadGenerator.generateStringPayload("createRepo.json");
        String bearer_token = Auth.bearerToken();

        response = BaseClass.postRequest(endpoint,req_payload,bearer_token);

        String responseString = response.getBody().asString();
      /*  JsonPath responsebody = new JsonPath(responseString);
        System.out.println("**** Response ****");
        System.out.println("repo name:" + responsebody.get("name"));
        System.out.println(responseString); */
        Assert.assertEquals(CommonUtilFunctions.getResponsekeyvalue(responseString,"name"),CommonUtilFunctions.getResponsekeyvalue(req_payload,"name"));

    }
    //@Test

    public void createRepotestcasepojo() throws JsonProcessingException {
        String endpoint = createURL.getBaseURI("/user/repos");
        createRepoPOJO requestpayload = new createRepoPOJO();
        String bearer_token = Auth.bearerToken();
        requestpayload.setName("repotest3");
        requestpayload.setDescription("this is test");

        objectmapper = new ObjectMapper();
        String payload = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestpayload);
        response = BaseClass.postRequest(endpoint,payload,bearer_token);
        String responseString = response.getBody().asString();
        JsonPath responsebody = new JsonPath(responseString);
        System.out.println("**** Response ****");
        System.out.println("repo name:" + responsebody.get("name"));
        System.out.println(responseString);



    }

    @Test
    public void deleteRepo() throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        RestFWLogger.startTestCase("Start deleteRepo Testcase");
        String req_payload = payloadGenerator.generateStringPayload("pojoclasses/createRepo.json");
        String bearer_token = Auth.bearerToken();
        String deletendpoint = createURL.getBaseURI("/repos/mbhasme/") + CommonUtilFunctions.getResponsekeyvalue(req_payload,"name") ;
        response = BaseClass.deleteRequest(deletendpoint,bearer_token);
        System.out.println(response.getBody().asString());
        Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
    }
}
