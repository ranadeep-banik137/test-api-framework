package com.project.app.api_test_v1.factory;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public interface RestJob {

	Response postCall(RequestSpecification specification);
	
	Response putCall(RequestSpecification specification);
	
	Response getCall(RequestSpecification specification);
	
	Response deleteCall(RequestSpecification specification);
	
	Response postCall();
	
	Response putCall();
	
	Response getCall();
	
	Response deleteCall();
	
}
