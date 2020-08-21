package com.readup.db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class MorningReadup
 */
@WebServlet("/MorningReadup")
public class MorningReadup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/morning_readup?useSSL=false";
		String user="root";
		String pw = "root3232";
		String driver = "com.mysql.jdbc.Driver";
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to DB " + url);
			Class.forName(driver);
			Connection myconnection = DriverManager.getConnection(url,user,pw);
			
			out.println("Connection successful");
			myconnection.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
