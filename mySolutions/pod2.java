public class pod2 {
    private static int maximumSubArraySum(int[] arr) {
        int n = arr.length;
        int currSum = 0;
        int maxSub = -(int)1e9;

        for(int i = 0; i < n; i++) {
            currSum = currSum + arr[i];
            if(maxSub < currSum) {
                maxSub = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        
        return maxSub;
    }


    public static void main(String[] args) {
        
    }
}
