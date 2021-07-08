import java.io.*;
import java.util.*;

public class waveRow {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);
        wavePatternR(arr);
    }
    public static void input(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
    }
    public static void wavePatternR(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; i++) {

            if (j % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.println(a[i][j]);
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.println(a[i][j]);
                }

            }
        }

    }

}