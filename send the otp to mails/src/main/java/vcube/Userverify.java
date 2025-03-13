package vcube;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.mail.Session;

/**
 * Servlet implementation class Userverify
 */
@WebServlet("/Userverify")
public class Userverify extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Userverify() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void
    processRequest(HttpServletRequest request,
                   HttpServletResponse response)
        throws ServletException, IOException
    {
    	response.setContentType("text/html");
    	String name=request.getParameter("username");
    	String email=request.getParameter("useremail");
    	
    	SendEmail sm=new SendEmail();
    	String code=sm.getRandom();
    	
    	User user=new User(name,email,code);
    	
    	boolean test=sm.sendEmail(user);
    	if(test) {
    		HttpSession session=request.getSession();
    		session.setAttribute("authcode",user);
    		
    		response.sendRedirect("verify.jsp");
    		
    	}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
		
	}

}
