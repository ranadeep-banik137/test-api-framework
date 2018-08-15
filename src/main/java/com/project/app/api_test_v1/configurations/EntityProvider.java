package com.project.app.api_test_v1.configurations;

import org.apache.commons.lang3.StringUtils;

public class EntityProvider {

	private String entity;
	private static String systemEntity;
	private static EntityProvider entityObject;
	
	static {
		EntityProvider.systemEntity = System.getProperty("entity");
	}
	
	
	private EntityProvider() {
		this.entity = EntityProvider.entityConverter();
	}
	private EntityProvider(final String entity) {
		this.entity = entity;
	}
	
	private static String entityConverter() {
		return systemEntity == null ? StringUtils.EMPTY : systemEntity;
	}
	
	public void setEntity(final String entity) {
		this.entity = entity;
	}
	
	public String getEntity() {
		return this.entity;
	}
	
	public static void setEntityObject(final String entity) {
		EntityProvider.entityObject = new EntityProvider(entity);
	}
	
	public static void setEntityObject() {
		EntityProvider.entityObject = new EntityProvider();
	}
	
	public static EntityProvider getEntityObject() {
		return EntityProvider.entityObject;
	}
}
