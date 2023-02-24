package com.tpo.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class RestUtils {

	public static Response sendPostRequest(String postBody)
	{
		Response response=given()
				 		  .header("Content-Type","application/json")
				 		  .body(postBody).log().all()
				 		  .when()
				 		  .post();				 		  
		return response;	
	}
	public static Response sendPutRequest(String postBody)
	{
		Response response=given()
				 		  .header("Content-Type","application/json")
				 		  .body(postBody)
				 		  .when()
				 		  .put();
		return response;	
	}
	public static Response sendDeleteRequest()
	{
		Response response=given()
				 		  .header("Content-Type","application/json")
				 		  .when()
				 		  .delete();
		return response;	
	}
	public static Response sendGetRequest()
	{
		Response response=given()
				 		  .header("Content-Type","application/json")
				 		  .when()
				 		  .get();
		return response;	
	}
}
