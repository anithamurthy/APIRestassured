package com.testapp.apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testapp.apis.UserApiCalls;
import com.testapp.assertions.TestAppAssertions;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class GetUserByIdTest {
	
	private UserApiCalls userApi;
	protected TestAppAssertions assertions = new TestAppAssertions();
	
	@BeforeClass
	public void init() {
		 userApi = new UserApiCalls();
	}
	
	@Test(description="Api to test get user")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Test the api get user by id")
	public void testGetAUser() {
		Response resp = userApi.getUserById(1);
		System.out.println(resp.getStatusCode());
		assertions.verifyString(userApi.getUserById(1).jsonPath().getString("name"), "Leanne Graham");
		
	}

}
