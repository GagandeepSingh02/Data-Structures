import java.util.*;
  
  public class l002ABTD{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
      
   int ans=0 ,rem=0,multip=1;
		while(n!=0)
		{
			rem=n%10;
			ans=ans+(rem*multip);
			multip=multip*b;
			n=n/10;
		}
		return ans;
	}
  }