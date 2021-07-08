import java.util.*;

public class Main {
    public static List < List < Integer >> permute(int[] nums) {
        return helper(nums, nums.length, nums.length);
    }

    private static List < List < Integer >> result = new ArrayList < List < Integer >> ();

    private static List < List < Integer >> helper(int[] nums, int n, int k) {
        if (k == 1) {
            List < Integer > list = new ArrayList < > ();
            for (int i = 0; i < n; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        }

        for (int i = 0; i < k; i++) {
            int tmp = nums[i];
            nums[i] = nums[k - 1];
            nums[k - 1] = tmp;

            helper(nums, n, k - 1);
            tmp = nums[i];
            nums[i] = nums[k - 1];
            nums[k - 1] = tmp;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        System.out.println(permute(ar));

    }

}