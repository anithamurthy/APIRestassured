package com.testapp.apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testapp.apis.UserApiCalls;
import com.testapp.assertions.TestAppAssertions;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class UpdateUserTest {
	
	private UserApiCalls userApi;
	protected TestAppAssertions assertions = new TestAppAssertions();

	@BeforeClass
	public void init() {
		 userApi = new UserApiCalls();
	}
	
	@Test(description = "Api to test the user update")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Test the api update method")
	public void userUpdateTest() {
		String id = userApi.updateUser(1).jsonPath().getString("id");
		assertions.verifyNotNull(id, "updated");
		
		
	}

}
