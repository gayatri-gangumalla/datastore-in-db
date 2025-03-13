package com.vcube;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("id"));
		String stdid=request.getParameter("id");
		
		String password=request.getParameter("pwd");
		LoginModel lm=new LoginModel();
		lm.setStdid(stdid);
		lm.setPassword(password);
		System.out.println(password);
		LoginDao rd=new LoginDao();
		String status="failure";
		try {
			status = rd.selectStudent(lm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("status");
		System.out.println(status);
		if(status=="True")
		{
			request.setAttribute("stdid", stdid);
			RequestDispatcher re=request.getRequestDispatcher("/welcome1.jsp");
			
			re.include(request,response);
	}
		else {
			RequestDispatcher re=request.getRequestDispatcher("NewFile.jsp");
			re.include(request,response);
			
		}

	}

}
