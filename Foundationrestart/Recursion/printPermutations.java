import java.util.*;

public class Main {
    public static ArrayList < ArrayList < Integer >> getPermutation(ArrayList < Integer > ints) {

        //Write your code here.
        if (ints.size() == 1) {
            ArrayList < ArrayList < Integer >> list = new ArrayList < > ();
            list.add(ints);
            return list;
        } else {
            ArrayList < ArrayList < Integer >> list = new ArrayList < > ();
            for (Integer i: ints) {
                ArrayList < Integer > subList = new ArrayList < > (ints);
                subList.remove(i);
                ArrayList < ArrayList < Integer >> subListNew = getPermutation(subList);
                for (ArrayList < Integer > list1: subListNew) {
                    ArrayList < Integer > ar = new ArrayList < > ();
                    ar.add(i);
                    ar.addAll(list1);
                    list.add(ar);
                }
            }
            return list;
        }
    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList < Integer > ar = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            ar.add(s.nextInt());
        }
        System.out.println(getPermutation(ar));

    }

}