package com.adnan.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.text.normalizer.CharTrie.FriendAgent;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection variables
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String user = "studentAdmin" ;
		String password = "2211" ;
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			out.println("Conecting to database: " + jdbcURL);
			Class.forName(driver);
			Connection myConnection = DriverManager.getConnection(jdbcURL,user,password);
			out.println("Connection successful...");
			myConnection.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			
		}
		
	}

}
