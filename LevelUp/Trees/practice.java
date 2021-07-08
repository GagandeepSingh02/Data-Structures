public class practice{
      public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static void widthOfShadow(TreeNode node, int vl, int[] minMax) {
        if (node == null)
            return;
        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);
        widthOfShadow(node.left, vl - 1, minMax);
        widthOfShadow(node.right, vl + 1, minMax);
    }

    public static class vPair{
        TreeNode node = null;
        int vl = 0;
        vPair(TreeNode node, int vl){
            this.node = node;
            this.vl = vl;
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrder(TreeNode root){
       LinkedList<vPair> que = new LinkedList();
       int[] minMax = new int[2];
       widthOfShadow(root, 0, minMax);
       int len = minMax[1] - minMax[0] + 1;

       que.addLast( new vPair(root, Math.abs(minMax[0])));
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       for(int i = 0; i < len; i++) ans.add(new ArrayList<>());

       while(que.size() != 0){
           int size = que.size();

           while(size-- > 0){
               vPair rp = que.removeFirst();
               int vl = rp.vl;
               TreeNode rnode = rp.node;
               ans.get(vl).add(node.val);

               if(rnode.left != null){
                   que.addLast(new vPair(rnode.left, vl - 1));
               }
               if(rnode.right != null){
                   que.addLast(new vPair(rnode.right, vl + 1));
               }
           }

       }

        return ans;
    }

    public static ArrayList<Integer> topView(TreeNode root){
       LinkedList<vPair> que = new LinkedList();
       int[] minMax = new int[2];
       widthOfShadow(root, 0, minMax);
       int len = minMax[1] - minMax[0] + 1;

       que.addLast( new vPair(root, Math.abs(minMax[0])));
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i = 0; i < len; i++) ans.add(null);

       while(que.size() != 0){
           int size = que.size();

           while(size-- > 0){
               vPair rp = que.removeFirst();
               int vl = rp.vl;
               TreeNode rnode = rp.node;
              if(ans.vl == null){
                   ans.set(vl, rnode.val);
              }

               if(rnode.left != null){
                   que.addLast(new vPair(rnode.left, vl - 1));
               }
               if(rnode.right != null){
                   que.addLast(new vPair(rnode.right, vl + 1));
               }
           }

       }

        return ans;
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        que.addLast(root);

        while(que.size() != 0){
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();

            while(size-- > 0){
                TreeNode node = que.removeFirst();

                while(node != null){
                   smallAns.add(node.val);
                   if(node.left != null){
                       que.addLast(node.left);
                   }
                   node = node.right;
                }
            }
            ans.add(smallAns);
        }
        return ans;

    }

    public static void widthOfShadow(TreeNode root, int vl, int[] minMax){
        if(root == null) return;

        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);

        widthOfShadow(root.left , vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);

    }
    public static void widthOfShadow(Node root, int vl, int[] minMax){
        if(root == null) return;

        minMax[0] = Math.min(minMax[0], vl);
        minMax[1] = Math.max(minMax[1], vl);

        widthOfShadow(root.left , vl - 1, minMax);
        widthOfShadow(root.right, vl + 1, minMax);

    }
     public static ArrayList<Integer> verticalSum(Node root) {
        LinkedList<vPair> que = new LinkedList<>();
        int[] minMax = new int[2];
        widthOfShadow(root, 0, minMax);
        int len = minMax[1] - minMax[0] + 1;

        que.addLast(new vPair(root, Math.abs(minMax[0])));

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++)
            ans.add(0);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                vPair rp = que.removeFirst();
                int vl = rp.vl;
               Node node = rp.node;

                ans.set(vl, ans.get(vl) + node.data);

                if (node.left != null)
                    que.addLast(new vPair(node.left, vl - 1));
                if (node.right != null)
                    que.addLast(new vPair(node.right, vl + 1));
            }
        }

        return ans;
    }


    public static ArrayList<Integer> diagonalSum(TreeNode root){
        LinkedList<TreeNode> que = new LinkedList();
        ArrayList<Integer> ans = new ArrayList;
        que.addLast(root);
        
        while(que.size() != 0){
            int size = que.size();
            int sum = 0;
            while(size-- > 0){
                TreeNode rnode = que.removeFirst();
                while(rnode != null){
                    sum += rnode.val;
                    if(rnode.left != null){
                        que.addLast(rnode.left);
                    }

                    rnode = rnode.right;
                }
            }
            ans.add(sum);
        }
        return ans;
    }

    public static class ListNode {
        int data = 0;
        ListNode prev = null;
        ListNode next = null;

        ListNode(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> verticalSum(Node root, ListNode data){
        node.data = root.data;
        if(root.left != null){
            if(node.prev == null){
              ListNode nnode = new ListNode();
              node.prev = ;
              node.next = ;
            }
        }
    }
}