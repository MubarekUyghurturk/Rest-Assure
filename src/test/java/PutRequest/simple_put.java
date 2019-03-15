package PutRequest;


import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class simple_put {
    @BeforeMethod
    public void setup(){
        RestAssured.baseURI="https://reqres.in/api/users/2";
    }

    @Test
    public void Test0(){
        JSONObject requestParam=new JSONObject();
        given().header("Content-Type","application/json")
                .body(requestParam.toJSONString()).post("https://reqres.in/api/users/2")
                .prettyPrint();
    }

    @Test
    public void Test1(){
        JSONObject requestParam=new JSONObject();
            requestParam.put("first_name","mamat");
            requestParam.put("last_name","mahmut");

        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");

        request.body(requestParam.toJSONString());
        Response respon=request.post("https://reqres.in/api/users/2");

        respon.prettyPrint();
        respon.then().body("first_name",equalTo("mamat"));

        // import static org.hamcrest.Matchers.*;
    }

    @Test
    public void Test2(){
        JSONObject requestParam=new JSONObject();
        requestParam.put("name","muhtar");
        requestParam.put("id","1994");
        given().header("Content-Type","application/json")
                .body(requestParam.toJSONString()).put("https://reqres.in/api/users/2")
                .prettyPrint();
    }


}
