import java.util.*;

public class lab2A {

	private static String studentsAge(String str) {
		str = str.replaceAll("( +)", " ");
		String[] bits = str.split(" ");
		int DD = Integer.parseInt(bits[0]);
		int MM = Integer.parseInt(bits[1]);
		int YYYY = Integer.parseInt(bits[2]);
		
		if((2022 - YYYY)  > 13) {
			return "old enough";
		}
		else if((2022 - YYYY)  == 13) {
			if((4 - MM) > 0) {
				return "old enough";
			}
			else if ((4 - MM) == 0) {
				if ((18 - DD) >= 0) {
					return "old enough";
				}else {
					return "too young";
				}
			}
			else {
				return "too young";
			}
		}
		else {
			return "too young";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		if(n >= 1 && n <= 25) {
			String[] DOBs = new String[n];
			for(int i = 0; i < DOBs.length; i++) {
				DOBs[i] = sc.nextLine();
			}
			
			for(String s : DOBs) {
				System.out.println(studentsAge(s));
			}
		}
		
		sc.close();
	}
	// 26 11 2009
    // 27 02 2005 
    // 28 10 2007

}
