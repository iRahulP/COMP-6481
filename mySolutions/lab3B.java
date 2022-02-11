import java.util.Scanner;

public class lab3B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rank = sc.nextInt();
        String[] names = new String[n];
        int[] ones = new int[n];
        int[] twos = new int[n];
        int[] threes = new int[n];
        int[] time = new int[n];

        for(int i = 0; i < n ;i++) {
            names[i] = sc.next();
            ones[i] = sc.nextInt();
            twos[i] = sc.nextInt();
            threes[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }

        double[] scores = new double[n];
        for(int i = 0; i < n; i++) {
            scores[i] = ((ones[i] + twos[i]*2 + threes[i]*3) / (double) time[i] ) * 1000;
            String temp = Double.toString(scores[i]);
            // System.out.println(temp);
            int idx = temp.indexOf(".");
            // String[] splitIt = temp.split(".");
            // for(String s : splitIt) {
            //     System.out.println(s);
            // }
            // System.out.println(temp.charAt(idx));
            if(temp.charAt(idx + 1) - '0' >= 5){
                scores[i] = (int)scores[i] + 1;
            }else{
                scores[i] = (int)scores[i];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(scores[i] < scores[j]){
                    int temp = (int)scores[i];
                    String temp2 = names[i];
                    
                    scores[i] = scores[j];
                    names[i] = names[j];

                    scores[j] = temp;
                    names[j] = temp2;
                }
            }
        }

        System.out.println(names[rank - 1]+" "+(int)scores[rank - 1]);

        sc.close();
    }
}
