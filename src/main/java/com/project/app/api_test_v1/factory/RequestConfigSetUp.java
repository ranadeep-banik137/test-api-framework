package com.project.app.api_test_v1.factory;

import io.restassured.specification.RequestSpecification;

public interface RequestConfigSetUp {

	public void setRequestSpecification();
	
	public RequestSpecification getRequestSpecification();
}
