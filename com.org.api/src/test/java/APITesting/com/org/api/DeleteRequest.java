package APITesting.com.org.api;
import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;
public class DeleteRequest {
    @Test
	public void test_01()
	{
		  Response resp = given().
				          when().
				          delete("http://localhost:3000/posts/36");
		  System.out.println("Response is :"+resp.getStatusCode());
		  System.out.println(resp.asString());
	}
}
