//方法1 
public class Solution {
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
       // if(left == -1) return -1;
        int right = getDepth(root.right);
       // if(right == -1) return -1;
        return left>right?left+1:right+1;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int dif = left - right;
        if(dif > 1 || dif < -1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        
    }
}
//方法2
public class Solution {
    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        if(left == -1) return -1;
        int right = getDepth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) <= 1 ? 1 + Math.max(left, right) : -1;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
}
