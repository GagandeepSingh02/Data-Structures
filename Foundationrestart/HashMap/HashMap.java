import java.util.LinkedList;
import java.util.ArrayList;
public class HashMap<k,V> {

    private class Node {
        K key = null;
        V value = null;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    @Override
    public String toString(){ //Syso pr yeh cheej mile
        return ("(" + key + " = " + value + ")"); //Yeh na hota toh address add krta neeche waala toString
    }
     
    }

    private LinkedList<Node>[] buckets;
    private int NoOFElements = 0;
    private int maxSizeOfBucket = 0;

    private void intialize(int size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }

        this.maxSizeOfBucket = size;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int sizeOfMap = this.NoOFElements;
        for(int i = 0; i < this.maxSizeOfBucket; i++){
            LinkedList<Node> group = this.buckets[i];
            int size = group.size();
            while(size-- > 0){
                sb.append(group.getFirst());
                if(sizeOfMap > 1) sb.append(",");
                group.addLast(group.removeFirst());
                sizeOfMap--;
            }
        }
        sb.append("]");
        return sb.toString();
    }
    public HashMap() {
        intialize(10);
    }

    public Integer size() {
        return this.NoOFElements;

    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
    private void rehash(){
        LinkedList<Node>[] temp = this.buckets;
        intialize((int)(2 * this.maxSizeOfBucket));
        for(int i = 0; i < temp.length; i++){
            LinkedList<Node> group = temp[i];
            int size = group.size();
            while(size-- > 0){
                Node node = group.removeFirst();
                put(node.key, node.value);           
            }
        }   
    }
    public void put(K key, V value) {
         LinkedList<Node> group = group(key);    
          boolean res = containsKey(key);
          if(res){
              group.getFirst().value = value;
          }else{
              Node node = new Node(key , value);
              group.addLast(node);
              this.NoOFElements++;

            double lamda = (0.4 * this.maxSizeOfBucket);
            if(group.size() >= lambda) 
               rehash();
          }
    }

    // if you found return value if not return null.
    public Integer get(Integer key) {
        boolean ispresent = containsKey(key);
         LinkedList<Node> group = group(key);
            if (ispresent)
                return group.getFirst().value;
        return null;
    }

    public Integer remove(Integer key) {
        boolean ispresent = containsKey(key);
         LinkedList<Node> group = group(key);
            if (ispresent){
                this.NoOFElements--;
                return group.removeFirst().value;
            }    
        return null;
    }

    public boolean containsKey(Integer key) {
        LinkedList<Node> group = group(key);
        int size = group.size();
        while (size-- > 0) {
            if (group.getFirst().key == key)
                return true;
            group.addLast(group.removeFirst());
        }

        return false;
    }
    private void allKeysOfGroup(LinkedList<Node> group,ArrayList<Integer> ans){
         int size = group.size();
         while(size-- > 0){
             ans.add(group.getFirst().key);
             group.addLast(group.removeFirst());
         }
    }
    public ArrayList<Integer> keySet() {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < maxSizeOfBucket;i++){
           allKeysOfGroup(this.buckets[i],ans);
        }
        return ans;
    }

    public Integer getOrDefault(Integer key, Integer defaultValue) {
        Integer value = get(key);
        if(value == null)
           return defaultValue;
        return value;
    }

    public void putIfAbsent(K key,V value) {
        boolean res = containsKey(key);
        if(!res) 
        put(key,value);

    }

    private LinkedList<Node> group(K key) {
        int groupNo = groupNo(key);
        return this.buckets[groupNo];
    }

    private Integer groupNo(K key) {
        Integer hc = Math.abs(key.hashCode());
        return hc % maxSizeOfBucket;
    }

}