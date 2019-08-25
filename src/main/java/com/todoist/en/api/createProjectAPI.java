package com.todoist.en.api;

import java.io.IOException;
import java.sql.Date;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import utils.testProperty;

public class createProjectAPI {
	
	
	testProperty testdata;
	JsonObject json = new JsonObject();
	JsonPath jsonresponse;
	
	
	public void createProject(String token, String String) throws IOException {
		
		testdata = new testProperty();
		
		RestAssured.baseURI = testdata.properties.getProperty("baseUrl");
		RestAssured.basePath = "API/v8.3/sync";
		
		jsonresponse = new JsonPath(RestAssured.
				given().
				header("authtoken", token).
				contentType("application/json").
				
				queryParam("String" , String).
				body(json.toString()).
				when().
				get().
				asString());
		
		jsonresponse.prettyPrint();
			
	}
	
	public String getDataValue() {
		return jsonresponse.getString("data");
	}
	
	public String getSuccessValue() {
		return jsonresponse.getString("success");
	}
	
	public String getMessage() {
		return jsonresponse.getString("message").toString();
	}
	
	public String getResponseCode() {
		return jsonresponse.getString("responseCode").toString();
	}
	


}
