package com.floriancourgey.java.cours1.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.floriancourgey.java.cours1.dao.CompanyDao;
import com.floriancourgey.java.cours1.dao.ComputerDao;
import com.floriancourgey.java.cours1.models.Company;
import com.floriancourgey.java.cours1.models.Computer;


@WebServlet("/computers/add")
public class ComputerAddServlet extends HttpServlet {
	
	private static CompanyDao companyDao = new CompanyDao();
	private static ComputerDao computerDao = new ComputerDao();
	private static SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		ArrayList<Company> companies = companyDao.getAll();
		request.setAttribute("companies", companies);
		request.getRequestDispatcher("/computersAdd.jsp" ).forward(request, response);
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		Computer computer = new Computer();
		// check parameters
		/// name
		String name = request.getParameter("name");
		/// introduced
		Date introduced = null;
		String introducedParam = request.getParameter("introduced");
		if(introducedParam != null && introducedParam.length() > 0){
			try {
				introduced = format.parse(introducedParam);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}
		}
		/// discontinued
		Date discontinued = null;
		String discontinuedParam = request.getParameter("discontinued");
		if(discontinuedParam != null && introducedParam.length() > 0){
			try {
				discontinued = format.parse(discontinuedParam);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}
		}
		/// company
		Company company = null;
		String companyParam = request.getParameter("company");
		if(companyParam != null && companyParam.length() > 0){
			long companyId = 0;
			try{
				companyId = Integer.parseInt(companyParam);
			}
			catch(NumberFormatException nfe){}
			if(companyId > 0){
				company = companyDao.get(companyId);			
			}
		}
		computer.setCompany(company);
		// set parameters
		computer.setName(name);
		computer.setIntroduced(introduced);
		computer.setDiscontinued(discontinued);
		// save
		computerDao.save(computer);
		// redirect
		response.sendRedirect("/projet-java/computers?c="+computer.getId());
	}
}
