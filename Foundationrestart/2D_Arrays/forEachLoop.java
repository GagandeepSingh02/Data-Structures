import java.util.Scanner;

public class forEachLoop{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] arr=new int[n][m];
        input(arr);
        display(arr);
    }
    public static void input(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    public static void display(int[][] arr){
        for(int[] d : arr)
        {
            for(int ele : d){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        
    }
}