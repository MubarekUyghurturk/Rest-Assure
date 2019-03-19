package getRequests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import javafx.beans.binding.When;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Base_URL {

    @BeforeMethod
    public void setup(){
        RestAssured.baseURI="https://www.google.com";
    }

    @Test
    public void Test1(){

        Response resp=RestAssured.get("/books?uid=101709087897462068872&hl=en");
             int i=resp.getStatusCode();
        System.out.println(i);
       Assert.assertTrue( resp.body().prettyPrint().toLowerCase().contains("rent and"));
  //      when().get("/books").then().statusCode(200);
    }
    @Test
    public void Test2(){
        Response resp=RestAssured.get("/image");
        int i=resp.getStatusCode();
        System.out.println(i);
    }


}
