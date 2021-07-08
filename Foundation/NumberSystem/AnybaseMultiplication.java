import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }
 

 public static int getProduct(int b, int n1, int n2){
     // write your code here
     int r1=0,pow=1,res1=0,res=0,carry=0,sum=0;
      while(n1 !=0)
      {
          r1=n1%10;
          n1/=10;
          res1=multiply(r1,n2,b,pow);
          res=SumAnybase(res1,res,b);
          pow=pow*10;
      }
      return res;
 }
 public static int SumAnybase(int n1,int n2,int b)
 {
    int sum=0,res=0,r1=0,r2=0,carry=0,pow=1;
       while(n1 !=0 || n2 !=0 || carry !=0)
       {
           r1=n1%10;
           r2=n2%10;
           n1/=10;
           n2/=10;
           sum=r1+r2+carry;
            int r=sum%b;
            carry=sum/b;
            res+=r*pow;
            pow=pow*10;
            
       }
       return res;
 }
 public static int multiply(int r1,int n2,int b, int pow)
 {
     int carry=0,r2=0,multip=0,res1=0,m=0;
     while(n2!=0 || carry!=0)
     {
         r2=n2%10;
         n2/=10;
         m=r2*r1+carry;
         multip=m%b;
         carry=m/b;
         res1+=multip*pow;
         pow=pow*10;
     }
     return res1;
 }
}