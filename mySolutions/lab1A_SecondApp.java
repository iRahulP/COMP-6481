import java.util.Scanner;

public class lab1A_SecondApp {

	private static String namesBack(String str) {

		str = str.trim();
		str = str.replaceAll("( +)", " ");
		if(str.length() == 0) {
			return null;
		}
		else {
//			int n = str.length();
//			int countWords = 0;
			
			String[] temp = str.split(" ");
			
//			for(int i=0; i < n - 1; i++) {
//				if(str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
//					countWords++;
//				}
//			}
//			// Spaces + 1 -> total Words
//			countWords++;
//			int k=0;
//			int idx = 0;
//			String[] temp = new String[countWords];
//			for(int j =0 ; j< n - 1; j++) {
//				if(str.charAt(j) == ' ' && str.charAt(j + 1) != ' ') {
//					temp[k] = str.substring(idx, j).trim();
//					k++;
//					idx=j + 1;
//				}
//			}
//			
//			//Appending the last one after final Space
//			temp[k] = str.substring(idx).trim();
//			
			
			char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'O', 'U', 'I'};
			boolean lastNameCheck = false;
			// check for lastname in case 2
			if(temp.length == 2) {
				for(int v =0; v < vowels.length; v++) {
					if(temp[temp.length - 1].charAt(temp[temp.length - 1].length() - 1) == vowels[v]) {
						lastNameCheck = true;
						break;
					}
				}				
			}
			
			String ans = "";
			if(lastNameCheck || temp.length == 3) {
				//adding last name 
				ans = ans + temp[temp.length - 1] + " ";
				for(int i = 0; i < temp.length - 1; i++) {
					ans = ans + temp[i] + " ";
				}
			}
			else {
				for(int i = 0; i < temp.length; i++) {
					ans = ans + temp[i] + " ";
				}
			}		
			return ans.trim();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String q = sc.nextLine();
		System.out.println(namesBack(q));
		sc.close();
	}

}
