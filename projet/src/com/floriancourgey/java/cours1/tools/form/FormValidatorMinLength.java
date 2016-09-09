package com.floriancourgey.java.cours1.tools.form;

public class FormValidatorMinLength extends FormValidator {
	
	private int minLength;
	
	public FormValidatorMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	public void handle(String value) {
		if(value == null || value.length() < minLength)
			error = value+" doit contenir au moins "+minLength+" caractères"; 
	}
}
