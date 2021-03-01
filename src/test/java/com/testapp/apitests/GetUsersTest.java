package com.testapp.apitests;


import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testapp.apis.UserApiCalls;
import com.testapp.assertions.TestAppAssertions;
import com.testapp.pojos.User;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GetUsersTest {

	private UserApiCalls userApi;
	protected TestAppAssertions assertions = new TestAppAssertions();

	@BeforeClass
	public void init() {

		 userApi = new UserApiCalls();

	}

	@Test(description="Test api to get all the users")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description: Test api to get all the users")
	public void testGetUsers() {

		List<User> usersList = userApi.getUsers();
		assertions.verifyNotNull(usersList, "The users list is empty");

	}

}
