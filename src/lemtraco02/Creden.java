package lemtraco02;

public interface Creden {

	
	
	static String CLIENT_ID="AU2DJhK1TcFirrRut9Ha3VPyt8VXL4_Kz5ATvrDHujJekFGVJzbJ5qAQsOlDIBQdrV46D0abmVRmD3vf",
	 SECRET_ID="ELVORhBV8PcDnyfnx1oa6DeesZEvKgn6Girt_7jypI5AL-1CYaRRfjc8o_DjQ8N9WY0nwagawiYUGJeA",
	 mode="sandbox";
	
	
	
	//Development
	 /* static String USER="root", 
			Pass="7h8g2cc",    
				URL="jdbc:mariadb://localhost/lemtrac01", 
				 ACCESS_KEY_ID="AKIAYDAUUBKQRT342HUM", 
				 ACCESS_SEC_KEY="pg10NPo1fUuD+1hc5tg/1bmdobl1v7nSXARAjPkd",   
				bucket="lemtracobucket",
				driver="org.mariadb.jdbc.Driver";
	  */
	  
	  
	  
	 //Production
		
	  static String	USER="walexfab_lemtraco_user", 
	    Pass="7h8g2ww",
	    URL="jdbc:mariadb://localhost/walexfab_lemtraco_user01",
	   	ACCESS_KEY_ID="AKIAYDAUUBKQRT342HUM", 
	    ACCESS_SEC_KEY="pg10NPo1fUuD+1hc5tg/1bmdobl1v7nSXARAjPkd",   
	    bucket="lemtracobucket",
	  driver="org.mariadb.jdbc.Driver";

	  
}
