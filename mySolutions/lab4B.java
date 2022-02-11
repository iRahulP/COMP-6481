import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class lab4B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n =Integer.parseInt(num);
        

        String[] que = new String[n];
        for(int i = 0; i < n; i++) {
            que[i] = sc.nextLine();
        }

        String  kk = sc.nextLine();
        int k = Integer.parseInt(kk);
        // sc.nextLine();
        // sc.close();
        // for(int i = 0; i < n; i++) {
        //     System.out.println(que[i]);
        // }


        TreeMap<String,Integer> grams = new TreeMap<String,Integer>();
        int maxVal = 0;
        String maxString = "";

        for(String s : que){
            for(int i = 0; i < s.length(); i++) {
                if(i+k<=s.length()){
                    String current = s.substring(i,i+k);
                if(current.contains(" ") || current.contains(",") || current.contains(".") || current.contains("\n")){
                }else{
                    if(grams.containsKey(current)){
                        int val = grams.get(current);
                        val=val+1;
                        grams.put(current,val);     
                    }else{
                        grams.put(current, 1);  
                    }
                }
                }
                
            }
        }
            
        

        Set<String> var = grams.keySet();
        Object[] arr = var.toArray();

        for(int i = 0; i < arr.length ; i++ ){
            if(grams.get(arr[i]) > maxVal){
                maxString = (String)arr[i];
                maxVal = grams.get(arr[i]);
            }
        }

        // System.out.println(grams);

        if(k == 1) {
            System.out.println("Unigram "+maxString);
        }
        if(k == 2 ) {
            System.out.println("Bigram "+maxString);
        }
        if(k == 3 ) {
            System.out.println("Trigram "+maxString);
        }

        sc.close();
    }
}
