package APITesting.com.org.api;
import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.classes.Posts;

public class PutRequestByUsingObject {

	@Test
	public void test_01()
	{
		Posts posts = new Posts();
		posts.setID("2");
		posts.setTitle("Updated Title");
		posts.setAuthor("updated Author");
		
		Response resp = given().
				        when().
				        contentType(ContentType.JSON).
				        body(posts).
				        put("http://localhost:3000/posts/2");
		System.out.println("Response is :"+resp);
		System.out.println(resp.asString());
	}
}
