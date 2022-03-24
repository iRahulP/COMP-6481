package vaccine;

/**
 * 
 * @author rahul
 * Assignment (1)
 * Rahul PATIL
 * Written by: (Rahul PATIL : 40166394)
 * 
 * vaccine class
 *
 */
public class vaccine {
	
	private double dose;
	private String expiry_date;
	private long id;
	private double price;
	private static int count = 0;
	public brand brandName;
	
	/**
	 * parameterized constructor
	 * @param brandName 
	 * @param dose
	 * @param expiry_date
	 * @param id
	 * @param price
	 */
	public vaccine(Enum<brand> brandName, double dose, String expiry_date, long id, double price) {
		this.brandName = (brand) brandName;
		this.dose = dose;
		this.expiry_date = expiry_date;
		this.id = id;
		this.price = price;
		
		addNewVaccine();
	}
	
	/**
	 * provides total count of vaccines made
	 * @return count of vaccines
	 */
	public static int findNumberOfCreatedVaccines() {
		return count;
	}
	
	/**
	 * compares two vaccines based on brand and dose information
	 * @param v1 vaccine 1
	 * @param v2 vaccine 2
	 */
	public static void compareTwoVaccines(vaccine v1, vaccine v2) {
		if( (v1.getBrandName().equals(v2.getBrandName())) && v1.getDose() == v2.getDose()) {
			System.out.println("\n\t Vaccines ******************** "+v1.toString()+"\n\t ******************** and ******************** "+v2.toString()+"\n\t ******************** are same! ********************");
			System.out.println();
		}else {
			System.out.println("\n\t Vaccines ******************** "+v1.toString()+"\n\t ******************** and ******************** "+v2.toString()+"\n\t ******************** are not same! ********************");	
			System.out.println();
		}
	}

	/**
	 * default constructor with some default values
	 */
	public vaccine() {
		this.brandName = brand.Oxford;
		this.dose = 1.5;
		this.expiry_date = "20241008";
		this.id = 7724682539L;
		this.price = 52.94;	
		
		addNewVaccine();
	}


	/**
	 * method to keep track of total vaccines
	 */
	private void addNewVaccine() {
		count++;
	}

	/**
	 * overrides deafult toString method and prints details of vaccine.
	 * instead of the object address.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nbrand : "+this.brandName);
		sb.append("\ndose : "+this.dose);
		sb.append("\nexpiry date : "+this.expiry_date);
		sb.append("\nid : "+this.id);
		sb.append("\nprice : "+this.price);
		return sb.toString();
	}
	
	/**
	 * A toString method to print the attributes 
	 * @return a String stating the attribute values
	 * @param num This is the index of the vaccine in the vaccine array.
	 */
	public String toString(int num){
		StringBuilder sb = new StringBuilder();
		sb.append("Vaccine: "+num);
		sb.append("\nID: "+this.id);
		sb.append("\nBrand: "+this.brandName);
		sb.append("\nDose: "+this.dose);
		sb.append("\nExpiry: "+this.expiry_date);
		sb.append("\nPrice: $"+this.price);
		return sb.toString();
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setBrandName(brand brandName) {
		this.brandName = brandName;
	}
	
	public brand getBrandName() {
		return brandName;
	}
	
	public double getDose() {
		return dose;
	}
	
	public void setDose(double dose) {
		this.dose = dose;
	}
	
	public String getExpiry_date() {
		return expiry_date;
	}
	
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}

	/**
	 * display the information of all vaccines by User requested brand
	 * @param v an array of vaccine objects
	 * @param brand the brand provided by user
	 */
	public static void findVaccinesBy(vaccine[] v, brand brand){
		for (int i = 0; i < v.length; i++){
			if(v[i] != null && v[i].getBrandName().compareTo(brand)==0)
				System.out.println(v[i].toString(i)+"\n");
		}
	}
	
	/**
	 * display all vaccines that have a value smaller than that entered price value by User
	 * @param v an array of vaccine objects
	 * @param threshold the price provided by user which acts as threshold
	 */
	public static void findCheaperThan(vaccine[] v, double threshold){
		for (int i = 0; i < v.length; i++){
			if(v[i].getPrice() < threshold && v[i] != null)
				System.out.println(v[i].toString(i)+"\n");
		}
	}
}
