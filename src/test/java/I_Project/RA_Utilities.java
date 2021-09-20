package I_Project;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;



public class RA_Utilities {
	
	public String getCall(String URI, int statusCode) {			
			Response response =given().
					             get(URI).
			                   then().
			                     statusCode(statusCode).
			                   extract().
			                     response();
			String responseBody = response.asString();
			return responseBody;
		}
		
	public String postCall(String URI,int statusCode, String payloadName) {
	    	File Payload = new File("src/test/resources/"+payloadName+".json");			
			Response response = given().
			                      headers("Content-type","application/json").
			                      body(Payload).
			                    when().
			                      post(URI).
			                    then().
			                      statusCode(statusCode).
			                      extract().
                                  response();
            String responseBody = response.asString();
            System.out.println(responseBody);
            return responseBody;
		}
		
		//@Test
		@SuppressWarnings("unchecked")
		public String putCall(String URI,int statusCode, String payloadName) throws ParseException {
			File Payload = new File("src/test/resources/"+payloadName+".json");	
			JSONParser parser = new JSONParser();
	        String payload = (String) Payload.toString();
	        JSONObject updatedPayload = (JSONObject) parser.parse(payload);
	        updatedPayload.put("name", "Iyappan");			
	        Response response = given().
			                      body(updatedPayload).
			                    when().
			                      put(URI).
			                      then().
			                      statusCode(200).
			                      extract().
                                  response();
	        String responseBody = response.asString();
            return responseBody;
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
		
			public void deleteCall(String URI) {			
			given().
			when().
			  patch(URI).
			then().
			  statusCode(204);
		}
			
			public String getToken(String response) throws ParseException {
				JSONParser parser = new JSONParser();
				JSONObject a = (JSONObject) parser.parse(response);
				String responseBody = a.get("jwt").toString();
				System.out.println(responseBody);
				return responseBody;
			}

}
