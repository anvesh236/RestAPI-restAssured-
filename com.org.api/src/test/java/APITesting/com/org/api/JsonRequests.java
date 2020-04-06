package APITesting.com.org.api;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

public class JsonRequests {

	
	@Test(priority=1)
	public void test_01()
	{
		
		Response resp = get("http://localhost:3000/posts");
		System.out.println("Get Response is :"+resp.asString());
	}
	//Post
	@Test(priority=0)
	public void test_02()
	{
		
		Response resp1 = given().
				         body("{\"id\":\"2\", \"title\": \"dummyTitle\",\"author\":\"Anvesh\"}").
				         when().
				         contentType(ContentType.JSON).
				         post("http://localhost:3000/posts");
	}
}
