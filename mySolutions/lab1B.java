import java.util.Scanner;

public class lab1B {
    public static Scanner scn = new Scanner(System.in);

    public static long powerFunction(long num){
        long power = 1;
        long number = num/10;
        while(number !=0){
            number /= 10;
            power *= 10;
        }
        return power;
    }

    public static long numberConvertorHelper(long num, long powerValue){
        long result = 0;
        long currIdx= 1;

        while(num !=0){
            long currLastDigit = num % 10;
            if(currIdx++ %2 == 0) {
                currLastDigit = currLastDigit * 2;
                currLastDigit = currLastDigit >= 10 ?
                        (currLastDigit/10 + currLastDigit%10)
                        : currLastDigit;
            }


            result += currLastDigit;
            num /= 10;
            powerValue /= 10;
        }
        return result;
    }

    public static String numberValidator(long num){

        long powerValue = powerFunction(num);
        long digitsSum = numberConvertorHelper(num, powerValue);

        if(digitsSum %10 == 0) return "VALID";
        else{
            long lastDigit = num % 10;
            
            long sumWithoutLast = digitsSum - lastDigit;
            long lastDigitOfSumWithoutLast = sumWithoutLast % 10;
            
            int[] mapped = {0 , 9, 8, 7, 6, 5, 4, 3, 2, 1};
            
            long replaceD = mapped[(int) lastDigitOfSumWithoutLast];
            return "INVALID "+ replaceD;
        }
    }

    public static void main(String[] args) {
        long num= scn.nextLong();
        System.out.println(numberValidator(num));
    }
}