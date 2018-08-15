package com.project.app.api_test_v1.configurations;

import java.io.FileNotFoundException;

import org.apache.commons.lang3.StringUtils;

import com.project.app.api_test_v1.models.Filepath;
import com.project.app.api_test_v1.models.Operators;

public class PathSpecifier {

	private String configPath;
	private String requestPath;
	private String schemaPath;
	private EntityProvider entityObject;

	public PathSpecifier() {}
	
	public PathSpecifier(EntityProvider entityObject) {
		this.entityObject = entityObject;
	}
	
	public void setEntityProvider(final EntityProvider entityObject) {
		this.entityObject = entityObject;
	}
	
	public EntityProvider getEntityProvider() {
		return this.entityObject;
	}
	
	public String getConfigPath() throws FileNotFoundException {
		String srcPath = this.entityObject.getEntity().equals(StringUtils.EMPTY) ? Filepath.DEFAULT_FOLDER : this.entityObject.getEntity(); 
		try {
			this.configPath =  Filepath.MAIN_RESOURCES_FILE_PATH.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(srcPath)).concat(Operators.BACKWARD_SLASH_OPERATOR.concat(Filepath.CONFIG_FOLDER));
		} catch (Exception exceptionObject) {
			this.configPath =  Filepath.TEST_RESOURCES_FILE_PATH.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(srcPath)).concat(Operators.BACKWARD_SLASH_OPERATOR.concat(Filepath.CONFIG_FOLDER));
		}
		return this.configPath;
	}
	
	public String getRequestSourcePath() throws FileNotFoundException {
		String srcPath = this.entityObject.getEntity().equals(StringUtils.EMPTY) ? Filepath.DEFAULT_FOLDER : this.entityObject.getEntity(); 
		try {
			this.requestPath =  Filepath.MAIN_RESOURCES_FILE_PATH.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(srcPath)).concat(Operators.BACKWARD_SLASH_OPERATOR.concat(Filepath.REQUESTS_FOLDER));
		} catch (Exception exceptionObject) {
			this.requestPath =  Filepath.TEST_RESOURCES_FILE_PATH.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(srcPath)).concat(Operators.BACKWARD_SLASH_OPERATOR.concat(Filepath.REQUESTS_FOLDER));
		}
		return this.requestPath;
	}
	
	public String getSchemaSourcePath() throws FileNotFoundException {
		String srcPath = this.entityObject.getEntity().equals(StringUtils.EMPTY) ? Filepath.DEFAULT_FOLDER : this.entityObject.getEntity(); 
		try {
			this.schemaPath =  Filepath.MAIN_RESOURCES_FILE_PATH.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(srcPath)).concat(Operators.BACKWARD_SLASH_OPERATOR.concat(Filepath.SCHEMAS_FOLDER));
		} catch (Exception exceptionObject) {
			this.schemaPath =  Filepath.TEST_RESOURCES_FILE_PATH.concat(Operators.BACKWARD_SLASH_OPERATOR.concat(srcPath)).concat(Operators.BACKWARD_SLASH_OPERATOR.concat(Filepath.SCHEMAS_FOLDER));
		}
		return this.schemaPath;
	}
	
	public String getHeadersPath() throws FileNotFoundException {
		return getConfigPath().concat(Operators.BACKWARD_SLASH_OPERATOR).concat(Filepath.HEADER_FILE);
	}
	
	public String getPathParamsPath() throws FileNotFoundException {
		return getConfigPath().concat(Operators.BACKWARD_SLASH_OPERATOR).concat(Filepath.PATH_PARAM_FILE);
	}
	
	public String getQueryParamsPath() throws FileNotFoundException {
		return getConfigPath().concat(Operators.BACKWARD_SLASH_OPERATOR).concat(Filepath.QUERY_PARAM_FILE);
	}
	
}
