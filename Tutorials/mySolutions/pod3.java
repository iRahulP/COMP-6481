import java.util.Scanner;
import java.util.Arrays;

public class pod3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[3];
        for(int i = 0; i < 3; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[3];
        for(int i = 0; i < 3; i++) {
            arr2[i] = sc.nextInt();
        }
        // for(int ele : arr) {
        //     System.out.println(ele);
        // }

        checkTriange(arr1,arr2);

        sc.close();
    }

    private static void checkTriange(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int k = 0;
        for(int i = 0; i < 3; i++) {
            if(arr1[i] == arr2[i]){
                k++;
            }
        }
        //check if the triangles are perfect right angeled
        if(arr1[0]*arr1[0] + arr1[1]*arr1[1] == arr1[2]*arr1[2] && arr2[0]*arr2[0] + arr2[1]*arr2[1] == arr2[2]*arr2[2] && k == 3){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
