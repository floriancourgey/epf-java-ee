package com.floriancourgey.java.cours1.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.floriancourgey.java.cours1.dao.CompanyDao;
import com.floriancourgey.java.cours1.dao.ComputerDao;
import com.floriancourgey.java.cours1.models.Company;
import com.floriancourgey.java.cours1.models.Computer;
import com.floriancourgey.java.cours1.tools.form.FormGenerator;
import com.floriancourgey.java.cours1.tools.form.FormValidator;
import com.floriancourgey.java.cours1.tools.form.FormValidatorDate;
import com.floriancourgey.java.cours1.tools.form.FormValidatorMinLength;
import com.floriancourgey.java.cours1.tools.form.FormWidget;


@WebServlet("/computers/add")
public class ComputerAddServlet extends HttpServlet {
	
	private static CompanyDao companyDao = new CompanyDao();
	private static ComputerDao computerDao = new ComputerDao();
	private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	private static FormGenerator form;
	
	private void createForm(){
		// create form
		/// NAME
		ArrayList<FormValidator> nameValidators = new ArrayList<FormValidator>();
		nameValidators.add(new FormValidatorMinLength(6));
		HashMap<String, String> nameAttributes = new HashMap<String, String>();
		nameAttributes.put("placeholder", "Enter computer's name");
		nameAttributes.put("required", "required");
		FormWidget nameWidget = new FormWidget("name")
			.setLabel("Name")
			.setType(FormWidget.Type.INPUT)
			.setValidators(nameValidators)
			.setAttributes(nameAttributes)
		;
		/// INTRODUCED
		ArrayList<FormValidator> introducedValidators = new ArrayList<FormValidator>();
		introducedValidators.add(new FormValidatorMinLength(9));
		introducedValidators.add(new FormValidatorDate(format));
		HashMap<String, String> introducedAttributes = new HashMap<String, String>();
		introducedAttributes.put("placeholder", "Enter computer's introduced date");
		introducedAttributes.put("required", "required");
		FormWidget introducedWidget = new FormWidget("introduced")
			.setLabel("Introduced date")
			.setType(FormWidget.Type.INPUT)
			.setValidators(introducedValidators)
			.setAttributes(introducedAttributes)
		;
		/// DISCONTINUED
		ArrayList<FormValidator> discontinuedValidators = new ArrayList<FormValidator>();
		discontinuedValidators.add(new FormValidatorMinLength(9));
		discontinuedValidators.add(new FormValidatorDate(format));
		HashMap<String, String> discontinuedAttributes = new HashMap<String, String>();
		discontinuedAttributes.put("placeholder", "Enter computer's discontinued date");
		discontinuedAttributes.put("required", "required");
		FormWidget discontinuedWidget = new FormWidget("discontinued")
			.setLabel("Discontinued date")
			.setType(FormWidget.Type.INPUT)
			.setValidators(discontinuedValidators)
			.setAttributes(discontinuedAttributes)
		;
		/// final form
		form = new FormGenerator(new FormWidget[]{
			nameWidget,
			introducedWidget,
			discontinuedWidget
		});
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		// get companies
		ArrayList<Company> companies = companyDao.getAll();
		request.setAttribute("companies", companies);
		createForm();
		request.setAttribute("form", form);
		request.getRequestDispatcher("/computersAdd.jsp" ).forward(request, response);
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		createForm();
		form.handle(request);
		// IS VALID
		if(form.isValid()){
			// do the hibernate things
			Computer computer = new Computer();
			// set parameters (they're safe as their validators are valid)
			computer.setName(request.getParameter("name"));
			try {
				computer.setIntroduced(format.parse(request.getParameter("introduced")));
				computer.setDiscontinued(format.parse(request.getParameter("discontinued")));
			} catch(Exception e){
				e.printStackTrace(); // should never hppn (TODO gérer ça)
				return;
			}
			// save
			computerDao.save(computer);
			// redirect
			response.sendRedirect("/projet-java/computers?c="+computer.getId());
		}
		// NOT VALID
		else {
			// display computerAdd.jsp with errors
			ArrayList<Company> companies = companyDao.getAll();
			request.setAttribute("companies", companies);
			request.setAttribute("form", form);
			request.getRequestDispatcher("/computersAdd.jsp" ).forward(request, response);
		}
	}
}
