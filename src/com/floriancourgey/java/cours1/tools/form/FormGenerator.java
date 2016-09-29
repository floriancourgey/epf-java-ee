package com.floriancourgey.java.cours1.tools.form;

import javax.servlet.http.HttpServletRequest;

public class FormGenerator {
	private FormWidget[] widgets;
	
	public FormGenerator(FormWidget[] widgets){
		this.widgets = widgets;
	}
	
	public void handle(HttpServletRequest request){
		for(FormWidget widget : widgets){
			widget.setValue(request.getParameter(widget.getName()));
			widget.handle();
		}
	}
	
	public boolean isValid(){
		for(FormWidget widget : widgets){
			if(!widget.isValid()){
				return false;
			}
		}
		return true;
	}
	
	public FormWidget[] getWidgets(){
		return widgets;
	}
}
