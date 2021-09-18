package apiDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class testOnLocalserver {
	
	    //@Test
		public void getCall() {
			
			baseURI = "http://localhost:3000";
			given().
			  get("/users").
			then().
			  statusCode(200).
			  log().all();
		}
		
		//@Test
		public void postCall() {
//			Map<String ,Object> map = new HashMap<String, Object>();
//			map.put("name", "Iyappan");
//			map.put("job", "Tester");		
//			System.out.println(map);
			
			JSONObject request = new JSONObject();
			
			//another method
			request.put("first-name", "dhoni");
			request.put("last-name", "MS");
			request.put("subjectId", 1);
			
			
			System.out.println(request);
			System.out.println(request.toJSONString());
			System.out.println(request.toString());
			
			baseURI = "http://localhost:3000";
			
			given().
			  contentType(ContentType.JSON).
			  accept(ContentType.JSON).
			  body(request.toJSONString()).
			when().
			  post("/users").
			then().
			  statusCode(201).
			  log().all();
		}
		
		@Test
		public void putCall() {
JSONObject request = new JSONObject();
			
			//another method
			request.put("first-name", "rohit");
			request.put("last-name", "sharma");
			request.put("subjectId", 3);
			
			
			System.out.println(request);
			System.out.println(request.toJSONString());
			System.out.println(request.toString());
			
			baseURI = "http://localhost:3000";
			
			given().
			  contentType(ContentType.JSON).
			  accept(ContentType.JSON).
			  body(request.toJSONString()).
			when().
			  put("/users/1").
			then().
			  statusCode(200);
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
		
		//@Test
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
