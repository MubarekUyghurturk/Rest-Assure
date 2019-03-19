package Delete;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class simple_delete {
    @Test
    public void Test2(){
     //   RestAssured.baseURI="https://reqres.in";
         Response resp=RestAssured.given().get("https://reqres.in/api/users/2");
        JSONObject requestParam=new JSONObject();
        requestParam.put("name","muhtar");
        requestParam.put("id","1994");
        RequestSpecification request=RestAssured.given();

        request.header("Content-Type","application/json");

        request.body(requestParam.toJSONString());
        resp   =request.put("https://reqres.in/api/users/2");
        resp.prettyPrint();



//        given().header("Content-Type","application/json")
//                .body(requestParam.toJSONString()).delete("https://reqres.in/api/users/2")
//                .prettyPrint();





    }
}
