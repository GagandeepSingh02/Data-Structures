import java.io.*;
import java.util.*;

public class Main {

    public static void targetSumPair(int[] arr, int target) {
        //write your code here
        Arrays.sort(arr);
        int si=0,ei=arr.length-1;
         while (si < ei) {
         int sum=arr[si] + arr[ei];
         if (sum < target) {
            si++;
        } else if (sum > target) {
            ei--;
        }else  {
            System.out.println(arr[si] + ", " + arr[ei]);
            si++;
            ei--;
        }
    }
}

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPair(arr, target);
    }

}