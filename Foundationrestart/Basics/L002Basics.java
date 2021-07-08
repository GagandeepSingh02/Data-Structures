import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {


        // write ur code here
        int t = scn.nextInt();
        checkPrime(t);

    }
    public static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void checkPrime(int t) {
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            if (isprime(n)) System.out.println("prime");
            else System.out.println("not prime");
        }

public static void checkPrimeTillN(int low,int high) {
        for (int i = low; i <=high; i++) {
            if (isprime(i)) System.out.println(i);
        }

    }
//=======================================================================================================

 public static void Fibonnaci(int n) {
        int a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(a);
            sum = a + b;
            a = b;
            b = sum;
        }
    }

//=================================================================================================

    public static int count(int num)
 {
     int count=0;
     while(num != 0)
     {
         num=num/10;
         count++;
     }
     return count;
 }
}