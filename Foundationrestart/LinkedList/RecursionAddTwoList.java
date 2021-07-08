   public static int addTwoLists(Node node1, Node node2, int s1, int s2, LinkedList ans) {

        if (s1 == 0 && s2 == 0) {
            return 0;
        }

        if (s1 > s2) {
            int carry = addTwoLists(node1.next, node2, s1 - 1, s2, ans);
            int sum = carry + node1.data + 0;
            carry = sum / 10;
            ans.addFirst(sum % 10);
            return carry;

        } else {
            int carry = addTwoLists(node1.next, node2.next, s1 - 1, s2 - 1, ans);
            int sum = carry + node1.data + node2.data;
            carry = sum / 10;
            ans.addFirst(sum % 10);
            return carry;
        }
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {

        LinkedList ans = new LinkedList();

        int carry = 0;

        if (one.size() > two.size())
            carry = addTwoLists(one.head, two.head, one.size(), two.size(), ans);
        else
            carry = addTwoLists(two.head, one.head, two.size(), one.size(), ans);

        if (carry == 1) {
            ans.addFirst(1);
        }

        return ans;
    }

}