package com.tpo.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tpo.testbase.TestBase;
import com.tpo.testdata.TestDataGeneration;
import com.tpo.utils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestAPI extends TestBase{
	public static int id;
	@Test
	public void postMethod()
	{		
		RestAssured.basePath="api/register";
		Response response=RestUtils.sendPostRequest(TestDataGeneration.jsonBody());
		Assert.assertEquals(200,response.getStatusCode()); //Validating response code
		id=response.getBody().jsonPath().get("id");
	}
	@Test
	public void putMethod()
	{
		RestAssured.basePath="api/users/"+id;
		JSONObject object=new JSONObject();
		object.put("name", "test");
		String jsonBody=object.toString();
		Response response=RestUtils.sendPutRequest(jsonBody);
		Assert.assertEquals(200,response.getStatusCode());
		
	}
	@Test
	public void getMethod()
	{
		RestAssured.basePath="api/users/"+id;
		Response response=RestUtils.sendGetRequest();
		Assert.assertEquals(200,response.getStatusCode());	
		System.out.println(response.getBody().asString());
	}
	@Test
	public void deleteMethod()
	{
		RestAssured.basePath="api/users/"+id;
		Response response=RestUtils.sendDeleteRequest();
		Assert.assertEquals(204,response.getStatusCode());	
	}	
}
