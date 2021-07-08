import java.util.Scanner;
public class RunLengthEncodedString{
public static Scanner scn=new Scanner(System.in);

public static void main(String[] args){
    String str=scn.nextLine();
    compress1(str);
  }
public static String compress1(String str){
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<freq.length;i++){
            if(freq[i] > 0){
                sb.append((char)(i + 'a'));
                sb.append(freq[i]);
            }
        }
         return sb.toString();
      }
    }