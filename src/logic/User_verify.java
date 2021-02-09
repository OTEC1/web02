package logic;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.node.BooleanNode;

import Serve.UserServer_Request;

/**
 * Servlet implementation class User_verify
 */
@WebServlet("/auth_user")
public class User_verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public User_verify() {
        super();
    }

	String url,email,password; int t;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=request.getParameter("email");
		password=request.getParameter("pass");
		
		if(email.trim().isEmpty() | password.trim().isEmpty()) {
			request.setAttribute("er", "Pls Fill out all Fields !");
			url="Sign_in.jsp";
		}else {
		      t=sign_up(request, email, password);
		
		if(t==1) {
	 	   url="index.xhtml";
		}
		else
			if( t==3){
			request.setAttribute("er", "Password Does'nt Match ! ");
			url="Sign_in.jsp";
		}
		 else{
				request.setAttribute("er", "Account Does'nt Exists");
				url="Sign_in.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	
		
	}
	

	public int  sign_up(HttpServletRequest request, String email2, String password2) {
	int cv=new UserServer_Request().authenticate_User(request,email.toLowerCase(),password);	
	 return cv;
    }
				
		

}
