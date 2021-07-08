import java.util.Random;

public class quickSortLL {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    
    public static ListNode sortList(ListNode head) {
         return quickSort(head)[0];
    }
}