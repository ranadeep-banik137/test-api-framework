package com.project.app.api_test_v1.configurations;

public class EndPointSpecifications {
	
	private String endUri;
	private String endPath;
	private static EndPointSpecifications restConfigurations;
	
	private EndPointSpecifications(final String endPath, final String endUri) {
		this.endPath = endPath;
		this.endUri = endUri;
	}
	
	public static void setRestConfig(final String endPath, final String endUri) {
		EndPointSpecifications.restConfigurations = new EndPointSpecifications(endPath, endUri);
	}
	
	public static EndPointSpecifications getRestConfig() {
		return EndPointSpecifications.restConfigurations;
	}

	public String getEndUri() {
		return this.endUri;
	}

	public void setEndUri(String endUri) {
		this.endUri = endUri;
	}

	public String getEndPath() {
		return this.endPath;
	}

	public void setEndPath(String endPath) {
		this.endPath = endPath;
	}

}
