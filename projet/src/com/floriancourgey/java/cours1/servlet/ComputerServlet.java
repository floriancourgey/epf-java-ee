package com.floriancourgey.java.cours1.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.floriancourgey.java.cours1.dao.ComputerDao;
import com.floriancourgey.java.cours1.models.Computer;


@WebServlet("/computers")
public class ComputerServlet extends HttpServlet {
	
	private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String google = request.getParameter("google");
		// computers list (getAll or getByGoogle)
		ComputerDao computerDao = new ComputerDao();
		ArrayList<Computer> computers = new ArrayList<>();
		if(google != null && google.length()>0){
			computers = computerDao.getByGoogle(google);
		} else {
			computers = computerDao.getAll();
		}
		request.setAttribute("google", google);			
		request.setAttribute("computers", computers);
		request.setAttribute("format", format);
		// eventually added computer
		String computerAddedParam = request.getParameter("c");
		if(computerAddedParam != null && computerAddedParam.length() > 0){
			long computerAddedId = 0;
			try{
				computerAddedId = Integer.parseInt(computerAddedParam);
			}
			catch(NumberFormatException nfe){}
			if(computerAddedId > 0){
				Computer computerAdded = null;
				for(Computer c : computers){
					if(c.getId() == computerAddedId){
						computerAdded = c;
						break;
					}
				}
				request.setAttribute("computerAdded", computerAdded);
			}
		}
		// send
		request.getRequestDispatcher("/computers.jsp" ).forward(request, response);
    }
}
