package com.project.app.api_test_v1.restFiles;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import com.project.app.api_test_v1.utilities.RestCalls;


public class DeleteApiCall extends RestCalls {
	
	public DeleteApiCall(String basePath, String baseUri) {
		super(basePath, baseUri);
	}
	
	@Override
	public Response deleteCall() {
		super.setRequestSpecification();
		super.validatableResponse = super.requestSpec.delete().then();
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
