import java.util.*;

public class lab1BString {
	
	private static String CreditCheck(String str) {
		
		int n = str.length();
		
		int sum = 0;
		int temp = 0;
		String twoDigits = "";
		if( n % 2 == 0) {
			for(int i = 0; i < n; i++) {
				if(i % 2 == 0) {
					temp = (str.charAt(i) - '0') * 2;
					twoDigits = Integer.toString(temp);
					if(twoDigits.length() == 2) {
						sum += (twoDigits.charAt(0) - '0') + (twoDigits.charAt(1) - '0');
					}else {
						sum += temp;
					}
				}else {
					temp = (str.charAt(i) - '0');
					sum += temp;
				}
			}
		}else {
			for(int i = 0; i < n; i++) {
				if(i % 2 != 0) {
					temp = (str.charAt(i) - '0') * 2;
					twoDigits = Integer.toString(temp);
					if(twoDigits.length() == 2) {
						sum += (twoDigits.charAt(0) - '0') + (twoDigits.charAt(1) - '0');
					}else {
						sum += temp;
					}
				}else {
					temp = (str.charAt(i) - '0');
					sum += temp;
				}
			}
		}
		
		String res = "";
		if(sum % 10 == 0) {
			res = "VALID";
		}else {
			int lastDigit = (str.charAt(n - 1) - '0') % 10;
            
            int sumWithoutLast = sum - lastDigit;
            int lastDigitOfSumWithoutLast = sumWithoutLast % 10;
            
            int[] mapped = {0 , 9, 8, 7, 6, 5, 4, 3, 2, 1};
            
            int replaceD = mapped[lastDigitOfSumWithoutLast];
            res = "INVALID "+ replaceD;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(CreditCheck(str));
		sc.close();
	}
}
