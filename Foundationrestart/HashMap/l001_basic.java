import java.util.HashMap;
import java.util.ArrayList;
public class l001_basic {

    public static void basic_01() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Nepal", 233);
        map.put("UK", 45);
        map.put("Germany", 35);
        map.put("USA", 20);
        map.put("Russia", 18);
        map.put("India", 10);
        map.put("USA", 19);

        System.out.println(map);
        for(String keys : map.keySet()){
        System.out.println(keys + " -> " + map.get(keys));
        }

        String key = "USA";
        if (map.containsKey(key))
        System.out.println(map.get(key));
        else
        System.out.println("not Found");

    }

    public static void printFrequency(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < str.length(); i++) {
        // char ch = str.charAt(i);
        // if (map.containsKey(ch))
        // map.put(ch, map.get(ch) + 1);
        // else
        // map.put(ch, 1);
        // }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    }

     public static void  highestFrequencyCharcter(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
            char ans =' ';
            int freq = 0;
            for(Character ch : map.keySet()){
                if(map.get(ch) > freq){
                    freq = map.get(ch);
                    ans = ch;
            }
        }
        System.out.println(ans);
    }

    public static void positionOfAllCharacters(String str){
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i =0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch))
            map.put(ch,new ArrayList<>());
            map.get(ch).add(i);
        }
        System.out.println(map);

    }

        //Second Way
        public static void positionOfAllCharactersSec(String str){
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        for(int i =0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.putIfAbsent(ch,new ArrayList<>());
            map.get(ch).add(i);
        }
        for(Character ch : map.keySet()){
        System.out.println(ch + "->" +map.get(ch));
        }
    }
    public static void intersectionOfTwoArrayWithoutDuplicates(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : arr1){
            map.put(ele,map.getOrDefault(ele , 0) + 1);
        }
        for(int ele : arr2){
            if(map.containsKey(ele)){
                System.out.println(ele);
                map.remove(ele)
            }
        }

    }
    public static void intersectionOfTwoArrayWithDuplicates(int[] a1, int[] a2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : a1) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for(int ele : a2){
            if (map.containsKey(ele)) {
                System.out.println(ele);
                map.put(ele, map.get(ele) - 1);
                if(map.get(ele) == 0) map.remove(ele);
            }
            

        }
    }

    }
    public static void main(String[] args) {
        String str = "abcabcdddcacac";
        positionOfAllCharactersSec(str);

    }

} 