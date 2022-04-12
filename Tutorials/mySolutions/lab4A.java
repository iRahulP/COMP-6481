import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class lab4A {

    private static void sorted(char[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j= i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private static String pairedIsogram(String str) {
        
        // list of unique chars 
        ArrayList<Character> unique = new ArrayList<Character>();
        for(int i = 0; i < str.length(); i++) {
            if(!unique.contains(str.charAt(i))){
                unique.add(str.charAt(i));
            }
        }

        // System.out.println(unique);

        // map of paired chars
        HashMap<Character, Integer> paired = new HashMap<Character,Integer>();
        int count = 1;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)){
                    paired.put(str.charAt(i), ++count);
                }
            }
            count = 0;
        }

        // System.out.println(paired);

        // if both are same
        if(unique.size() == paired.size()) {
            // res for paired YES
            char[] res = new char[paired.size()];
            int k = 0;
            for(Character c : unique) {
                if(paired.containsKey(c)) {
                    res[k++] = c;
                }
            }
            sorted(res);
            String result1 = "";

            for(int i = 0; i < res.length; i++) {
                result1 += ""+res[i]+" ";
            }

            return result1.trim() + " yes";

        }else{
            // res of non paired NO
            char[] res = new char[str.length() - paired.size()];
            int k = 0;
            String result2 = "";
            for(Character c : unique) {
                if(!paired.containsKey(c)) {
                    res[k++] = c;
                }
            }
            sorted(res);
            for(int i = 0; i < res.length; i++) {
                result2 +=""+res[i]+" ";
            }

            return result2.trim() + " no";
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String que = sc.next();
        System.out.println(pairedIsogram(que)); 
        sc.close();
    }

}
