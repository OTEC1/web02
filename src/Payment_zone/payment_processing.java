package Payment_zone;

public class payment_processing {

	
	
	
	public String sql1(String c, int x) {
		String p=null;
		if(x==1)
			p="Lemtraco_temporary_package";
		else
			p="Preview_table";
		
		return "select * from "+p+"  where userid = '"+c+"' limit 1";
	}
}


