package apiDemo;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class getAndPostExamples {
	
	//@Test
	public void getCall() {
		
		baseURI = "https://reqres.in/api";
		given().
		  get("/users?page=2").
		then().
		  statusCode(200).body("data[1].id",equalTo(8)).
		  log().all();
	}
	
	//@Test
	public void postCall() {
//		Map<String ,Object> map = new HashMap<String, Object>();
//		map.put("name", "Iyappan");
//		map.put("job", "Tester");		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		//another method
		request.put("name", "Iyappan");
		request.put("job", "Tester");
		
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		  headers("Content-type","application/json").
		  contentType(ContentType.JSON).accept(ContentType.JSON).
		  body(request.toJSONString()).
		when().
		  post("/users").
		then().
		  statusCode(201).
		  log().all();
	}
	
	//@Test
	public void putCall() {
       JSONObject request = new JSONObject();
		
		//another method
		request.put("name", "Iyappan");
		request.put("job", "Tester");
		
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		  body(request.toJSONString()).
		when().
		  put("/users/2").
		then().
		  statusCode(200).
		  log().all();
	}
	
	//@Test
	public void patchCall() {
       JSONObject request = new JSONObject();
		
		//another method
		request.put("name", "Iyappan");
		request.put("job", "Tester");
		
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		System.out.println(request.toString());
		
		baseURI = "https://reqres.in";
		
		given().
		  body(request.toJSONString()).
		when().
		  patch("/api/users/2").
		then().
		  statusCode(204).
		  log().all();
	}
	
	@Test
	public void deleteCall() {
       
		
		baseURI = "https://reqres.in";
		
		given().
		when().
		  patch("/api/users/2").
		then().
		  statusCode(204).
		  log().all();
	}

}
