package com.vcube;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "SELECT full_name, contact, dob, address FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("full_name");
                String contact = rs.getString("contact");
                String dob = rs.getString("dob");
                String address = rs.getString("address");

                EmailSender.sendEmail(email, "Login Successful", 
                    "Hello " + name + ",\nYou have successfully logged in.\nEmail: " + email + 
                    "\nContact: " + contact + "\nDOB: " + dob + "\nAddress: " + address);
                
                HttpSession session = request.getSession();
                session.setAttribute("user", name);
                response.sendRedirect("https://www.vcubesoftsolutions.com/");
            } else {
                EmailSender.sendEmail(email, "Login Failed", 
                    "Login attempt failed for email: " + email + ".\nPlease check your credentials.or please create create account");
                response.sendRedirect("Loginfail.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}


