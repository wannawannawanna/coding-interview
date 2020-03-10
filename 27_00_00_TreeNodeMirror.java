/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Stack;
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }
    public void Mirror(TreeNode root) {  //我用的栈，所以是深度的，也可以用队列，是广度的
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode pCurrent = stack.pop();
            if(pCurrent.left != null){
                stack.add(pCurrent.left);
            }
            if(pCurrent.right != null){
                stack.add(pCurrent.right);
            }
            TreeNode pTemp = pCurrent.left;
            pCurrent.left = pCurrent.right;
            pCurrent.right = pTemp;
        }
    }
}
