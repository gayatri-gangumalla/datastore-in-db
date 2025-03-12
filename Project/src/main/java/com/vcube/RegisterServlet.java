package com.vcube;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
		   String fname = request.getParameter("fname");
		 
		   String lname = request.getParameter("lname");
		   
		   System.out.print(request.getParameter("fname"));
	        String id = request.getParameter("no");
	       
	        
	        String password = request.getParameter("password");

	        RegisterModel k=new RegisterModel();
	       

			k.setFname(fname);
			k.setLname(lname);
			k.setId(id);
			k.setPassword(password);
			
	        // Store data using DAO class
	        RegisterDao s= new RegisterDao();
	        
	     
			String status="false";
			try {
				status = s.insertUser(k);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	       	System.out.print(status);
	        if(status=="true")
			{
				RequestDispatcher re=request.getRequestDispatcher("/login.jsp");
				re.include(request,response);
		}
			else {
				System.out.println("NewFile.jsp");
			}


	}

}
