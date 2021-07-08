import java.util.Scanner;
public class printAllSubstring{
    public static Scanner scn= new Scanner(System.in);
    public static void printAllSubstring(String str){
        for(int i=0;i<str.length();i++)
        {
            for(int len=1;i+len<=str.length();len++){
                 System.out.println(str.substring(i,i+len));
            }
           
        }
        }
    
    public static void main(String[] args){
        String s= scn.next();
        printAllSubstring(s);
    }
}