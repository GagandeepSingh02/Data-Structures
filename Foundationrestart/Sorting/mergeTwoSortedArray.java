import java.io.*;
import java.util.*;

public class  mergeTwoSortedArray {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b, int n, int m) {
        //write your code here
        int i = 0, k = 0, j = 0;
        int[] c = new int[n + m];
        while (i <= n - 1 && j <= m - 1) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i <= n - 1) {
            c[k++] = a[i++];
        }
        while (j < m) {
            c[k++] = b[j++];
        }
        return c;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b, n, m);
        print(mergedArray);
    }

}