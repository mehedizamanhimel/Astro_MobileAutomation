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
	
	
	public void createProject(String token,  
			int uuid, String name) throws IOException {
		
		testdata = new testProperty();
		
		RestAssured.baseURI = testdata.properties.getProperty("baseUrl");
		RestAssured.basePath = "/rest/v1/projects";
		
		jsonresponse = new JsonPath(RestAssured.
				given().
				contentType("application/json").
				header("Authorization", token).
				header("X-Request-Id", uuid).
				
				queryParam("name" , name).
				//body(json.toString()).
				when().
				post().
				asString());
		
		//jsonresponse.prettyPrint();
			
	}
	
	public int getID() {
		return jsonresponse.getInt("id");
	}
	
	public int getOrder() {
		return jsonresponse.getInt("order");
	}
	
	public String getProjectName() {
		return jsonresponse.getString("name");
	}
	
	public int getResponseCode() {
		return jsonresponse.getInt("responseCode");
	}
	


}
