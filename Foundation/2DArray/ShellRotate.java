import java.io.*;
import java.util.*;

public class Main {
public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=scn.nextInt();
            }
        }
        int s=scn.nextInt();
        int r=scn.nextInt();
        rotateShell(arr,s,r);
        display(arr);
    }

public static void rotateShell(int[][] arr , int s,int r)
    {
        int[] oned=fillOnedfromShell(arr , s);
        rotate(oned , r);
        fillShellfromOned(arr,s,oned);
    }

public static int[] fillOnedfromShell(int[][] a , int s)
{
    int rmin=s-1;
    int cmin=s-1;
    int rmax=a.length-s;
    int cmax=a[0].length-s;
    int size=2 * (rmax - rmin + cmax - cmin);
    
    int[] oned= new int[size];
    int idx=0;
    //lw
    for(int i=rmin,j=cmin;i<=rmax;i++)
    {
        oned[idx]=a[i][j];
        idx++;
    }
    //bw
    for(int i=rmax,j=cmin+1;j<=cmax;j++)
    {
        oned[idx]=a[i][j];
        idx++;
    }
    //rw
    for(int i=rmax-1,j=cmax;i>=rmin;i--)
    {
        oned[idx]=a[i][j];
        idx++;
    }
    //tw
    for(int i=rmin,j=cmax-1;j>=cmin+1;j--)
    {
        oned[idx]=a[i][j];
        idx++;
    }
    return oned;
}
public static void rotate(int[] a,int r)
{
    int len=a.length;
    r%=len;
    if(r<0) r=r+len;
    reverse(a,0,a.length-r-1);
    reverse(a,a.length-r,a.length-1);
    reverse(a,0,a.length-1);
}
public static void reverse(int[] a,int li,int ri)
{
    while(li<ri)
    {
        int temp=a[li];
        a[li]=a[ri];
        a[ri]=temp;
        li++;
        ri--;
    }
}
public static void fillShellfromOned(int[][] a , int s,int[] oned)
{
    int  rmin=s-1;
    int cmin=s-1;
    int rmax=a.length-s;
    int cmax=a[0].length-s;
     int idx=0;
    //lw
    for(int i=rmin,j=cmin;i<=rmax;i++)
    {
        a[i][j]=oned[idx];
        idx++;
    }
    //bw
    for(int i=rmax,j=cmin+1;j<=cmax;j++)
    {
        a[i][j]=oned[idx];
        idx++;
    }
    //rw
    for(int i=rmax-1,j=cmax;i>=rmin;i--)
    {
        a[i][j]=oned[idx];
        idx++;
    }
    //tw
    for(int i=rmin,j=cmax-1;j>=cmin+1;j--)
    {
        a[i][j]=oned[idx];
        idx++;
    }
}
    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}