package com.project.app.api_test_v1.restFiles;

import com.project.app.api_test_v1.utilities.RestCalls;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PutApiCall extends RestCalls {

	public PutApiCall(String basePath, String baseUri) {
		super(basePath, baseUri);
	}
	
	@Override
	public Response putCall() {
		super.setRequestSpecification();
		super.validatableResponse = super.requestSpec.put().then();
		super.logAllPerfomance();
		super.response = super.validatableResponse.extract().response();
		return super.response;
	}
	
	@Override
	public ValidatableResponse getValidatableResponse() {
		return this.validatableResponse;
	}
	
	@Override
	public Response extractResponse() {
		return super.response;
	}
}
