package com.prasant.spring.mvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.prasant.spring.mvc.validator.ValidEmail;

public class Offer {
	
	private int id;
	
	//@Size(min=1, max=50)
	@Pattern(regexp="[a-zA-Z ]+", message="Name must be alphabets only")
	private String name;
	
	//@NotBlank
	//@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message="Invalid email format")
	@ValidEmail
	private String email;
	
	@Size(min=10, max=200, message="Text must be between 10 and 200 characters")
	private String text;
	
	public Offer() {
		
	}
	
	public Offer(String name, String email, String text) {
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public Offer(int id, String name, String email, String text) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}

}
