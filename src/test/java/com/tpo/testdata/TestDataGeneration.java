package com.tpo.testdata;
import org.json.JSONObject;
public class TestDataGeneration {
	public static String jsonBody()
	{
		JSONObject object=new JSONObject();
		object.put("email", "eve.holt@reqres.in");
		object.put("password", "pistol");
		String jsonBody=object.toString();
		return jsonBody;		
	}
}