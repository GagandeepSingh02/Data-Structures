import java.io.*;
import java.util.*;

public class diffConsecutiveString  {

    public static String solution(String str) {
        // write your code here
        if(str.length() <= 1) return str;
        StringBuilder sb= new StringBuilder();
        sb.append(str.charAt(0));
        for(int i=1;i<str.length();i++)
        {
            char prev=str.charAt(i-1);
            char curr=str.charAt(i);
            sb.append(curr-prev);
            sb.append(curr);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}