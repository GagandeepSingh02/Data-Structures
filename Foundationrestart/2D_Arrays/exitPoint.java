import java.io.*;
import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);
        exitPoint(arr, n, m);
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

    public static void exitPoint(int[][] arr, int row, int col) {
        int i = 0, j = 0, d = 0;
        while (true) {
            d = (d + arr[i][j]) % 4;

            if (d == 0) {
                j++;
                if (j == col) {
                    System.out.println(i);
                    System.out.println(j - 1);
                    break;
                }
            } else if (d == 1) {
                i++;
                if (i == row) {
                    System.out.println(i - 1);
                    System.out.println(j);
                    break;
                }

            } else if (d == 2) {
                j--;
                if (j == -1) {
                    System.out.println(i);
                    System.out.println(j + 1);
                    break;
                }
            } else {
                i--;
                if (i == -1) {
                    System.out.println(i + 1);
                    System.out.println(j);
                    break;
                }
            }
        }

    }
}