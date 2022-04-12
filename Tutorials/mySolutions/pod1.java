import java.util.Scanner;

public class pod1 {
    private static int volOfWater(String[] bars) {
        int sum = 0;
        if (bars.length == 0)
            return 0;
        else {
            int l = 0;
            int r = bars.length - 1;
            int leftMax = Integer.parseInt(bars[l]);
            int rightMax = Integer.parseInt(bars[r]);

            while (l < r) {
                if(leftMax < rightMax) {
                    l += 1;
                    leftMax = Math.max(leftMax, Integer.parseInt(bars[l]));
                    sum += leftMax - Integer.parseInt(bars[l]);
                }else{
                    r -= 1;
                    rightMax = Math.max(rightMax, Integer.parseInt(bars[r]));
                    sum += rightMax - Integer.parseInt(bars[r]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] bars = sc.nextLine().strip().split(",");
        System.out.println(volOfWater(bars));
        sc.close();
    }
}
