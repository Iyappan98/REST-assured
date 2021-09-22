package I_Project;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class FirstTest {
	
	@Test
	public void getAuthToken() throws InterruptedException, ParseException, IOException {
		RA_Utilities restAssured = new RA_Utilities();
		String uri = restAssured.retrive("uri");
		String payload = restAssured.retrive("payload");
		String statusCode = restAssured.retrive("statusCode");
		String token = restAssured.postCall(uri, statusCode, payload);	
		restAssured.getToken(token);
		System.out.println("Auth token printed successfully");
	}

}
