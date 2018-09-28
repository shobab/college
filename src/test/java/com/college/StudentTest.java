package com.college;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class StudentTest {

	@Test
	public void getAll() throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		  HttpGet request = new HttpGet("http://localhost:8081/students/all");
		
		  HttpResponse response = client.execute(request);
		
		  BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
		
		  String line = "", result = "";
		
		  while ((line = rd.readLine()) != null) {
		
		    System.out.println(line);
		    result += line;
		
		  }
		  JSONArray expected = new JSONArray("[\n" + 
		  		"    {\n" + 
		  		"        \"name\": \"sneha\",\n" + 
		  		"        \"roll\": \"2014255\",\n" + 
		  		"        \"branch\": \"ECE\",\n" + 
		  		"        \"phone\": [\n" + 
		  		"            \"9492082312\"\n" + 
		  		"        ]\n" + 
		  		"    },\n" + 
		  		"    {\n" + 
		  		"        \"name\": \"shobab\",\n" + 
		  		"        \"roll\": \"2014064\",\n" + 
		  		"        \"branch\": \"CSE\",\n" + 
		  		"        \"phone\": [\n" + 
		  		"            \"7587528959\",\n" + 
		  		"            \"9182384752\"\n" + 
		  		"        ]\n" + 
		  		"    }\n" + 
		  		"]");
		  JSONArray actual = new JSONArray(result);
		  JSONAssert.assertEquals(expected, actual, false);

	}
}
