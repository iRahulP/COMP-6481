import java.util.HashMap;
import java.util.Scanner;

public class lab4B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String que = "";
        for(int i = 0; i < n; i++) {
            que += sc.nextLine();
        }

        int  k = sc.nextInt();
        sc.nextLine();
        System.out.println(nGrams(que, k)); 
        sc.close();
    }

    private static String nGrams(String str, int k) {
        
        HashMap<String,Integer> grams = new HashMap<String,Integer>();
        int maxVal = -(int)1e9;
        String maxString = "";
        for(int i = 0; i <= str.length() - k; i++) {
            String current = str.substring(i,i+k);
            if(grams.containsKey(current)){
                int val = grams.get(current);
                grams.put(current, ++val);    
                if(val > maxVal) {
                    maxVal = val;
                    maxString = current;
                }
            }else{
                grams.put(current, 1);
                if(grams.get(current) > maxVal) {
                    maxVal = grams.get(current);
                    maxString = current;
                }
            }
        }

        if(k == 1) {
            return "Unigram "+maxString;
        }
        else if(k == 2) {
            return "Bigram "+maxString;
        }
        else {
            return "Trigram "+maxString;
        }
        
    }
}
