import java.util.ArrayList;
import java.util.LinkedList;

public class l002BST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int size(TreeNode root) {
        return root == null ? 0 : size(root.left) + size(root.right) + 1;
    }

    public static int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int Maximum(TreeNode root) {
        TreeNode curr = root;
        while (curr.right != null) // rightMost
            curr = curr.right;

        return curr.val;
    }

    public static int Minimum(TreeNode root) {
        TreeNode curr = root;
        while (curr.left != null) // leftMost
            curr = curr.left;

        return curr.val;
    }

    public static boolean find(TreeNode root, int data) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == data)
                return true;
            else if (curr.val < data)
                curr = curr.right;
            else
                curr = curr.left;
        }

        return false;
    }

    public static ArrayList<TreeNode> rootToNodePath(TreeNode root, int data) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        TreeNode curr = root;
        boolean flag = false;
        while (curr != null) {
            ans.add(curr);
            if (curr.val == data) {
                flag = true;
                break;
            } else if (curr.val < data)
                curr = curr.right;
            else
                curr = curr.left;
        }

        if (!flag)
            ans.clear();

        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        TreeNode curr = node;
        while (curr != null) {
            if (curr.val < p && curr.val < q)
                curr = curr.right;
            else if (curr.val > p && curr.val > q)
                curr = curr.left;
            else
                return curr;
        }

        return null;
    }

    class BSTIterator {

        private LinkedList<TreeNode> st = new LinkedList<>(); // addFirst, removeFirst

        public BSTIterator(TreeNode root) {
            addAllLeft(root);
        }

        private void addAllLeft(TreeNode node) {
            while (node != null) {
                this.st.addFirst(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode rnode = this.st.removeFirst();
            addAllLeft(rnode.right);

            return rnode.val;
        }

        public boolean hasNext() {
            return this.st.size() != 0;
        }
    }

    public static class allSoluPair {
        TreeNode pred = null;
        TreeNode succ = null;
        TreeNode prev = null;
    }


    public static void PreSuccBSt(TreeNode node, int data){

        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == data){
                if(curr.right != null){
                     succ = curr.right;
                }else{

                }
            }
            else if (curr.val < data)
                curr = curr.right;
            else
                curr = curr.left;
        }


    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null){
            return new TreeNode(val, null, null);
        }
        
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    
    }
    public int getMaximum(TreeNode root){
        while(root.right != null)
            root=root.right;
        
        return root.val;
    }
   
   

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
      
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else {
            if(root.left == null || root.right == null)
                return root.left == null ? root.right:root.left;
            
            int maximumData = getMaximum(root.left);
            root.val = maximumData;
            
            root.left = deleteNode(root.left, maximumData);
        }
        
        return root;  
    }

}