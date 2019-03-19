package getRequests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class Validation_ImportStatic {
    @Test
    public void Test1() {
        when().get("https://www.google.com").then().statusCode(200);
    }
    @Test
    public void Test2() {
        when().get("https://www.google.com").then().log().all();
    }
    @Test
    public void Test3() {
        Response resp= RestAssured.get("https://www.google.com");
        resp.body().print();
        //   resp.body().prettyPrint();

    }
}
