package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		
		//get connection to database
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to database:" + jdbcUrl);
			
			Class.forName(driver);
			
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.print("SUCCESSFULL");
			
			connection.close();
			
						
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
	}

}
