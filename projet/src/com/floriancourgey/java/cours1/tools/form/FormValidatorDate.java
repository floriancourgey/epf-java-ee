package com.floriancourgey.java.cours1.tools.form;

import java.text.SimpleDateFormat;

public class FormValidatorDate extends FormValidator {
	
	private String format;
	
	public FormValidatorDate(String format){
		this.format = format;
	}
	
	public void handle(String value) {
		try {
			new SimpleDateFormat(format).parse(value);
		} catch (Exception ex) {
			error = "La date "+value+" ne correspond pas avec le format "+format;
		}
	}
}
