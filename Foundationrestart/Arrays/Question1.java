import java.util.Scanner;
public class Question1{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        int n=scn.nextInt();
        int si=scn.nextInt();
        int ei=scn.nextInt();
        querySolver(a,si,ei);
    }
    public static void querySolver(int[] a,int si,int li)
    {
        int sum=0;
        for(int i=si;i<=li;i++){
           sum=sum+a[i];
        }
    }
}