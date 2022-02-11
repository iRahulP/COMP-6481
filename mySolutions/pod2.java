import java.util.Scanner;

public class pod2 {
    private static int maximumSubArraySum(int[] arr) {
        int n = arr.length;
        int currSum = 0;
        int maxSub = -(int)1e9;

        for(int i = 0; i < n; i++) {
            currSum = currSum + arr[i];
            // System.out.println(currSum);
            if(currSum > maxSub) {
                maxSub = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        
        return maxSub;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().trim().split("\\.");

        
        int[] data = new int[arr.length];

        for(int i = 0; i < arr.length ; i++) {
            data[i] = Integer.parseInt(arr[i]);
        }
        // for(String ele : arr){
        //     System.out.println(ele);
        // }

        System.out.println(maximumSubArraySum(data));
        sc.close();
    }

    // -5.10.6.3
}
