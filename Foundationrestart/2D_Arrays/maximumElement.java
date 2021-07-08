import java.util.Scanner;

public class maximumElement{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] arr=new int[n][m];
        input(arr);
        maximumElement(arr);
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
    public static void maximumElement(int[][] arr){
        int max= -(int)1e8;
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(max< arr[i][j]){
                    max=arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}