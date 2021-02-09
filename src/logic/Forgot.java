package logic;

import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Serve.Auth02;
import Serve.UserServer_Request;



/**
 * Servlet implementation class Forgot
 */
@WebServlet("/pass_reset")
public class Forgot extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
    String string,url;
    
    public Forgot() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	string=request.getParameter("email");
	
		
	if(string.isEmpty()) {
		request.setAttribute("error", "Pls fill out the email field");
		url="forgot.jsp";
	}
	else
	if(!val(string)) {
		request.setAttribute("invalid", string);
		request.setAttribute("error", "Pls enter a valid Email ! ");
		
		url="Forgot.jsp";
				
	}else {			
		new UserServer_Request().send_forget_user_mail(string.toLowerCase(), (String)encrpty());
		Group_check(request, 
				"Go to Home Page",
				"An SMS reset link would be Sent to the number associated with the email Provided",
				"index.xhtml");
		url="confirm.jsp";
	}
		request.getRequestDispatcher(url).forward(request,response);
		
	}


	private void Group_check(HttpServletRequest request, String string1, String string2, String string3) {
		request.setAttribute("navs", string1);
		request.setAttribute("status", string2);
		request.setAttribute("join", string3);
		
	}

	
	public boolean  val(String x) {
		boolean  bool;
		Pattern  pattern=Pattern.compile(".+@.+\\.[a-z]+");
		Matcher  matcher=pattern.matcher(x);
		if(matcher.matches()) 
			bool=  true;
		else
			bool=  false;
	
		return bool;
	}

	
	
	private Object encrpty() {
		
		return "https://lemtracointernationallimited.com/field.jsp?p=".concat(new Auth02()
				.encryt(String.valueOf(UUID.randomUUID())))
				.concat(String.valueOf(System.currentTimeMillis()))
				.concat(String.valueOf(System.nanoTime()))
				.concat(String.valueOf(UUID.randomUUID()));
	}

}
