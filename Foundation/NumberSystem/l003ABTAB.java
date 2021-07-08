import java.util.*;
  
  public class l003ABTAB{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     System.out.println(anybaseToAnybase(n,sourceBase,destBase));
   }   
   
   public static int anybaseToAnybase(int n, int b1 , int b2)
  
  {
      int res=0,pow=1,rem=0;
      while(n!=0)
      {
          rem=n%10;
          res+=rem*pow;
          pow=pow*b1;
          n=n/10;
      }
      int no =res;
      rem=0;
      	int ans=0 ,multip=1;
		while(no!=0)
		{
			rem=no%b2;
			ans=ans+(rem*multip);
			multip=multip*10;
			no=no/b2;
		}
		return ans;
  }
  }