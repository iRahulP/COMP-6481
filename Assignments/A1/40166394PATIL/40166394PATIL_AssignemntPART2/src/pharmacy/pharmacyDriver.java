package pharmacy;

import java.util.Scanner;
import vaccine.brand;
import vaccine.vaccine;

/**
 * 
 * @author rahul
 * Assignment (1)
 * Rahul PATIL
 * Written by: (Rahul PATIL : 40166394)
 * 
 * Driver Class
 *
 */
public class pharmacyDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("    Welcome to  R's Pharmacy!");
		
		//User input for max number of vaccines from user
		System.out.println("Enter the maximum number of vaccines which the store can inventory?");
		int total = sc.nextInt();
		int outerloop; // main screen handler
		
		int passAttempts = 0;
		String password = "password";

		int inchoice1;
		int inchoice2;
		
		//Array of type vaccine with the <total> size
		vaccine[] store = new vaccine[total];

		StringBuilder sb1 = new StringBuilder();
		sb1.append("What do you want to do?\n"
				+ "		1. Enter new vaccines (password required)\n"
				+ "		2. Change information of a vaccine (password required)\n"
				+ "		3. Display all vaccines by a specific brand\n"
				+ "		4. Display all vaccines under a certain a price.\n"
				+ "		5. Quit\n"
				+ "Please enter your choice >");		
		String s1 = sb1.toString();
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("What information would you like to change?\n"
				+ "		1. Brand\n"
				+ "		2. Dose\n"
				+ "		3. Expiry\n"
				+ "		4. Price\n"
				+ "		5. Quit\n"
				+ "Enter your choice >");
		String s2 = sb2.toString();
		
		try {
			
			do{	
				// main screen :: loops until user enters 5
				do{ 
					// handling password attempts in loop
					do{
						// inner loop for user's choices between 1 to 5
						System.out.println(s1);
						outerloop = sc.nextInt();
					}while(outerloop < 1 || outerloop > 5); 
					

					String pass = null; 
					
					//pass check for outerloop
					if (outerloop == 1) {
						do{
							System.out.println("Please enter a valid password:");
							pass = sc.next();
							if (pass.compareTo(password) != 0){
								//increment the password attempts if wrong
								passAttempts++;
							}
							if (passAttempts == 3|| passAttempts == 6 || passAttempts == 9)
								//every third time user gets it wrong, go back to main screen
								break;
							if (passAttempts == 12){
								//if user gets it wrong 12th in a row, terminate the application
								System.out.println("Program detected suspicious activities and will terminate immediately!");
								System.exit(0);
							}	
						}while(pass.compareTo(password) != 0);
						
						if (pass.compareTo(password) == 0) {
							//if user gets it right, break out of middle do-while to the application
							break;
						}
					}	
					
					//password check inner one
					else if(outerloop == 2) {
						
						//a second counter for the password attempt fails
						//re-starts every iteration endlessly until user gets password right
						int passFailAttempts2 = 0;
						do{
							System.out.println("Please enter a valid password:");
							pass = sc.next();
							if (pass.compareTo(password) != 0){
								//increment the Password Failed attempts
								passFailAttempts2++;
							}
							if (passFailAttempts2 == 3) {
								//every third attempt makes user go back to main screen.
								break;
							}
						}while(pass.compareTo(password) != 0);
						
						if (pass.compareTo(password) == 0) {
							//if user gets it right, break out of middle do-while to the application
							break;
						}
					}	
					
					//if user enters 3,4,5 they get access to the rest of the program, no password required
					else {
						break;
					}
				//close middle do-while
				}while(true); 
				
				//after access blocks
				switch (outerloop){
					case 1: 
						int newVaccines; // will store number of new vaccines to be added
						do{
							System.out.println("How many vaccines would you like to add?");
							newVaccines = sc.nextInt();
							
							//If the added surpasses the availiable space, informs user about the remaining space
							if(total - newVaccines - vaccine.findNumberOfCreatedVaccines() < 0 && total - vaccine.findNumberOfCreatedVaccines() != 0)
								System.out.println("Not enough space! you only have space for " +(total - vaccine.findNumberOfCreatedVaccines()) + " vaccines");
							
							//If the array is full, application returns to main screen
							if(total - vaccine.findNumberOfCreatedVaccines() == 0){
								System.out.println("Not enough space to add new vaccines!");
								break;
							}
							
						}while(total - newVaccines - vaccine.findNumberOfCreatedVaccines() < 0);
						//while the number of vaccines you want to add would surpass space in initial array
									
						if(total - vaccine.findNumberOfCreatedVaccines() == 0)
							//re-start if there is no space
							continue;
						
						int toBeAdded = (vaccine.findNumberOfCreatedVaccines() + newVaccines);
						for(int i = vaccine.findNumberOfCreatedVaccines(); i < (toBeAdded); i++){
							//loops for the empty available space in array to store vaccine objects
							//get vaccine meta data for object
							System.out.println("Enter brand, dose, expiry date, id and price for the vaccine!");
							String brandVal = sc.next();
							double doseVal = sc.nextDouble();
							String expiryVal = sc.next();
							long idVal = sc.nextLong();
							double priceVal = sc.nextDouble();
							store[i] = new vaccine(brand.valueOf(brandVal),doseVal,expiryVal,idVal,priceVal);
						}
						continue; //go back to main screen
						
					case 2:
						int updateVaccine; // Updating a specific vaccine object
						do{
							System.out.println("Which vaccine would you like to update? (index value)");
							updateVaccine = sc.nextInt();
							
							if(store[updateVaccine] == null){
								//check to see if there exists a vaccine object at the index already. if not, display message to User
								System.out.println("There is no vaccine here! would you like to \n"
										+ "\t1. re-enter a vaccine"
									    + " or \n"
									    + "\t2. go back to main menu?");
								inchoice1 = sc.nextInt();
								if(inchoice1 ==1)
									continue;
								else
									break;
							}
							else 
								break; 
						}while(true);
						
						if(store[updateVaccine] == null) {
							//back to main menu if no vaccine was present
							continue;
						}
						
						do{
							//info for vaccine object chosen by user
							System.out.println(store[updateVaccine].toString(updateVaccine)+"\n");
						
							do{
								System.out.println(s2);
								inchoice2 = sc.nextInt();
							}while(inchoice2 < 1 || inchoice2 > 5); //Valid choices for the loop
						
							switch(inchoice2){
								//switch case to determine which attribute to change. use the setters to update the vaccine object
								case 1:
									System.out.println("change brand of vaccine to: ");
									String brandVal = sc.next();
									store[updateVaccine].setBrandName(brand.valueOf(brandVal));
									break;
								case 2:
									System.out.println("change dose value of vaccine to: ");
									double doseVal = sc.nextDouble();
									store[updateVaccine].setDose(doseVal);
									break;
								case 3:
									System.out.println("change expiry date of vaccine to: ");
									String expiryVal = sc.next();
									store[updateVaccine].setExpiry_date(expiryVal); 
									break;
								case 4:
									System.out.println("change price of vaccine to: ");
									double priceVal = sc.nextDouble();
									store[updateVaccine].setPrice(priceVal);
								case 5:
									break;
								}
							if(inchoice2 == 5) {
								break; // to main						
							}
						}while(true);
						continue;
					case 3:
						//display the information of all vaccines by User requested brand
						System.out.println("find vaccines by a brand? Enter a brand: ");
						String brandVal = sc.next();
						vaccine.findVaccinesBy(store, brand.valueOf(brandVal));
						continue;
					case 4:
						//display all vaccines that have a value smaller than that entered price value by User
						System.out.println("find vaccines cheaper than a price? Enter a price: ");
						double price = sc.nextDouble();
						vaccine.findCheaperThan(store, price);
						continue;
					case 5:
						// exits the application
						System.out.println("Closing the Application!");
						System.exit(0);
					}
				sc.close();
			}while(true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}