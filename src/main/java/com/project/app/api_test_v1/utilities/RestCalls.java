package com.project.app.api_test_v1.utilities;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import com.project.app.api_test_v1.configurations.RestSpecifications;
import com.project.app.api_test_v1.factory.RequestConfigSetUp;
import com.project.app.api_test_v1.factory.ResponseConfigSetUp;
import com.project.app.api_test_v1.factory.RestJob;

public class RestCalls implements RestJob, RequestConfigSetUp, ResponseConfigSetUp {

	private static Logger LOGGER = Logger.getLogger(RestCalls.class.getName());
	public static RestSpecifications restObject;
	protected static String basePath;
	protected static String baseUri;
	protected String requestBody;
	protected RequestSpecification requestSpec;
	protected ValidatableResponse validatableResponse;
	protected Response response;
	protected JsonUtils jsonUtilObject;
	protected Map<String, Object> queryParams;
	protected Map<String, Object> pathParams;
	protected Map<String, Object> headers;
	
	public RestCalls(final String basePath, final String baseUri) {
		RestCalls.basePath = basePath;
		RestCalls.baseUri = baseUri;
		RestSpecifications.setRestSpecObject(RestCalls.basePath, RestCalls.baseUri);
		restObject = RestSpecifications.getRestSpec();
	}
	
	public void loadPayloadString(final String flatFileName) {
		try {
			this.requestBody = restObject.getRequestPayloadAsString(flatFileName);
		} catch (IOException exceptionObject) {
			exceptionObject.printStackTrace();
		}
		
		LOGGER.info("Requested payload ".concat(this.requestBody));
	}
	
	public void updatePayloadField(final String path, final Object value) {
		this.jsonUtilObject = new JsonUtils(this.requestBody);
		this.requestBody = this.jsonUtilObject.modifyFieldInJson(path, value);
		LOGGER.info("Updated payload ".concat(this.requestBody));
	}
	
	public void updatePayloadFields(final Map<String, Object> fieldMapper) {
		this.jsonUtilObject = new JsonUtils(this.requestBody);
		this.requestBody = this.jsonUtilObject.modifyFieldsInJson(fieldMapper);
		LOGGER.info("Updated payload ".concat(this.requestBody));
	}
	
	public void deletePayloadField(final String path) {
		this.jsonUtilObject = new JsonUtils(this.requestBody);
		this.requestBody = this.jsonUtilObject.deleteFieldInJson(path);
		LOGGER.info("Updated payload ".concat(this.requestBody));
	}
	
	public void addPayloadField(final String parentPath, final String newpath, final Object value) {
		this.jsonUtilObject = new JsonUtils(this.requestBody);
		this.requestBody = this.jsonUtilObject.addFieldInJson(parentPath, newpath, value);
		LOGGER.info("Updated payload ".concat(this.requestBody));
	}
	
	public void addFieldInJsonArray(final String arrayPath, final Object value) {
		this.jsonUtilObject = new JsonUtils(this.requestBody);
		this.requestBody = this.jsonUtilObject.addFieldInJsonArray(arrayPath, value);
		LOGGER.info("Updated payload ".concat(this.requestBody));
	}
	
	public void deletePayloadFields(final List<String> fieldList) {
		this.jsonUtilObject = new JsonUtils(this.requestBody);
		this.requestBody = this.jsonUtilObject.deleteFieldsInJson(fieldList);
		LOGGER.info("Updated payload ".concat(this.requestBody));
	}
	
	public void modifyHeaders(final Map<String, Object> latestHeaders) {
		this.headers = latestHeaders;
		
		LOGGER.info("Headers updated : ".concat(String.valueOf(latestHeaders)));
	}
	
	public void modifyHeaders(final String key, final Object value) throws InvalidAlgorithmParameterException {
		if (!this.headers.containsKey(key))
			throw new InvalidAlgorithmParameterException("Header not found");
		else {
			this.headers.remove(key);
			this.headers.put(key, value);
		}
		LOGGER.info("Headers updated : ".concat(String.valueOf(this.headers)));
	}
	
	public void modifyPathParams(final Map<String, Object> latestParams) {
		this.pathParams = latestParams;
		
		LOGGER.info("Path params updated : ".concat(String.valueOf(latestParams)));
	}
	
	public void modifyPathParam(final String key, final Object value) throws InvalidAlgorithmParameterException {
		if (!this.pathParams.containsKey(key))
			throw new InvalidAlgorithmParameterException("Path Param not found");
		else {
			this.pathParams.remove(key);
			this.pathParams.put(key, value);
		}
		LOGGER.info("Path params updated : ".concat(String.valueOf(this.pathParams)));
	}
	
	public void modifyQueryParams(final Map<String, Object> latestParams) {
		this.queryParams = latestParams;
		LOGGER.info("Query params updated : ".concat(String.valueOf(latestParams)));
	}
	
	public void modifyQueryParam(final String key, final Object value) throws InvalidAlgorithmParameterException {
		if (!this.queryParams.containsKey(key))
			throw new InvalidAlgorithmParameterException("Query Param not found");
		else {
			this.queryParams.put(key, value);
		}
		LOGGER.info("Query params updated : ".concat(String.valueOf(this.queryParams)));
	}
	
	public void setValidatableResponse(Response response) {
	}
	
	public ValidatableResponse getValidatableResponse() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Response extractResponse() {
		return null;
	}
	
	protected void setInitialRestCallConfigurations() {
		restObject.initiateRestConfig();
		restObject.initializeHttpsValidations();
		
		LOGGER.info("Rest Assured initial configurations initiated");
	}
	
	public void setAllRestAssuredParameters() {
		this.headers = restObject.getHeaderMap();
		this.queryParams = restObject.getQueryParamsMapper();
		this.pathParams = restObject.getPathParamsMapper();
	}
	
	@SuppressWarnings("deprecation")
	public void setRequestSpecification() {
		setInitialRestCallConfigurations();
		this.requestSpec = RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON);
		if (headers != null)
			this.requestSpec.headers(this.headers);
		if (queryParams != null)
			this.requestSpec.queryParameters(this.queryParams);
		if (pathParams != null)
			this.requestSpec.pathParams(this.pathParams);
		if (!(this.requestBody == null))
			this.requestSpec.body(this.requestBody).log().all();
	}
	
	public RequestSpecification getRequestSpecification() {
		return this.requestSpec;
	}

	public Response postCall(RequestSpecification specification) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response putCall(RequestSpecification specification) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response getCall(RequestSpecification specification) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response deleteCall(RequestSpecification specification) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Response postCall() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response putCall() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response getCall() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response deleteCall() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void logAllPerfomance() {
		this.validatableResponse.log().all();
	}
	
	public String getRequestJson() {
		return this.requestBody;
	}
	
	public String getResponseJson() {
		return this.response.asString();
	}
	
	public Map<String, Object> getHeadersMap() {
		return this.headers;
	}
	
	public Map<String, Object> getQueryParamsMap() {
		return this.queryParams;
	}
	
	public Map<String, Object> getPathParamsMap() {
		return this.pathParams;
	}
	
	public void matchResponseWithSchema(String schemaFileName) {
		this.validatableResponse.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaFileName));
	}
}
