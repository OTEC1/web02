package logic;


import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Payment_zone.Withdrawal_page;

@SessionScoped
@ManagedBean
public class Req {

	
	
	public  String onload() {;
			if(new Nav().Session().getAttribute("status1")==null)
				new Nav().Session().setAttribute("status1","Sign in");
				
					
     return null;
}
	
	
	
	




	public String home() {
		return  "/index.xhtml?faces-redirect=true";}
		
}
