package vaccine;

/**
 * 
 * @author rahul
 * Assignment (1)
 * Rahul PATIL
 * Written by: (Rahul PATIL : 40166394)
 *
 * test Driver for vaccine class
 * 
 */
public class testDriver {
	public static void main(String[] args) {
		vaccine v1 = new vaccine();
		vaccine v2 = new vaccine(brand.BioNTech,1.5,"20201212",123456788L, 98.45);
		v2.setPrice(22.45);
		vaccine v3 = new vaccine();
		vaccine v4 = new vaccine(brand.Moderna,4.5,"20201210",127675568L, 188.45);
		v4.setDose(1.5);
		vaccine v5 = new vaccine(); 
		System.out.println("Total Vaccines created : "+vaccine.findNumberOfCreatedVaccines());
		vaccine.compareTwoVaccines(v3,v2);
		vaccine.compareTwoVaccines(v1, v4);
		vaccine.compareTwoVaccines(v1, v5);
	}
}
