package vcube;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Verifycode
 */
@WebServlet("/Verifycode")
public class Verifycode extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    protected void  processRequest(HttpServletRequest request,
                   HttpServletResponse response)
        throws ServletException, IOException
    {
    	
    	response.setContentType("text/html;charset-UTF-8");
    	try(PrintWriter out=response.getWriter())
    	{
    		HttpSession session=request.getSession();
    		
    		User user=(User) session.getAttribute("authcode");
    		String code=request.getParameter("authcode");
    		if(code.equals(user.getCode())) {
    			out.println("sucessfully done verification code");
    				
    		}
    		else{
    			out.println("incorrect verification code,plz check");
    		}
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	public Verifycode() {
        super();
        // TODO Auto-generated constructor stub
    }


}
