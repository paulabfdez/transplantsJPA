package transJPA.db.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class Menu {

	
	
   	
   	public static void main (String []args) throws IOException{	
   	//DBManager dmanager = new DBManager();
   	   Uihospital uiHosp=new Uihospital();
   		Uidoctor uiDoct=new Uidoctor();
   		Uidonor uiDon=new Uidonor();
   		Uipatient uiPat=new Uipatient();
   		Uiorgan uiOrgan= new Uiorgan();
   		Uianimaltissue uiAnimalT= new Uianimaltissue();
   		Uireqorgan uiReq = new Uireqorgan();			        
   		
   	
   	 while(true){
   		 
   		BufferedReader console=new BufferedReader (new InputStreamReader (System.in));
   		 Integer option=0;
      	System.out.println("\nMENU: ");
      	System.out.println("1. Introduce new information to the database. ");
      	System.out.println("2. Search for specific information in the database. ");
      	System.out.println("3. Options that this database offers in order to make "
      						+ "transplantation prosses more efficient.");
      	System.out.println("4. Exit from the database. ");
      		        	
      	 do{
                  System.out.println("\nChoose an option[1-4]:");
                  
                  String read= console.readLine();
                  option= Integer.parseInt(read);            
           }
      	 while (option<0|| option>4);
   	
   	 
   	 switch(option){
   	 case 1: System.out.println("1. Introduce a new hospital. ");
 	         System.out.println("2. Introduce a new doctor. ");
 	         System.out.println("3. Introduce a new donor."); //introducing also the organ that is donating
 	         System.out.println("4. Introduce a new patient. "); //introducing also the requested organ
             System.out.println("5. Introduce a new animal tissue in order to be donated. ");
 	         System.out.println("\nChoose an option[1-5]:");
            String read1= console.readLine();
     int option1= Integer.parseInt(read1); 
     switch (option1){
         case 1:
        	 
         	uiHosp.introduceNewHospital();
         	
         	break;
        case 2:
         	uiDoctor.introduceNewDoctor();
         	//TEST
         	break;
         /*case 3:
         	uiDonor.introduceNewDonor();
         	System.out.println("Introduce the organ that the donor donates. ");
         	uiOrgan.introduceNewOrgan();
         	//foreign keys
         	break;
         case 4:
         	Patient p = uiPatient.introduceNewPatient();
         	System.out.println("Introduce the organ that the patient needs. ");
         	uiRequested.introduceNewReqOrgan(p);
         	//foreign keys in requested organ
         	break;
         case 5:
         	uiAnimalT.introduceNewAnimalTissue();
         	break;*/
     }	                         	 		        			
		
	}
	break;
   	 
   	 
   	 
   	 }
   	 }
   	
   		
   		
   		
   		
   		
   		
   		
   		
	}	
	
   	
    
}
