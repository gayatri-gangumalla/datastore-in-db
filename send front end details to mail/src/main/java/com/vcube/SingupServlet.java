package com.vcube;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class SingupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SingupServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(full_name, email, contact, dob, address, password) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, contact);
            ps.setString(4, dob);
            ps.setString(5, address);
            ps.setString(6, password);
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                EmailSender.sendEmail(email, "Signup Successful", 
                    "Welcome " + name + "! Your signup details:\nEmail: " + email + "\nContact: " + contact + "\nDOB: " + dob + "\nAddress: " + address+"\nTime of Submission: " + formattedDateTime + "\n\n");
                response.sendRedirect("login.html");
            } else {
                response.sendRedirect("index.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	}


