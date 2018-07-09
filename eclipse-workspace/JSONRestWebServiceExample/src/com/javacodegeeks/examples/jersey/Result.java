package com.javacodegeeks.examples.jersey;

import javax.xml.bind.annotation.XmlRootElement;

import com.javacodegeeks.examples.jersey.Attribute;

@XmlRootElement
public class Result {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Attribute attribute;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Result(String id, String firstName, String lastName, String phone, String email, String type, String url,
			boolean encryption) {

		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.attribute = new Attribute(type, url);

	} 

	public Result() {
		super();
	}
}