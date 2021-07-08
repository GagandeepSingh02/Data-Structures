import java.util.*;
  
  public class l001DTAB{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int no,int sb)
	{
		int ans=0 ,rem=0,multip=1;
		while(no!=0)
		{
			rem=no%sb;    //Here we want to covert the number in base 5
			ans=ans+(rem*multip);
			multip=multip*10;
			no=no/sb;
		}
		return ans;

}
  }