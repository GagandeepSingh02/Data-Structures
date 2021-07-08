import java.util.Scanner;

public static Scanner s=new Scanner(System.in);
public static void main( String[] args){
    int marks=s.nextInt();
    int n=s.nextInt();
     printz();
    gradingSystem(marks);
    oddeven(n);
}
public static void printz(){
    System.out.println("*****");
    System.out.println("   *");
    System.out.println("  *");
    System.out.println(" *");
    System.out.println("*****")


public static void gradingSystem(int n){
    if(n>90){
        System.out.println("excellent");
    }else if(n> 80 && n<=90){
        System.out.println("good");
    }else if(n>70 && n<=80){
        System.out.println("fair");
    }else if(n>60 && n<=70){
        System.out.println("meets expectation");
    }else{
        System.out.println("below par");s
    }
}

public static void oddeven(int n){
    if(n%2==0){
        System.out.println("even number");
    }else{
        System.out.println("odd");
    }
}

public static boolean isprime_(int n)
{
    boolean prime=true;
    for(int i=2;i*i<=n;i++ )
    {
        if(n%i==0){
          prime=false;
          break;
        }
    }
    return prime;
}
public static void isprime(int n){
    if(isprime_(n)){
        System.out.println("prime");
    }else{
        System.out.println("not prime");
    }
}
public static void fibonacci(int n){
       int a=0,b=1,sum=0;
       for(int i=1;i<=n;i++)
       {
           System.out.println(a);
          sum=a+b;
          a=b;
          b=sum;
           
       }
   }

    public static int countDigit(int n)
   {
       int count=0;
       int num=n;
       while(num>0)
       {
           num=num/10;
           count++;
       }
       System.out.println(count);
   }

   public static int rotateDigit(int n ,int r)
   {
       int len=countDigit(n);
       r%=len;
       if(r<0)r=(r+len)%len;    //Modulus Formula to covert negative mod to its positive equivalent
       int div=1,mul=1;
       for(int i=0;i<len;i++)
       {
           if(i<r)div*=10;    //Yha bas mai apna khud ka power function bnare hu
           else mul*=10;
       }
       int a=n%div;
       int b=n/div;

       return a*mul+b;
   }
   public static void ReverseNumber(int n)
   {
       int num=n;
       int rem=0;
       while(num!=0)
       {
           rem=num%10;
           num=num/10;
             System.out.println(rem);
       }
      
   }
   public static int countDigit(int n)
   {
       int count=0;
       int num=n;
       while(num>0)
       {
           num=num/10;
           count++;
       }
       return count;
   }
   
   public static void DigitNumber(int n){
       int len=countDigit(n);
       int div=1;
       while(len>1){
           div*=10;
           len--;
       }
       while(div!=0)
       {
          System.out.println(n/div);
          n=n%div;
          div=div/10;
       }
   }
   public static void InverseNumber(int n){
       int digit=0;
       int result=0;
       int i=1;
       while(n!=0)
       {
           digit=n%10;
           n=n/10;
           result=result+i*(int)Math.pow(10,digit-1);
           i++;
       }
       System.out.println(result);
   }
   public static int gcd(int a ,int b)
   {
       int divisor =a;
       int dividend=b;
       while(dividend % divisor !=0)
       {
           int rem=dividend%divisor;
           dividend=divisor;
           divisor=rem;
       }

       System.out.pritnln(divisor);
       int lcm=(a/divisor)*b;
       return lcm
   }
}