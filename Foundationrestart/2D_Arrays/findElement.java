import java.util.Scanner;

public class findElement{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] arr=new int[n][m];
        input(arr);
        int ele=scn.nextInt();
        findElement(arr,ele);
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
    public static void findElement(int[][] arr , int data){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(data == arr[i][j])
                {
                System.out.print(i + " " + j);
                break;
                }   
            }
        }
    }
}