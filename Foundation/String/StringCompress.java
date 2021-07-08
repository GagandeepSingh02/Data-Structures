import java.util.Scanner;
public class StringCompress{
public static Scanner scn=new Scanner(System.in);

public static void main(String[] args){
    String s=scn.nextLine();
    System.out.println(Compress(s));
   }
 public static String Compress(String str){
        if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        
        char prevChar = str.charAt(0);
        int i = 1;
        while(i <= str.length()){
            int count = 1;
            while(i < str.length() && prevChar == str.charAt(i)){
                  count++;
                  prevChar = str.charAt(i);
                  i++;
            }

            sb.append(prevChar);
            sb.append(count);
            if(i == str.length()) break;
            prevChar = str.charAt(i);
            i++;
        } 

        return sb.toString();
    }
}
}