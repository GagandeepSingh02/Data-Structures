import java.util.Scanner;
public class l001Basics{
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args)
    {
        int a=scn.nextInt();
        // int b=scn.nextInt();
        // System.out.println(subtract(a,b));
        // System.out.println(divide(a,b));
        // System.out.println(multiply(a,b));
        // System.out.println(add(a,b));
        // printmessage();
        //printTableTillM(a);
        for(int i=0;i<a;i++)
        {
            int n=scn.nextInt();
            oddeven(n);
        }
    }
public static int subtract(int a,int b)
{
    int c = b - a;
    return c;
}

public static int divide(int a,int b)
{
    int c = b / a;
    return c;
}

public static int multiply(int a,int b)
{
    int c = a * b;
    return c;
}

public static int add(int a,int b)
{
    int c = a + b;
    return c;
}
public static void printmessage(){
   System.out.println("See you soon!"); 
}
//==============================================================================

public static void printTableOfN(int n)
{
    for(int i=1;i<=10;i++)
    {
        System.out.println(n +" X "+ i+" = " + n*i);
    }
}
public static void printTableTillM(int m)
{
    for(int i=1;i<=m;i++)
    {
        printTableOfN(i);
        System.out.println();
    }
}

//=================================================================================

public static void oddeven(int n)
{
        if(n % 2 == 0)
            System.out.println("even");
        else{
            System.out.println("odd");
        }
}
}