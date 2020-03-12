/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        
        int preOrderstart = pre[0];
        TreeNode root = new TreeNode(preOrderstart);
        if(pre.length == 1){
            return root;
        }
        root.left = root.right = null;
        int index = 0;
        while(index < in.length && root.val != in[index]){
            index++;
        }
        int leftlength = index;
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,leftlength+1),Arrays.copyOfRange(in,0,leftlength));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,leftlength+1,pre.length),Arrays.copyOfRange(in,leftlength+1,in.length));
        return root;

    }
}
//解法2
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode node=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return node;
    }
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
         
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);
        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                      break;
            }
        return root;
    }
}
