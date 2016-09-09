package com.floriancourgey.java.cours1.tools.form;

import java.util.ArrayList;
import java.util.HashMap;

public class FormWidget {
	public enum Type {
		INPUT,
		TEXTAREA,
		SELECT
	}
	
	/**
	 * Widget's name (POST parameter)
	 */
	private String name;
	
	/**
	 * Widget's value
	 */
	private String value;
	
	/**
	 * Name to display in <label></label>
	 */
	private String label;
	
	/**
	 * Type (input, textarea, select)
	 */
	private Type type;
	
	/**
	 * Rules/validators
	 */
	private ArrayList<FormValidator> validators;
	
	/**
	 * Attributes to add, ex for an input : <input attr1="val1" attr2="val2".../>
	 */
	private HashMap<String, String> attributes = new HashMap<String, String>();
	
	public FormWidget(String name){
		this.name = name;
	}
	
	public void handle(){
		for(FormValidator validator : validators){
			validator.handle(this.value);
		}
	}
	
	public boolean isValid(){
		for(FormValidator validator : validators){
			if(!validator.isValid()){
				return false;
			}
		}
		return true;
	}

	public String getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}

	public FormWidget setValue(String value) {
		this.value = value;
		return this;
	}

	public String getLabel() {
		return label;
	}

	public FormWidget setLabel(String label) {
		this.label = label;
		return this;
	}

	public Type getType() {
		return type;
	}

	public FormWidget setType(Type type) {
		this.type = type;
		return this;
	}

	public ArrayList<FormValidator> getValidators() {
		return validators;
	}

	public FormWidget setValidators(ArrayList<FormValidator> validators) {
		this.validators = validators;
		return this;
	}

	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public FormWidget setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
		return this;
	}

}
