/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 import java.util.*;
class Solution {
    // public void inOrder(TreeNode root, ArrayList<Integer> result){
    //     if(root == null){
    //         return ;
    //     }
    //     inOrder(root.left,result);
    //     result.add(root.val);
    //     inOrder(root.right,result);
    // }
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     if(root == null){
    //         return new ArrayList<Integer>();
    //     }
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     inOrder(root, res);
    //     return res;
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){  //对于当前节点一直找左子节点，直到找不到为止
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){  //没有左子节点，可以出栈，这时候栈顶元素是一个子树中的根结点
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
