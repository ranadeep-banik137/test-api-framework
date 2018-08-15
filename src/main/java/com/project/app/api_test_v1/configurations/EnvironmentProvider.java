package com.project.app.api_test_v1.configurations;

public class EnvironmentProvider {
	
	private String environmentUrl;
	private static EnvironmentProvider envObject;
	
	private EnvironmentProvider(final String environment) {
		this.environmentUrl = environment;
	}

	public String getEnvironmentUrl() {
		return this.environmentUrl;
	}

	public void setEnvironmentUrl(String environmentUrl) {
		this.environmentUrl = environmentUrl;
	}
	
	public static void setEnvironmentObject(final String env) {
		EnvironmentProvider.envObject = new EnvironmentProvider(env);
	}
	
	public static EnvironmentProvider getEnvironmentObject() {
		return EnvironmentProvider.envObject;
	}

}
