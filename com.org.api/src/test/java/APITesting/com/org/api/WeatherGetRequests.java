package APITesting.com.org.api;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class WeatherGetRequests {

	// Getting weather request by using city name
	// This TestCase returns status code 200
	/*@Test(priority = 1)
	public void test_01() {
		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=Guntur&appid=3e7c04c77f6ee82af6a6edc316064a4b");
		System.out.println(resp.getStatusCode());
		assertEquals(resp.getStatusCode(), 200);
	}

	// This TestCase returns status code 401
	@Test(priority = 0)
	public void test_02() {
		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=Guntur&appid=3e7c04c77f6ee82af6a6edc316064a");
		System.out.println(resp.getStatusCode());
		assertEquals(resp.getStatusCode(), 401);
	}
*/
	// How to use parameters with rest Assured
	/*@Test(priority=3)
	public void test_03()
	{
		Response resp =given().
				       param("q","Hyderabad").
				       param("appid","3e7c04c77f6ee82af6a6edc316064a4b").
				       when().
	     get("http://api.openweathermap.org/data/2.5/weather");
		 int respCode = resp.getStatusCode();
		System.out.println("Response Code is "+respCode);
		if(respCode==200)
		{
			System.out.println("API is working fine");
		}else {
			System.out.println("API is not working ");
		}
		assertEquals(respCode, 200);
	
	}*/
	//Using Assert which is in restassured
	/*@Test()
	public void test_04()
	{
		               given().
				       param("q","Hyderabad").
				       param("appid","3e7c04c77f6ee82af6a6edc316064a4b").
				       when().
	                   get("http://api.openweathermap.org/data/2.5/weather").
	                   then().
	                   assertThat().statusCode(200);
		 
	}*/
	
	//Get Response when given parameter is ID 
	/*@Test(priority=3)
	public void test_05()
	{
		Response resp =given().
				       param("id","2172797").
				       param("appid","3e7c04c77f6ee82af6a6edc316064a4b").
				       when().
	     get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.asString());
		 int respCode = resp.getStatusCode();
		System.out.println("Response Code is "+respCode);
		if(respCode==200)
		{
			System.out.println("API is working fine");
		}else {
			System.out.println("API is not working ");
		}
		assertEquals(respCode, 200);
	
	}*/
	//Getting response by using zipcode
	/*@Test()
	public void test_06()
	{
		Response resp =given().
				       parameter("zip","94040").
				       parameter("appid","3e7c04c77f6ee82af6a6edc316064a4b").
				       when().
	     get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.asString());
		 int respCode = resp.getStatusCode();
		System.out.println("Response Code is "+respCode);
		if(respCode==200)
		{
			System.out.println("API is working fine");
		}else {
			System.out.println("API is not working ");
		}
		assertEquals(respCode, 200);
	
	}*/
	
// Extracting weather report	
	/*@Test()
	public void test_07()
	{
		String expectedWeatherReport = "light intensity shower rain";
		String actualWeatherReport =given().
				              param("id","2172797").
				              param("appid","3e7c04c77f6ee82af6a6edc316064a4b").
				              when().
	                          get("http://api.openweathermap.org/data/2.5/weather").
	                          then().
	                          contentType(ContentType.JSON).
	                          extract().
	                          path("weather[0].description");
		System.out.println("Weather Report is : "+actualWeatherReport);
		if(actualWeatherReport.equalsIgnoreCase(expectedWeatherReport))
		{
			System.out.println("TestCase Pass");
		}else {
			System.out.println("TestCase fail");
		}
	                   
	                   
	}*/
	//Finding Longitude nad Latitude and generating report based on longitude and latitude
	// Transfering API responce to other API
	@Test
	public void test_08()
	{
		Response resp =given().
			       param("id","2172797").
			       param("appid","3e7c04c77f6ee82af6a6edc316064a4b").
			       when().
                   get("http://api.openweathermap.org/data/2.5/weather");
		
		float f1 = resp.
				     then().
				     contentType(ContentType.JSON).
				     extract().
				     path("coord.lon");
		String lon = String.valueOf(f1);
		System.out.println("Longitude is :"+lon);
		float f2 = resp.
			         then().
			         contentType(ContentType.JSON).
			         extract().
			         path("coord.lat");
		String lat = String.valueOf(f2);
		System.out.println("Latitude is :"+lat);
		
		String weatherReport =given().
			                  param("lon",lon).
			                  param("lat",lat).
			                  param("appid","3e7c04c77f6ee82af6a6edc316064a4b").
			                  when().
                              get("http://api.openweathermap.org/data/2.5/weather").
                              then().
                              contentType(ContentType.JSON).
                              extract().
                              path("weather[0].description");
                   System.out.println("Weather report is :"+weatherReport);
				     
				     
		
		
	}
}
