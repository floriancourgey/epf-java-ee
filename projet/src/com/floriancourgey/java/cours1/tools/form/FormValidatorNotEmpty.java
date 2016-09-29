package com.floriancourgey.java.cours1.tools.form;

public class FormValidatorNotEmpty extends FormValidator {
	
	public void handle(String value) {
		if(value == null || value.length() < 1)
			error = "Ce champ ne peut être vide"; 
	}
}
