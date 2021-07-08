import java.util.*;
  
  public class SumAnybase{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
   public static int getSum(int b, int n1, int n2){
       // write ur code here
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
  }