import java.io.*;
import java.util.*;

public class Main {

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);
        spiralDisplay(arr, n, m);
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
    public static void spiralDisplay(int[][] a, int n, int m) {
        int rmin = 0, rmax = n - 1, cmin = 0, cmax = m - 1;
        int count = n * m;
        while (count != 0) {
            for (int r = rmin; r <= rmax && count > 0; r++) {
                System.out.println(a[r][cmin]);
                count--;
            }
            cmin++;
            for (int c = cmin; c <= cmax && count > 0; c++) {
                System.out.println(a[rmax][c]);
                count--;
            }
            rmax--;
            for (int r = rmax; r >= rmin && count > 0; r--) {
                System.out.println(a[r][cmax]);
                count--;
            }
            cmax--;
            for (int c = cmax; c >= cmin && count > 0; c--) {
                System.out.println(a[rmin][c]);
                count--;
            }
            rmin++;
        }
    }
}