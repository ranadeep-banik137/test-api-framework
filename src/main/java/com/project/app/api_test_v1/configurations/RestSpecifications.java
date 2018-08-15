package com.project.app.api_test_v1.configurations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import io.restassured.RestAssured;

import com.project.app.api_test_v1.models.Constants;
import com.project.app.api_test_v1.models.Operators;
import com.project.app.api_test_v1.utilities.FileUtils;

public class RestSpecifications {
	
	private static Logger LOGGER = Logger.getLogger(RestSpecifications.class.getName());
	public static String BASE_URI;
	public static String BASE_PATH;
	private static EnvironmentProvider env;
	private static FileUtils fileObject;
	private static PathSpecifier pathSpecifierObject;
	private static EndPointSpecifications endPointObject;
	private static EntityProvider entityObject;
	private static RestSpecifications restSpec;
	
	static {
		EnvironmentProvider.setEnvironmentObject(System.getenv(Constants.ENV_CONSTANT));
		EntityProvider.setEntityObject();
		
		RestSpecifications.env = EnvironmentProvider.getEnvironmentObject();
		RestSpecifications.entityObject = EntityProvider.getEntityObject();
		fileObject = new FileUtils();
		pathSpecifierObject = new PathSpecifier(entityObject);
		
		LOGGER.info("EndPoint Base URI: ".concat(env.getEnvironmentUrl()));
	}
	
	private RestSpecifications(final String baseUri, final String basePath) {
		RestSpecifications.BASE_URI = baseUri;
		RestSpecifications.BASE_PATH = basePath;
		EndPointSpecifications.setRestConfig(BASE_PATH, BASE_URI);
		RestSpecifications.endPointObject = EndPointSpecifications.getRestConfig();
	}
	
	public void initiateRestConfig() {
		RestAssured.baseURI = env.getEnvironmentUrl();
		RestAssured.basePath = endPointObject.getEndPath().concat(endPointObject.getEndUri());
		
		LOGGER.info("Base Uri : ".concat(RestAssured.baseURI));
		LOGGER.info("Base Path : ".concat(RestAssured.basePath));
	}
	
	public void initializeHttpsValidations() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public static void setRestSpecObject(final String basePath, final String baseUri) {
		restSpec = new RestSpecifications(baseUri, basePath);
	}
	
	public static RestSpecifications getRestSpec() {
		return restSpec;
	}
	
	public Map<String, Object> getHeaderMap() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		
		try {
			headerMap = RestSpecifications.fileObject.getPropertyFileDataStream(RestSpecifications.pathSpecifierObject.getHeadersPath());
		} catch (FileNotFoundException exceptionObject) {
			exceptionObject.printStackTrace();
		}
		return headerMap;
	}
	
	public Map<String, Object> getPathParamsMapper() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		
		try {
			headerMap = RestSpecifications.fileObject.getPropertyFileDataStream(RestSpecifications.pathSpecifierObject.getPathParamsPath());
		} catch (FileNotFoundException exceptionObject) {
			exceptionObject.printStackTrace();
		}
		return headerMap;
	}
	
	public Map<String, Object> getQueryParamsMapper() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		
		try {
			headerMap = RestSpecifications.fileObject.getPropertyFileDataStream(RestSpecifications.pathSpecifierObject.getQueryParamsPath());
		} catch (FileNotFoundException exceptionObject) {
			exceptionObject.printStackTrace();
		}
		return headerMap;
	}
	
	public String getRequestPayloadAsString(final String FlatFileName) throws IOException {
		String requestPath = RestSpecifications.pathSpecifierObject.getRequestSourcePath();
		return RestSpecifications.fileObject.readFileToString(requestPath.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(FlatFileName)));
	}
	
	public String getSchemaFileAsString(final String FlatFileName) throws IOException {
		String schemasPath = RestSpecifications.pathSpecifierObject.getSchemaSourcePath();
		return RestSpecifications.fileObject.readFileToString(schemasPath.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(FlatFileName)));
	}
	
}
