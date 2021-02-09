package logic;


import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import Serve.UserServer_Request;




@ManagedBean
@SessionScoped
public class Nav   {

	
	  
	 private	UserServer_Request  request =new UserServer_Request();
	 int px=1,number,price1=2000,price2=1000;
	 String price3="200",price4="1000",bio_write_up,bio_write_up1,bio_write_up2,bio_write_up3,bio_name,col;
	 
	 
		public Nav() {
			
	    	
         
		}
		

		public String getBio_write_up3() {
			return bio_write_up3;
		}


		public void setBio_write_up3(String bio_write_up3) {
			this.bio_write_up3 = bio_write_up3;
		}


		public String getBio_write_up1() {
			return bio_write_up1;
		}


		public void setBio_write_up1(String bio_write_up1) {
			this.bio_write_up1 = bio_write_up1;
		}


		public String getBio_write_up2() {
			return bio_write_up2;
		}


		public void setBio_write_up2(String bio_write_up2) {
			this.bio_write_up2 = bio_write_up2;
		}


		public String getCol() {
			return col;
		}

		public void setCol(String col) {
			this.col = col;
		}

		public String getBio_name() {
			return bio_name;
		}


		public void setBio_name(String bio_name) {
			this.bio_name = bio_name;
		}


		public String getBio_write_up() {
			return bio_write_up;
		}


		public void setBio_write_up(String bio_write_up) {
			this.bio_write_up = bio_write_up;
		}


		public String getPrice4() {
			return price4;
		}




		public void setPrice4(String price4) {
			this.price4 = price4;
		}




		public String getPrice3() {
			return price3;
		}

		public void setPrice3(String price3) {
			this.price3 = price3;
		}




		public int getPrice1() {
			return price1;
		}

		public void setPrice1(int price1) {
			this.price1 = price1;
		}




		public int getPrice2() {
			return price2;
		}




		public void setPrice2(int price2) {
			this.price2 = price2;
		}


		public int getNumber() {
			return number;
		}




		public void setNumber(int number) {
			this.number = number;
		}




		public String nv1() {  return  "/business_model.xhtml?faces-redirect=true";}
	
		public String nv2() { 	   return  "/board.xhtml?faces-redirect=true";}
		
		public String nv3() { 	 return  "/Contact.xhtml?faces-redirect=true";}
		
	     public String nv4() { /**new UserServer_Request().notification("Withdrawal Order", "aa", "aa", "tobeokoko18@gmail.com"); **/	   return  "/Investment.xhtml?faces-redirect=true";	}
			
	     public String nv6() {  String e=GETID();  request.payment_type("Orders",e);	  return  "/Ship.xhtml"; }
	      
	     public String nv7() { new Sub_total_caculate().sums(); return  "/Cart.xhtml?faces-redirect=true";	}
	     
	     public String nv5() {return  "/Register.xhtml?faces-redirect=true";}

	     public String nv8() { return  "/Sign_in.xhtml?faces-redirect=true";}
	     
	     
	     int h;
	         public String nv10() { 
	        	 
	        	 String e=GETID();
	        	 FacesContext  context=FacesContext.getCurrentInstance();
		    	 String c=(context.getExternalContext().getRequestParameterMap().get("f1"));
		    	 System.out.println(c);
		    	 
		    	 switch (c) {
				case "1000":
					 request.add_in(price4,e);  
					 Session_tabs();
					 return  "/Cash_deposit2.jsp";

				case "200":
					  request.add_in(price3,e);
					  Session_tabs();
					  return  "/Cash_deposit2.jsp";
				}
  		    	
	    	 return  null; 
	    	 }
	     
