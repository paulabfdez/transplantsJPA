package transJPA.db.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import transJPA.db.pojos.Hospital;

public class Uihospital{
	
	public Uihospital(){		
	}
	
      
     
	public void introduceNewHospital(){
		try{
			BufferedReader console = new BufferedReader (new InputStreamReader (System.in));
			System.out.print("Name: ");
			String name = console.readLine();
			//We are going to make phone number, address and postcode Strings to give the 
			//user more freedom for ex: (216)444-2200
			System.out.print("Phone number: ");
			String phone_number = console.readLine();
			
			System.out.print("Address: ");
			String address = console.readLine();
			
			System.out.print("City: ");
			String city = console.readLine();
			
			System.out.print("Postcode: ");
			String post_code = console.readLine();
			
			System.out.print("Country: ");
			String country = console.readLine();
			
			Hospital hosp= new Hospital(name, phone_number, address, city, post_code, country);
			System.out.print("Hospital has been introduced");
		
				
				
		
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}