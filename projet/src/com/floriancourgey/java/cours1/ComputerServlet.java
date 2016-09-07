package com.floriancourgey.java.cours1;

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
		ComputerDao computerDao = new ComputerDao();
		ArrayList<Computer> computers = computerDao.getComputers();
		request.setAttribute("computers", computers);
		request.getRequestDispatcher("/dashboard.jsp" ).forward(request, response);
    }
}
