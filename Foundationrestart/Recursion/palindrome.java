import java.io.*;
import java.util.*;

public class Solution {
public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n=scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<arr.length;i++)
        {
          arr[i]=scn.nextInt();
        }
        System.out.println(arrayPalindrome(arr,0));
    
}
     public static boolean arrayPalindrome(int[] arr ,int idx)
{
    if(idx == arr.length/2) return true;
    if(arr[idx] != arr[arr.length-1-idx]) return false;
     return arrayPalindrome(arr,idx+1);     
     }
}