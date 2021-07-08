import java.util.*;

public class l004{
public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

 //===========================================================================   

    public static int getDigitFrequency(int n, int d) {
        // write code here
        int num=n,rem=0,count=0;
         while(num>0)
         {
             rem=num%10;
             if(rem==d) count++;
             num=num/10;
             
         }
         return count;
         
    }

 //============================================================================


    public static void main(String[] args) throws Exception {
    // write your code here
    int n1=scn.nextInt();
    int[] arr= new int[n1];
    for(int i=0;i<n1;i++)
    {
        arr[i]=scn.nextInt();
    }
    int n2=scn.nextInt();
    int[] arr2=new int[n2];
    for(int i=0;i<n2;i++)
    {
        arr2[i]=scn.nextInt();
    }
     SumArray(arr,arr2,n1,n2);
}

public static void SumArray(int[] arr1 ,int[] arr2,int n1,int n2)
{
    int[] sum=new int[n1>n2? n1+1:n2+1];
    int i=arr1.length-1;
    int j=arr2.length-1;
    int k=sum.length-1;
    int c=0;
    while(k>=0)
    {
         int d=c;
        if(i>=0){
            d+=arr1[i--];
        }
        if(j>=0){
            d+=arr2[j--];
        }
        c=d/10;
        d=d%10;
        sum[k]=d;
        k--;
    }
    for(int p=0;p<sum.length;p++)
    {
        if(sum[0]==0 && p==0) continue;
        
        System.out.println(sum[p]);
    }
}

//==========================================================================

public static void DiffArray(int[] arr1,int[] arr2)
{
    int borrow=0;
    int[] diff=new int[arr2.length];
    int k=diff.length-1;
    int i=arr2.length-1;     // Kyuki array2 bda h given in question
    int j=arr1.length-1;
    while(k>=0)
    {
        int num=borrow;
        if(i>=0) num+=arr2[i--];
        if(j>=0) num-=arr1[j--];
        if(num<0)
        {
            num=num+10;
            borrow=-1;
        }
        else borrow=0;
        
        diff[k--]=num;
    }
    boolean flag= false;
    for(int p=0;p<diff.length;p++)
    {
        if(flag==false && diff[p]==0) continue;
        
        System.out.println(diff[p]);
        flag=true;
    }
}
//======================================================

public static void subarray(int[] a)
{
    for(int i=0;i<a.length;i++)
    {
        for(int j=i;j<a.length;j++)
        {
            for(int k=i;k<=j;k++)
        {
            System.out.print(a[k]+"\t");
        }
        System.out.println();
        }
    }
}
//======================================================

 public static int[] inverse(int[] a){
    // write your code here
    int n=a.length;
    int[] ans= new int[n];
    for(int i=0;i<n;i++)
    {
        ans[a[i]]=i;
    }
    return ans;
  }
  //=====================================================
  public static int max(int[] arr)
{
   int max= (int)-1e8; 
   for(int i=0;i<arr.length;i++)
   {
       if(arr[i]>max) max=arr[i];
   }
   return max;
}
 
 //==============================================

public static void BarChart(int[] a)
{
     int max=max(a);
    for(int floor=max; floor>=1;floor--)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>=floor)
            {
                System.out.print("*\t");
            }else{
                   System.out.print("\t");
            }
        }
        System.out.println();
    }
    
}
}