import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class l003Array{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)
    {
        int n=scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=scn.nextInt();
        }
        System.out.println(maximumEle(arr));
        System.out.println(minimumEle(arr));
    }

  //================================================================


    public static int maximumEle(int[] arr)
    {
        int max=(int)-1e8;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }

//==================================================================

    public static int minimumEle(int[] arr)
    {
        int min=(int)1e8;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<min) min=arr[i];
        }
        return min;
    }

 //============================================================================== 


public static void SumArray(int[] arr1 ,int[] arr2,int n1,int n2)
{
    int[] sum=new int[n1>n2?n1:n2];
    int i=arr1.length-1;
    int j=arr2.length-1;
    int k=sum.length-1;
    int c=0;
    while(k>=0)
    {
         int d=c;
        if(i>=0){
            d+=arr1[i];
        }
        if(j>=0){
            d+=arr2[j];
        }
        c=d/10;
        d=d%10;
        sum[k]=d;
        k--;
        i--;
        j--;
    }
    if(c!=0)
    {
        System.out.println(c);
    }
    for(int val:sum)
    {
        System.out.println(val);
    }
}

//=====================================================================


 public static void reverse(int[] a){
    // write your code here
    int li=0;
    int ri=a.length-1;
    while(li < ri)
    {
        int swap=a[ri];
        a[ri]=a[li];
        a[li]=swap;
        ri--;
        li++;
    }
  }

//==============================================================================

public static void CielFloor(int[] a , int d)
{
    int ciel=0,floor=0;
    for(int i=0;i<a.length;i++)
    {
        if(a[i]>d)
        {
            ciel=a[i];
            break;
        }else if(a[i]==d){
            ciel=a[i];
            break;
        }
        if(a[i]< d)
        {
            floor=a[i];
        }
    }
    System.out.println(ciel);
    System.out.println(floor);
}

//=================================================================================

public static void FirstLast(int[] a, int d)
{
    int FirstIndex=0,LastIndex=0;
    for(int i=0;i<a.length;i++)
    {
        if(a[i]==d)
        {
            FirstIndex=i;
            break;
        }
        if(a[a.length-1]!=d)
        {
            FirstIndex=-1;
        }
    }
    for(int i=a.length-1;i>0;i--)
    {
        if(a[i]==d)
        {
            LastIndex=i;
            break;
        }
        if(a[0]!=d)
        {
            LastIndex=-1;
        }
    }
    System.out.println(FirstIndex);
    System.out.println(LastIndex);
}

//=================================================================================

public static void FirstLast(int[] a, int data)
{
    int FirstIndex=-1,LastIndex=-1;
    int low=0,high=a.length-1,mid=0;
   while(low<=high)
   {
       mid=(low+high)/2;
       if(data>a[mid])
       {
           low=low+1;
       }
       else if(data<a[mid])
       {
           high=high-1;
       }
       else if(a[mid]==data)
       {
           FirstIndex=mid;
           high=high-1;
       }
   }
   System.out.println(FirstIndex);
   FirstIndex=-1;
   LastIndex=-1;
   low=0;
   high=a.length-1;
   while(low<=high)
   {
       mid=(low+high)/2;
       if(data>a[mid])
       {
           low=low+1;
       }
       else if( data<a[mid])
       {
           high=high-1;
       }
       else if(a[mid]==data)
       {
           LastIndex=mid;
           low=low+1;
       }
   }
   System.out.println(LastIndex);
}

//==============================================================================

public static void SubArray(int[] arr , int n)
{
    for(int i=0;i<n;i++)
    {
        for(int j=i;j<n;j++)
        {
            for(int k=i;k<=j;k++)
            {
                System.out.print(arr[k] + "\t");
            }
            System.out.println();
        }
    }
}
}