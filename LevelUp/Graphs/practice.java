import java.util.ArrayList;
public class practice{
    public static TreeNode constructtreefrominandlevel(int inorder[],int isi,int iei,int levelorder[],int lsi,int lei){
                if(isi>iei) return null;
        
                TreeNode root=new TreeNode(levelorder[lsi]);
                int idx=isi;
                while(inorder[idx]!=levelorder[lsi]){
                    idx++;
                }
                HashSet<Integer> map=new HashSet<>();
                for(int i=isi;i<idx;i++){  //adding the elem of inorder to hashmap which need to be in left
                    map.add(inorder[i]);
                }
                // System.out.println(map);
                int leftlevelorder[]=new int[map.size()];
                int rightlevelorder[]=new int[levelorder.length-map.size()-1];
                int idx1=0;int idx2=0;
        
                for(int i=lsi+1;i<levelorder.length;i++){
                    if(map.contains(levelorder[i])) leftlevelorder[idx1++]=levelorder[i];
                    else rightlevelorder[idx2++]=levelorder[i];
                }
                root.left=constructtreefrominandlevel(inorder,isi,idx-1,leftlevelorder,lsi,leftlevelorder.length-1);
                root.right=constructtreefrominandlevel(inorder,idx+1,iei,rightlevelorder,lsi,rightlevelorder.length-1);
                return root;
            }
        
   
}