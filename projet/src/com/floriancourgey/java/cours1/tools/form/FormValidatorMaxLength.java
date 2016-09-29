package com.floriancourgey.java.cours1.tools.form;

public class FormValidatorMaxLength extends FormValidator {
	
	private int maxLength;
	
	public FormValidatorMaxLength(int minLength) {
		this.maxLength = minLength;
	}
	
	public void handle(String value) {
		if(value == null || value.length() > maxLength)
			error = "Il faut au maximum "+maxLength+" caractères pour ce champ"; 
	}
}
