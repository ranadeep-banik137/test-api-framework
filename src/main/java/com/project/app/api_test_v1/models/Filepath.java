package com.project.app.api_test_v1.models;

public interface Filepath {

	/** 'user.dir' */
	String SYSTEM_PATH = System.getProperty("user.dir");
	
	/** 'line.separator' */
	String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/** 'src' */
	String SRC_NAME = "src";
	
	/** 'main' */
	String MAIN_NAME = "main";
	
	/** 'test' */
	String TEST_NAME = "test";
	
	/** 'resources' */
	String RESOURCES_NAME = "resources";
	
	/** 'config' */
	String CONFIG_FOLDER = "config";
	
	/** 'requests' */
	String REQUESTS_FOLDER = "requests";
	
	/** 'schemas' */
	String SCHEMAS_FOLDER = "schemas";
	
	/** 'default' */
	String DEFAULT_FOLDER = "default";
	
	/** 'java' */
	String JAVA_NAME = "java";
	
	/** 'src\main\resources' */
	String MAIN_RESOURCES_FILE_PATH = SRC_NAME.concat(Operators.FORWARD_SLASH_OPERATOR).concat(MAIN_NAME).concat(Operators.FORWARD_SLASH_OPERATOR).concat(RESOURCES_NAME);
	
	/** 'src\main\resources' */
	String TEST_RESOURCES_FILE_PATH = SRC_NAME.concat(Operators.FORWARD_SLASH_OPERATOR).concat(TEST_NAME).concat(Operators.FORWARD_SLASH_OPERATOR).concat(RESOURCES_NAME);
	
	/** 'headers.properties' */
	String HEADER_FILE = "headers.properties";
	
	/** 'pathparams.properties' */
	String PATH_PARAM_FILE = "pathparams.properties";
	
	/** 'queryparams.properties' */
	String QUERY_PARAM_FILE = "queryparams.properties";
}
