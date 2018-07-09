package com.javacodegeeks.examples.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Attribute {
	 
	private String type;
	private String url;
	 
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	 
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Attribute(String type, String url) {
		super();
		this.type = type;
		this.url = url;
	}

	public Attribute() {
		super();
	}
}