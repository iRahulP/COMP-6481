import java.util.Scanner;

public class lab3A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[n * 2];
        for(int i = 0; i < strs.length; i++) {
            strs[i] = sc.nextLine().trim();
        }
        // for(String s : strs) {
        //     System.out.println(s);
        // }
        nativeDiff(strs);
        sc.close();
    }

    private static void nativeDiff(String[] strs) {
        int n = strs.length;
        int[] res = new int[(int)(n / 2)];
        
        int f = 0;
        // System.out.println(res.length);
        for(int i = 0 ; i < n; i = i + 2) {
            int j = 0, k = 0;
            int count = 0;
            while(j < strs[i].length() && k < strs[i + 1].length()) {
                if(strs[i].charAt(j++) == strs[i+1].charAt(k++)) {
                    count++;
                }else{
                    break;
                }
            }
            res[f++] = count;
        }

        for(int r : res) {
            System.out.println(r);
        }
    }
}
