package logic;

import java.io.IOException;
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
@WebServlet("/reset")
public class Forgot2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   String string,string1,url,keys;
    public Forgot2() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	string=request.getParameter("pass1");
	string1=request.getParameter("pass2");
	keys=request.getParameter("in");

		
	if(string.equals(string1)) {
		
		if(new UserServer_Request().find(keys).trim().length()<=0) {
		url="confirm.jsp";
		
	    Group_check(request, "Go to Home Page",
	    		"Link Has Expired ! ", 
	    		"index.xhtml");
	    url="confirm.jsp";
		}
		else {
		new UserServer_Request()
		    .update_user(new Auth02()
		    .encryt(string1), new UserServer_Request().find(keys),keys);
			    Group_check(request, "Sign in", "Password Reset Successfully", "Sign_in.jsp");
			    url="confirm.jsp";	
		}
	}
	else {
		request.setAttribute("error", "Password not Match !");
		url="field.jsp";
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
	

}
