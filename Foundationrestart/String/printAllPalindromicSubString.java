import java.util.Scanner;

public class printAllSubstring{
   public static Scanner scn= new Scanner(System.in);

    public static void isPalindrome(String str){
         boolean flag= true;
         int si=0 , ei=str.length()-1;
        while(si < ei){
            if(str.charAt(si) != str.charAt(ei)){
                flag=false;
                break;
            }
            si++;
            ei--;
        }
         if(flag == true)
         {
             System.out.println(str);
         }

    }
    public static void printAllPalindromicSubstring(String str){
        for(int i=0;i<str.length();i++)
        {
            for(int len=1;i+len<=str.length();len++){
                    isPalindrome(str.substring(i,i+len));
                 
            }
           
        }
        }
    
    public static void main(String[] args){
        String s= scn.next();
        printAllPalindromicSubstring(s);
    }
}