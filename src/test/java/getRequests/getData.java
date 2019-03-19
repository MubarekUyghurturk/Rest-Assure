package getRequests;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import  io.restassured.RestAssured;

public class getData {
    // get: data, code status, time of responses

    @Test
    public void Test1() {
        Response resp= RestAssured.get("https://www.google.com");   // to get the URL
        int code=resp.getStatusCode();  // status shown on the postman

        Assert.assertTrue(code==200);

        System.out.println("Response time: "+resp.getTime());
        System.out.println(resp.headers());
        System.out.println(resp.asString());
        System.out.println(resp.prettyPrint());
        System.out.println(resp.cookies());
    }

    @Test
    public void Test2(){
        Response resp= RestAssured.given().get("https://www.google.com");
         resp.then().statusCode(200);
    }

    @Test
    public void Test3(){
        Response resp=RestAssured.given().get("https://www.google.com");
        String htmlOfBrowser=resp.asString();
        System.out.println(htmlOfBrowser);
    }

    @Test
    public void Test4(){
        Response resp=RestAssured.given().get("https://www.google.com");
        String HTML_PrettyFormat=resp.prettyPrint();
        System.out.println(HTML_PrettyFormat);
    }

    @Test
    public void Test5(){
        Response resp=RestAssured.given().get("https://www.google.com");
       resp.then().log().headers();
    }

    @Test
    public void Test6(){
        Response resp=RestAssured.given().get("https://www.google.com");
        resp.then().log().body();
    }

    @Test
    public void Test7(){
        Response resp=RestAssured.given().get("https://www.google.com");
        resp.then().log().cookies();
    }

    @Test
    public void Test8(){
        Response resp=RestAssured.given().get("https://www.google.com");
        resp.then().log().all();
    }

}
