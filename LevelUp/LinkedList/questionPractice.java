public class questionPractice{
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    } 

    public static ListNode mid(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        } 
        return prev;
    }

    public static ListNode fold(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode mid = mid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        ListNode c1= head, c2 = head2, f1 = null, f2 = null;
        while(c2 != null){
            f1 = c1.next;
            f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
        return head;
    }
}