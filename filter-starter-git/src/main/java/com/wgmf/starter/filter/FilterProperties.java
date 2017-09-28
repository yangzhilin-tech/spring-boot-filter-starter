package com.wgmf.starter.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("server")
public class FilterProperties {
	private String context;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}
