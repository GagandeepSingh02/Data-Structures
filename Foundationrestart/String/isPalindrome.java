import java.util.Scanner;
public class isPalindrome{
    public static Scanner scn= new Scanner(System.in);
    public static boolean isPalindrome(String str){
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
        return flag;

    }
    
    public static void main(String[] args){
        String s= scn.next();
        System.out.println(isPalindrome(s));
    }
}