import java.util.Scanner;
public class heapSort{
    public static Scanner scn = new Scanner(System.in);
    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static boolean compareTo(int a,int b, boolean isMax){
        if(isMax){
            return a > b;
        }else{
            return b < a;
        }

    }
    public static void heapify(int[] arr,int pi,int n, boolean isMax) {
        int maxIdx = pi;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;

        if (lci < n && compareTo(lci,maxIdx,isMax) )
            maxIdx = lci;

        if (rci < n && compareTo(rci,maxIdx ,isMax))
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(arr,maxIdx, pi);
            heapify(arr,maxIdx,n, isMax);
        }
    }
    public static void display(int[] arr){
    for(int i = 0; i < arr.length ; i++)
    System.out.print(arr[i] + " ");
    }

    public static void main(String[] args){
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < arr.length ; i++)
    arr[i] = scn.nextInt();
     int len = arr.length;
     boolean isMax = false;
         for(int i = len - 1; i >= 0; i--){
             heapify(arr,i,len-1,isMax);
        }
        for(int i = len - 1; i >= 0 ; i--){
            swap(arr,0,i);
            heapify(arr,0,i,isMax);
        }
    display(arr);
    }
}