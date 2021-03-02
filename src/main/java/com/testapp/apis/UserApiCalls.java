package com.testapp.apis;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.testapp.assertions.TestAppAssertions;
import com.testapp.endpoints.APIEndpoints;
import com.testapp.pojos.User;
import com.testapp.utils.PropertyManager;
import com.testapp.utils.ReadExcel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserApiCalls {

	private static final String BASE_URL = PropertyManager.getInstance().getString("base_url");
	TestAppAssertions testAssert = new TestAppAssertions();

	public UserApiCalls() {

		RestAssured.baseURI = BASE_URL;
		RestAssured.useRelaxedHTTPSValidation();

	}

	//List all the users
	public List<User> getUsers() {

		Response resp = RestAssured.given().log().all().contentType(ContentType.JSON).get(APIEndpoints.GET_ALL_USERS)
				.andReturn();
		Type type = new TypeReference<List<User>>() {
		}.getType();
		testAssert.verifyStatusCode(resp.getStatusCode(), HttpStatus.SC_OK);
		List<User> users = resp.as(type);
		return users;

	}

	//Get user by id
	public Response getUserById(Integer id) {

		Response resp = RestAssured.given().log().all().contentType(ContentType.JSON).pathParam("id", id)
				.get(APIEndpoints.GET_ONE_USER).andReturn();
		testAssert.verifyStatusCode(resp.getStatusCode(), HttpStatus.SC_OK);
		return resp;

	}

	//We can update this method to modify any attribute.
	public Response updateUser(Integer id) {
		
		Object[][] userDetails = ReadExcel.readExcelData("user_data");
		User user = new User();
		user.setName(userDetails[1][0].toString());
		user.setUsername(userDetails[1][1].toString());
		user.setEmail(userDetails[1][2].toString());
		user.setPhone(userDetails[1][3].toString());
		Response resp = RestAssured.given().log().all().contentType(ContentType.JSON).pathParam("id", id).when()
				.body(user).patch(APIEndpoints.UPDATE_USER).andReturn();
		testAssert.verifyStatusCode(resp.getStatusCode(), HttpStatus.SC_OK);
		return resp;

	}

	//delete user
	public Response deleteUser(Integer id) {

		Response resp = RestAssured.given().contentType(ContentType.JSON).pathParam("id", id).log().all().when()
				.delete(APIEndpoints.DELETE_USER).andReturn();
		return resp;

	}

}
