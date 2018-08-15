package com.project.app.api_test_v1.utilities;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonUtils {
	
	private DocumentContext jsonConverter;
	private String jsonBody;
	
	public JsonUtils(String jsonBody) {
		this.jsonBody = jsonBody;
		this.jsonConverter = JsonPath.using(Configuration.defaultConfiguration()).parse(this.jsonBody);
	}
	
	public String modifyFieldInJson(final String path, final Object value) {
		this.jsonConverter.set(path, value);
		return this.jsonConverter.jsonString();
	}
	
	public String modifyFieldsInJson(final Map<String, Object> fieldValueMappers) {
		for (Map.Entry<String, Object> mapper : fieldValueMappers.entrySet()) {
			this.jsonConverter.set(mapper.getKey(), mapper.getValue());
		}
		return this.jsonConverter.jsonString();
	}
	
	public String addFieldInJson(final String parentPath, final String newpath, final Object value) {
		this.jsonConverter.put(parentPath, newpath, value);
		return this.jsonConverter.jsonString();
	}
	
	public String addFieldInJsonArray(final String arrayPath, final Object value) {
		this.jsonConverter.add(arrayPath, value);
		return this.jsonConverter.jsonString();
	}
	
	public String deleteFieldInJson(final String fieldPath) {
		this.jsonConverter.delete(fieldPath);
		return this.jsonConverter.jsonString();
	}
	
	public String deleteFieldsInJson(final List<String> fieldList) {
		for (String field : fieldList) {
			this.jsonConverter.delete(field);
		}
		return this.jsonConverter.jsonString();
	}

}
