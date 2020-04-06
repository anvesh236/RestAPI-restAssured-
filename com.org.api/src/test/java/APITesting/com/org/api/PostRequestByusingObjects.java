package APITesting.com.org.api;
import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.classes.Posts;
public class PostRequestByusingObjects {

	@Test
	public void test_01()
	{
		Posts posts = new Posts();
		posts.setID("36");
		posts.setTitle("Post Request 36");
		posts.setAuthor("suresh");
		Response resp = given().
				        when().
				        contentType(ContentType.JSON).
				        body(posts).
				        when().
				        post("http://localhost:3000/posts");
		System.out.println(resp.asString());
	}
	
}
