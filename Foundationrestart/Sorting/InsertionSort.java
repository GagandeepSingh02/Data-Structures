import java.io.*;
import java.util.*;

public class InsertionSort{
    public static void move(int[] arr, int si, int ei) {
        int smallidx = si;
        for (int j = si - 1; j >=0; j--) {

            if (arr[j]>arr[smallidx]) {
                
                swap(arr, j, smallidx);
                smallidx=j;
            }
            else{
                return;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        //write your code herefor 
        for (int i = 1; i < arr.length; i++) {
            move(arr, i, arr.length);
        }

    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        insertionSort(arr);
        print(arr);
    }
}