	       public String nv11a() { 
		    	  String e=GETID();
		 		 request.add_in("0",e);   
		 		 Session_tabs();
		 		 return  "/Cash_deposit2.jsp";
		    
	  	}
	         
	         
    
 
	     
	     
	     public String nav_invest() {
	    	
	    	 String ed="";
	    
	    		 
		
	   ed=(String)Session().getAttribute("User1");
			
	   
				
				
		if(new Nav().Session().getAttribute("User1")==null)
			new UserLogin_Register().message("Pls Sign in");
		else  {
	    	 FacesContext  context=FacesContext.getCurrentInstance();
	    	 int c=Integer.valueOf(context.getExternalContext().getRequestParameterMap().get("package"));
	    	 
	    	 switch(c) {
	    	 case 1:
	    		 		request.add_user_investment_selection(price1, GETID() ,ed,"Paypal");
//	    		 		System.out.println(GETID());
	    		 		 Session_tabs();
	    		 		 return  "/cash_deposit.jsp";
	    		 
	    	case 2:
	    	     	request.add_user_investment_selection(price2,GETID() ,ed,"Paypal");
//	    	     		System.out.println(GETID());
	    	     	 Session_tabs();
	    	     	 return  "/cash_deposit.jsp";
	    	 
	       case 3: 
	    	   if(number==0)
					 message("You have not made any Selection");
	    	   else {
	    	   request.add_user_investment_selection(number,GETID() ,ed,"Paypal");
//	    		System.out.println(GETID());
	    	   Session_tabs();
	    	   }
  	     	 return  "/cash_deposit.jsp";
	    	 }	 
		}
				 
	    	 return  null;	
	     }
	     

	        
	     public String nv9() {
	    	 FacesContext  context=FacesContext.getCurrentInstance();
	    	 String c=(context.getExternalContext().getRequestParameterMap().get("pat"));
	    	 	if(c.equals("Sign in"))
	    	 		return  "/Sign_in.jsp";
					else {
						teste();
	    	 	      return  "/index.xhtml?faces-redirect=true";
					}
		}
	     
	     
	     
	     
	 	public String inner_jobs() {
			message("A notification has be Sent too yr email");
			 
	  return "/Sign_in.xhtml?face-redirect=true";	}
	
	 	
	 	
	 
	 	public String bio_select() {
			
	 		FacesContext context=FacesContext.getCurrentInstance();
	 		int x=Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("ty"));
	 		switch (x) {
			case 1:
				setCol("p1.jpg");
				setBio_name("Brief Biography of Chief Charles Ekemezie Okoko  (Chairman)");
				setBio_write_up(" Chief Charles Ekemezie Okoko , an international business mogul is the Executive Chairman at LEMTRACO INTERNATIONAL LIMITED "
						+ "where he works to create an enabling environment for all Nigerians to thrive especially the poor masses  by building Strategic Business Relationships"
						+ " and Partnerships with strong Technology and Products Development Expertise.");

						setBio_write_up1("Okoko in his over twenty (20) years business wealth  of experience in the United States "
								+ "has developed excellent team playing skills, good human resources management, operations management"
								+ " and Technology due diligence.");
						
						setBio_write_up2("Chief Charles who has attended several conferences home and abroad is a Patron of Global Association of "
								+ "Campaign Against Suicide (GACAS) and also, member of Maize Growers, Processors and Marketers Association of Nigeria (MAGPAMAN). "
								+ "With the involvement of   Chief Charles in the aforementioned, it shows his genuine concern for poverty alleviation. He has been recognized with "
								+ "  Poverty Alleviation Advocate Award* by Global Association of Campaign Against Suicide and *Youth Friendly by Qua-Iboe Church Secondary School"
								+ " Ogugu Old Students Association.");

						setBio_write_up3(" Chief Charles Ekemezie Okoko hails from Umudim Akwu Autonomous Community, Akokwa in Ideato North LGA of Imo State, Nigeria. He is married and the Union is blessed with three Children. He enjoys playing table tennis, football and golf. He is interested in both male and female."
						+ " Find Chief Charles Ekemezie Okoko on Facebook, Instagram, Twitter and LinkedIn.");
				return  "/Bio.xhtml?faces-redirect=true";
				
		

	       case 2:
	    	   setCol("p2.jpg");
	    	   setBio_name("BRIEF BIOGRAPHY OF COMR. OMALE JEFF EJUOJO (Managing Director)");
				setBio_write_up("Comr. Omale Jeff Ejuojo, a Technology Entrepreneur with experience in running "
						+ "					Start-ups and Emerging Companies is the Managing Director at LEMTRACO "
						+ "					INTERNATIONAL LIMITED, where he works purposely to alleviate poverty and eliminate hunger "
						+ "					by giving strategic guidance and direction to the board through her Chairman to ensure that the "
						+ "						company achieves her vision, mission and long term goals.");
				
				setBio_write_up1("In one year at LEMTRACO, Omale has been complimented by the Chairman and co-workers, increased revenue"
						+ "					 for the company, responded to over 70% customer calls daily and solved 90% of their concerns, worked on special projects "
						+ "					and developed a new employee orientation program that 99.99% of the company locations adopted. They have also identified several problems and solved them, "
						+ "						an achievement made possible by their team work and"
												+ " flexibility, issues resolution, strategic planning and execution.");
				
				setBio_write_up2("Prior to joining LEMTRACO INTERNATIONAL LIMITED, Ejuojo, a humanitarian was responsible for handling outside World like Media, employees hiring, external and internal affairs at Favoured Treasure Farm,"
						+ " a company he founded in August 2003. While there, Ejuojo, "
						+ "a strategic thinking individual experienced in turning low performing organizations into top revenue producers built a strong team building skill and Products development expertise."
						+ " Omale Jeff Ejuojo has been recognized with the Icon of Leadership  by National Association of Mathematics Students FUTO Chapter, Lover of community development and poverty alleviation "
						+ "by Odo-Ogene Youth Club Association (OYCA), Epitome of Competence by Association of Physical Sciences Students FUTO Chapter, and so on. He has attended several conferences and held several public offices.");
			
				setBio_write_up3("Ejuojo in his quest to selflessly put needed smile on underprivileged children faces and alleviate poverty in general co-formed  Odo-Ogene Youth Club Association (his community youth association) in 2008,"
						+ " Hope for the Hopeless in 2009 which later changed to Global Association of Campaign Against Suicide in 2019 and Jeff Audrey Foundation in October, 2020."
						+ " Omale Jeff Ejuojo* holds Bachelor of Technology in Mathematics from the prestigious Federal University of Technology Owerri and also, a Master's degree holder in view. when not hard at work, he enjoys seeing "
						+ "intelligent and funny movies, analyzing critical issues with solutions and reading important books.  Ejuojo  who hails from Ogugu Centre, Olamaboro Local Government Area, Kogi State, Nigeria is married and the "
						+ "Union is blessed with Children."
						+ "  Find Omale Jeff Ejuojo on Facebook, Instagram, Twitter and LinkedIn.");
				
				return  "/Bio.xhtml?faces-redirect=true";
				
	   	case 3:
	   		setCol("p3.png");
	   		
	   	  setBio_name("Brief Biography of Mr Gregory Tobechukwu Okoko (Executive Director)");
			
	  	setBio_write_up("Mr Gergroy Tobechukwu Okoko a degree holder in Networking Administration and  Engineering in   Programming. "
	  			+ "Tobechukwu who attended Cornerstone College and went"
	  							+"  futher to acquire a degree from India Institute of hardware and technology.");
	

	  	setBio_write_up1("Mr Tobechukwu runs an online business program where he"
	  							+ " enlightens the public with reliable information and current affairs.");
	   	
	  		setBio_write_up2(" Tobechukwu Contributes to the overall business strategy of "
	  				+ "LEMTRACO international limited for Creating awareness of the company and her policies to reach the public in their Unique ways as to facilitate the vision and mission of  LEMTRACO international limited");
	
	  		setBio_write_up3("You can find Mr Gregory  Tobechukwu okoko on"
	  			       + " LinkedIn, twitter, Facebook, Instargram.");

	  		return  "/Bio.xhtml?faces-redirect=true";
			
	      case 4:
	    	  setCol("jeff_wife_2.png");
	    	  
	    	  setBio_name("Brief Biography of Egnr. (Mrs) Nwobi  Ogechi Immaculata.");
	    	  
	    	  setBio_write_up(
	    			  "Nwobi Ogechi Immaculata, the third born and the second daughter of the family"
		    	  		+ " who grew up in her maternal home with her grandmother after the untimely death of her mother,"
		    	  		+ " is an optimistic young lady who works with diligence towards finding solution to problems, eradicating"
		    	  		+ " poverty and making life worth living for the masses.");
	    	  
	    	  setBio_write_up1("Ogechi  is an entrepreneur, philantropist, good counselor and a true humanitarian.");
	    	  
	    	  setBio_write_up2("Immaculata, because of her wealth of knowledge and experience has a lot of awards and certificates from different institutions "
	    	  		+ "  and organizations. She received the award of 'BEST FIELD OFFICER (MARKETER) of the year in 2014 at Dominon MFB LTD' where she worked for three years before joining Faithpraise Global Tech LTD in 2018."
	    	  				+ "At Faithpraise Global Tech., she was the General Manager and through each of her endeavours, "
	    	  				+ "Immaculata works to find solutions that brings success to all involved and she pays adequate attention"
	    	  				+ " towards fostering diversity.");
	    	  
	    	  setBio_write_up3("Nwobi Ogechi holds Higher National Diploma (HND) in Chemical Engineering from Federal Polytechnic, Nekede Owerri, "
	    	  		+ "Imo State, Nigeria and she is happily married with children."
	    	  		+ "She is a member of National Association of Chemical Engineering Technology (NACHET) "
	    	  		+ "and have started the process to joining  Council for the Regulation of Engineering in Nigeria (COREN).");
	    	  return  "/Bio.xhtml?faces-redirect=true";
		
			default:
				break;
			}
	 		
