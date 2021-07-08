import java.util.Scanner;
public class client{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        HashMap map = new HashMap();
        for(int i = 0; i < 40; i++){
            int a = scn.nextInt();
            map.put(a,map.getOrDefault(a,0) + 1);
        }
        System.out.println(map.get(1));
        System.out.println(map);
        
    }
}