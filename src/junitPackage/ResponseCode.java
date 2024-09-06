package junitPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;


import org.junit.Test;

public class ResponseCode {
	
	
		String google = "https://www.google.com";
		
	
	@Test
	public void testResponse() throws URISyntaxException, IOException {
		URI ob = new URI(google);
		HttpURLConnection connection = (HttpURLConnection)ob.toURL().openConnection();
		//connection.setRequestMethod("GET");
		connection.connect();
		if(connection.getResponseCode() == 200) {
			System.out.println("Successful : " +google);
		}
		else if(connection.getResponseCode() == 404) {
			System.out.println("broken link" +google);
		}
	}

}
