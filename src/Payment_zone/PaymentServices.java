package Payment_zone;

import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import lemtraco02.Creden;




public class PaymentServices {

	
	

	
	
	public   String  authorizePayment(OrderDetails  orderDetail) throws PayPalRESTException {
	
        Payer  payer =	PayerInfoSub();
        RedirectUrls  redirectUrls  =     redirectUrling();
        List<Transaction>   lisTransactions  = getTransactionInfomation(orderDetail);
        
        Payment  rePayment = new   Payment();
        rePayment.setTransactions(lisTransactions)
        					.setRedirectUrls(redirectUrls)
        					.setPayer(payer)
        					.setIntent("authorize");
        					
        APIContext  apicontext = new APIContext(Creden.CLIENT_ID, Creden.SECRET_ID, Creden.mode);
        Payment  apPayment =rePayment.create(apicontext);
        
      //  System.out.println(apPayment);
        
     return getApprovalLink(apPayment);
		
	}
	
	
	
	private  String  getApprovalLink(Payment  approvalPaymant) {
		
		List<Links>  links = approvalPaymant.getLinks();
		String approval= null;
		for(Links  link : links) {
			if(link.getRel().equalsIgnoreCase("approval_url")) {
				approval= link.getHref();
			}
		}
		
		
		return  approval;
	}
	

	
	private  List<Transaction>    getTransactionInfomation(OrderDetails  orderdetail){
	
		Details   details  =  new Details();
		details.setShipping(orderdetail.getShipping());
		details.setSubtotal(orderdetail.getSubtotal());
		details.setTax(orderdetail.getTax());
		
		Amount  amount  = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(orderdetail.getTotal());
		amount.setDetails(details);
		
		
		Transaction    transaction  =  new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(orderdetail.getProductName());
		
		ItemList  itemList  = new ItemList();
		List<Item>   items =new ArrayList<Item>();
		
		Item item =new  Item();
		 item.setCurrency("USD")
		 			.setName(orderdetail.getProductName())
		 			.setPrice(orderdetail.getSubtotal())
		 			.setTax(orderdetail.getTax())
		 			.setQuantity("1");
		 
		 
		 items.add(item);
		 itemList.setItems(items);
		 transaction.setItemList(itemList);
		 
		 
		 List<Transaction>   itemTransaction =new ArrayList<Transaction>();
		 itemTransaction.add(transaction);
		 
		return itemTransaction;
		
	}



	private RedirectUrls  redirectUrling() {
		RedirectUrls  rediectUrls = new RedirectUrls();
	
		    rediectUrls.setCancelUrl("https://lemtracointernationallimited.com/cancel.html");
		    rediectUrls.setReturnUrl("https://lemtracointernationallimited.com/review_payment");
	
		 // rediectUrls.setCancelUrl("http://localhost:8085/Web02/cancel.html");
		 //rediectUrls.setReturnUrl("http://localhost:8085/Web02/review_payment");
        return  rediectUrls;
	}



	
	public Payment getPaymentDetails( String payments) throws PayPalRESTException {
		APIContext  apiContext = new APIContext(Creden.CLIENT_ID, Creden.SECRET_ID, Creden.mode);
		return  Payment.get(apiContext, payments);	
	}

	
	
	
	public  Payment   executePayment(String  Id, String payerId) throws PayPalRESTException {
	 PaymentExecution paynmentsExecution = new PaymentExecution();
	 paynmentsExecution.setPayerId(payerId);
	 
	 Payment  payment =new Payment().setId(Id);
	 APIContext  apiContext= new APIContext(Creden.CLIENT_ID,  Creden.SECRET_ID, Creden.mode);
	  return  payment.execute(apiContext, paynmentsExecution);
	}
	
	
	
	
	
	private Payer PayerInfoSub() {
		Payer  payer =new Payer();
		payer.setPaymentMethod("paypal");
		PayerInfo   payerInfo  = new PayerInfo();
//		payerInfo.setFirstName("Dev");	
//		payerInfo.setLastName("Production");	
//	payerInfo.setEmail("testing@gmail.com");
	payer.setPayerInfo(payerInfo);
		
     return  payer;	}
}
