package com.testapp.assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import io.restassured.response.Response;

public class TestAppAssertions {

	public void verifyStatusCode(Response response) {
		assertEquals(String.valueOf(response.getStatusCode()).startsWith("20"), true,
				"value of status code is" + response.getStatusCode());
	}

	public <T> void verifyListNotNull(List<T> list) {
		assertNotNull(list, "List is not empty");
	}

	public void verifyString(String actual, String expected) {
		assertEquals(actual, expected);
	}

	public void verifyNotNull(Object object, String message) {
		assertNotNull(object, message);
	}
	
	public void verifyStatusCode(int actualStatus, int expectedStatus) {
		assertEquals(actualStatus, expectedStatus, "Http status is OK");		
	}

}
