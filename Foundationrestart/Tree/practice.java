public class practice{
    public static class isBSTSolPair{
        int minEle = (int)1e8;
        int maxEle = -(int)1e8;
        boolean isBST = true;
    }

    public static isBSTSolPair isBST_(Node node){

        if(node == null){
            return new isBalSolPair();
        }
        isBSTSolPair left = isBST_(node.left);
        isBSTSolPair right = isBST_(node.right);

        isBalSolPair myRes = new isBalSolPair();
        myRes.isBST = false;

        if(left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle){
            myRes.isBST = true;
            myRes.minEle = Math.min(left.minEle, node.data);
            myRes.maxEle = Math.max(right.maxEle, node.data);
        }

        return myRes;

    }

    public static class isBalPair{
        int height = -1;
        boolean balanceTree = true;
    }

    public static isBalPair isBal_(Node node){
        if(node == null){
            return new isBalPair;
        }

        isBalPair left = isBal_(node.left);
        if(!left.balanceTree) 
        return left;
        isBalPair right = isbal_(node.right);
         if(!right.balanceTree) 
         return right;
        isBalPair myRes = new isBalPair();
        myRes.balanceTree = false;

        if(left.balanceTree && right.balanceTree && Math.abs(left.height - right.height) <= 1){
            myRes.height = Math.max(left.height , right.height) + 1;
            myRes.balanceTree = true;

        }
        return myRes;

    }


    public static class totalBST{
        int largestBSTSize = 0;
        Node largestBSTNode = null;

        int totalNoOfBST = 0;
        isBST = true;
    }

    public static totalBST total(Node node){

        if(node == null){
            return new totalBST();
        }
        totalBST left = total(node.left);
        totalBST right = total(node.right);

        totalBST ans = new totalBST();
        totalBST.isBST = false;
         if(left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle){
            ans.totalNoOfBST += 1;
             ans.largestBSTNode = node;
             ans.isBST = true;
             ans.largestBSTSize += left.largestBSTSize + right.largestBSTSize;
         }

         return ans;
    }
}