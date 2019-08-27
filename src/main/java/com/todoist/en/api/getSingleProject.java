package com.todoist.en.api;

import java.io.IOException;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.testProperty;

public class getSingleProject {
	
	
	testProperty testdata;
	JsonObject json = new JsonObject();
	JsonPath jsonresponse;
	
	
	public void createProject(String token,  
			int uuid, String name, int projectID) throws IOException {
		
		testdata = new testProperty();
		
		RestAssured.baseURI = testdata.properties.getProperty("baseUrl");
		RestAssured.basePath = "/rest/v1/projects/{projectID}";
		
		jsonresponse = new JsonPath(RestAssured.
				given().
				contentType("application/json").
				header("Authorization", token).
				pathParam("projectID",projectID).
				body(json.toString()).
				when().
				get().
				asString());
		
		jsonresponse.prettyPrint();
			
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
