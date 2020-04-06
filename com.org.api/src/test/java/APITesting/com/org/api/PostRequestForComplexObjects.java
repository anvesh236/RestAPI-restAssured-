package APITesting.com.org.api;
import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.classes.Info;
import com.org.classes.Posts;
public class PostRequestForComplexObjects {

	@Test
	public void test_01()
	{
		Info info = new Info();
		info.setEmail("cba@gmail.com");
		info.setPhone("1234567890");
		info.setAddress("1-11, Ameerpet");
		Posts posts = new Posts();
		posts.setID("17");
		posts.setTitle("Post request 17");
		posts.setAuthor("Srikanth");
		posts.setInfo(info);
		
		Response resp = given().
				        when().
				        contentType(ContentType.JSON).
				        body(posts).
				        post("http://localhost:3000/posts");
		
		System.out.println("Response is :"+resp.getStatusCode());
		System.out.println(resp.asString());
	}
}
