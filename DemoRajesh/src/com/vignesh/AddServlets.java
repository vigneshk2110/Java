package com.vignesh;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddServlets extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		int num = Integer.parseInt(req.getParameter("num1"));
		int num1 = Integer.parseInt(req.getParameter("num2"));

		int k = num1 + num;
		k = k*k;

		RequestDispatcher rd = req.getRequestDispatcher("sq");

		rd.forward(req, res);
		
		
//		PrintWriter out = res.getWriter();
//		
//		out.println("Class 1");

	}
}


