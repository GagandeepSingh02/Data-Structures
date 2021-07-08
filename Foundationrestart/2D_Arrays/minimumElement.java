import java.util.Scanner;

public class minimumElement{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] arr=new int[n][m];
        input(arr);
        minimumElement(arr);
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
    public static void minimumElement(int[][] arr){
        int min= (int)1e8;
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(min> arr[i][j]){
                    min=arr[i][j];
                }
            }
        }
        System.out.println(min);
    }
}