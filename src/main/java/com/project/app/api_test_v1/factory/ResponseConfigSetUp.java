package com.project.app.api_test_v1.factory;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public interface ResponseConfigSetUp {
	
	public void setValidatableResponse(Response response);

	public ValidatableResponse getValidatableResponse();
	
	public Response extractResponse();
}
