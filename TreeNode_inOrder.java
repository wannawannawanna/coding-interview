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
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
