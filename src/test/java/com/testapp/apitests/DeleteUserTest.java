package com.testapp.apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testapp.apis.UserApiCalls;
import com.testapp.assertions.TestAppAssertions;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

public class DeleteUserTest {

	UserApiCalls userApi = new UserApiCalls();
	TestAppAssertions assertions = new TestAppAssertions();

	@BeforeClass
	public void init() {
		userApi = new UserApiCalls();

	}

	@Test(description="Api to delete user")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Test the api to delete user by id")
	public void deleteUser() {

		Response resp = userApi.deleteUser(1);
		System.out.println(resp.getStatusCode());

	}

}
