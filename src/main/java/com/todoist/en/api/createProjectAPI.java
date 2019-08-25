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
	
	
	public void createProject(String token, String type, 
			String temp_id, String uuid, 
			String args, String name, int color,
			int is_favorite, int parent_id, int child_order) throws IOException {
		
		testdata = new testProperty();
		
		RestAssured.baseURI = testdata.properties.getProperty("baseUrl");
		RestAssured.basePath = "API/v8.3/sync";
		
		jsonresponse = new JsonPath(RestAssured.
				given().
				header("token", token).
				contentType("application/json").
				
				queryParam("type" , type).
				queryParam("temp_id" , temp_id).
				queryParam("uuid" , uuid).
				queryParam("args" , args).
				queryParam("name" , name).
				queryParam("color" , color).
				queryParam("parent_id" , parent_id).
				queryParam("child_order" , child_order).
				queryParam("is_favorite" , is_favorite).
				body(json.toString()).
				when().
				post().
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
