package APITesting.com.org.api;

import static com.jayway.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.org.classesAdvancedEX.*;

public class PostRequestWithArrays {

	@Test
	public void test_01()
	{
		Info info1 = new  Info();
		info1.setEmail("TestEmail1");
		info1.setPhone("TestPhone1");
		info1.setAddress("TestAddress1");
		Info info2 = new Info();
		info2.setEmail("TestEmail2");
		info2.setPhone("TestPhone2");
		info2.setAddress("TestAddress2");
		Posts posts = new Posts();
		posts.setAuthor("Nag");
		posts.setTitle("AdvancedTitle");
		posts.setId("20");
		posts.setInfo(new Info[] {info1,info2});
		
		Response resp = given().
				        when().
				        contentType(ContentType.JSON).
				        body(posts).
				        post("http://localhost:3000/posts");
		System.out.println("Response is :"+resp.getStatusCode());
		System.out.println(resp.asString());
				        
	}
}
