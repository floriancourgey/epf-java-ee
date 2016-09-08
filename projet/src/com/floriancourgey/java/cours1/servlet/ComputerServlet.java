package com.floriancourgey.java.cours1.servlet;

import java.io.IOException;
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
	public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		String google = request.getParameter("google");
		// computers list
		ComputerDao computerDao = new ComputerDao();
		ArrayList<Computer> computers = computerDao.getComputers();
		request.setAttribute("computers", computers);
		// eventually added computer
		String computerAddedParam = request.getParameter("c");
		if(computerAddedParam != null){
			long computerAddedId = 0;
			try{
				computerAddedId = Integer.parseInt(computerAddedParam);
			} catch (NumberFormatException nfe){}
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
		request.getRequestDispatcher("/dashboard.jsp" ).forward(request, response);
    }
}