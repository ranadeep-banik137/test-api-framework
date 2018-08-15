package com.project.app.api_test_v1.restFiles;

import com.project.app.api_test_v1.utilities.RestCalls;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetApiCall extends RestCalls {

	public GetApiCall(String basePath, String baseUri) {
		super(basePath, baseUri);
	}
	
	@Override
	public Response getCall() {
		super.setRequestSpecification();
		super.validatableResponse = super.requestSpec.get().then();
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
