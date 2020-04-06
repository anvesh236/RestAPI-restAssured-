package APITesting.com.org.api;
import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
public class PatchRequest {

	@Test
	public void test_01()
	{
		Response resp = given().
				        when().
				        contentType(ContentType.JSON).
				        body("{\"title\":\"Updated Title with Put\"}").
				        patch("http://localhost:3000/posts/36"); // we need to pass id(36) here
		
		System.out.println("Response is :"+resp);
		System.out.println(resp.asString());
	}
}
