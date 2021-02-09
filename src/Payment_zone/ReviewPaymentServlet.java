package Payment_zone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import Serve.UserServer_Request;
import lemtraco02.DbCon;
import logic.Nav;


/**
 * Servlet implementation class ReviewPaymentServlet
 */
@WebServlet("/review_payment")
public class ReviewPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String v1 =null;
    public ReviewPaymentServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String paymentid = request.getParameter("paymentId");
		String payer = request.getParameter("PayerID");
		
	
		System.out.println(paymentid + "      "+   payer );
		 try {
		PaymentServices   paymentServices =new PaymentServices();
		Payment  payment2 = paymentServices.getPaymentDetails(paymentid);
		
		PayerInfo  payerInfo = payment2.getPayer().getPayerInfo();
		Transaction  transaction =payment2.getTransactions().get(0);
		 ShippingAddress  shippingAddress =transaction.getItemList().getShippingAddress();
		 
		 request.setAttribute("payer",  payerInfo);
		 request.setAttribute("transaction",  transaction);
		 request.setAttribute("shippingAddress",  shippingAddress);

	
		 
			
			 
			String url ="review.jsp?paymentId = "+paymentid + "&PayerID = "+ payer;
			request.getRequestDispatcher(url).forward(request, response);
	
			
			 HttpSession  session=request.getSession();
		      v1= (String) session.getAttribute("opw");
			    	  after(v1, paymentid, payer);
			  
			
			
			
			 
				 
	} catch (PayPalRESTException e) {
	System.out.println(e);
	request.setAttribute("ErrorMessage",  "Could not get Payment Details ");
	request.getRequestDispatcher("Error.jsp").forward(request,  response);
	}
		 
		
	}


	private int return_session_id_form_managed_bean(String x) {
		
	     String xi=String.valueOf(x);	
		 int e= new UserServer_Request().type(xi);
		 System.out.println(" SessionID = "+xi);
		return e;
	}
	
	
	private void after(String v12, String paymentid1, String payer1) {
		 int y=	return_session_id_form_managed_bean(v1);
		 String loggin=new UserServer_Request().quick_check(v1);
		 
		 if(y==2) 
				 notification("Invest",paymentid1,payer1,loggin);
		       else 
				  notification("Goods Purchase",paymentid1,payer1,loggin);
		 
		 
		 System.out.println("Review  type ="+y);
		
	}


	
	
	
	
	public void notification(String type, String name_session, String content, String ed) {
		Connection  con=null;
		try {
			con= new DbCon().getConnection();
				PreparedStatement  ps=con.prepareStatement("insert into Lemtraco_notification(status,user1,content,count,now,user_email,Trans_id,time_zone) values(?,?,?,?,?,?,?,?)");
				ps.setString(1, type);
				ps.setString(2, name_session);
				ps.setString(3, content);
				ps.setInt(4, 1);
				ps.setString(5,"New");
				ps.setString(6, ed);
				ps.setString(7, v1);
				ps.setString(8, new UserServer_Request().time_save());
				ps.execute();
		}catch (Exception e) {
		System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
	}	

}
