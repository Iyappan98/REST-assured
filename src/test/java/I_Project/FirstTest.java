package I_Project;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class FirstTest {
	
	@Test
	public void getAuthToken() throws InterruptedException, ParseException {
		RA_Utilities restAssured = new RA_Utilities();
		String URI = "https://heisenbergproxies2.azurewebsites.net/int/auth/user/authenticate";
		String token = restAssured.postCall(URI, 200, "authToken");	
		restAssured.getToken(token);
		System.out.println("Auth token printed successfully");
	}

}