	 		return  null;
		}
		
	     
	   
	     





		public int getPx() {
			return px;
		}



		public void setPx(int px) {
			this.px = px;
		}




		public String plus() {
			px++;
	  return  null;	}
	     
	     public String minus() {
	    	 if(px<=0)  
	    		 px=1;
				px--;
			return  null;}
	     
	     
	    
	     
	     public void caculates() {
					System.out.println("ok"+px);
		}
	
		
		public  String  send_in_items() {
		
			FacesContext  context  =  FacesContext.getCurrentInstance();
			String id = context.getExternalContext().getRequestParameterMap().get("wq");
			long in =Long.valueOf(context.getExternalContext().getRequestParameterMap().get("ing"));
	        	long d =new 	Caculate().name(in, px);
				request.item_drop_in(px,in,d,id,GETID());
				message("Copy to Cart");
				px=1;
		
		return null;}
		
		
		
	 
	


		public void message(String k) {
	 	 RequestContext context =RequestContext.getCurrentInstance();
	 	 	context.execute("swal('"+k+"')");
	 	 	
	 	     
		}
	     
		  private void Session_tabs() {
		    	 Session().setAttribute("sess", GETID());
			}


			public String  GETID() {
				
		        	String c =Session().getId();
				return c;	
				}
		     
		     
		     public void request_new_id() {
		    	 Session().invalidate(); 
				       // System.out.println("Cleaner");
					
				}
		 
			public void teste() {
				
				     String c=  (String)Session().getAttribute("User1");
				new   UserServer_Request().logout(c);
			 	System.out.println("Ended ! app"+c);
		 }

		 
			
			public HttpSession Session() {
				FacesContext   context = FacesContext.getCurrentInstance();
		        HttpSession  session1= (HttpSession) context.getExternalContext() .getSession(false);
		        return session1;
			}
			
			public HttpSession Session1(HttpServletRequest request2) {
		        HttpSession  session1= (HttpSession) request2 .getSession(false);
		        return session1;
			}
			
			
			
			
		 
		    public String time_save(){
		           String o=null;
		        ZonedDateTime z= ZonedDateTime.now();
		        LocalTime time= LocalTime.now();
		        int g=z.toString().indexOf("[");
		        int c=z.toString().indexOf("]");
		        int d=z.toString().indexOf("T");
		        String q=z.toString().substring(g+1, c);
		        for(String h : ZoneId.getAvailableZoneIds()){ 
		          if(h.equals(q)){        
		               o=h.concat("       ").concat(z.toString().substring(0,d).concat("     "+time.toString().substring(0, 5)));
		                break; 
		          }  }
		    return  o;}
		    
		    
		    

		     
	
		     
		   
		     
		     
	
		     
		
}


