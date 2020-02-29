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
    // 递归
    // public void postOrder(TreeNode root, ArrayList<Integer> result){
    //     if(root == null){
    //         return ;
    //     }
    //     postOrder(root.left, result);
    //     postOrder(root.right, result);
    //     result.add(root.val);
    // }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     if(root == null){
    //         return res;
    //     }
    //     postOrder(root,res);
    //     return res;

    // }
    // 非递归1,我喜欢非递归1
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     LinkedList<Integer> res = new LinkedList<Integer>();
    //     if(root == null){
    //         return res;
    //     }
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         TreeNode node = stack.pop();
    //         res.addFirst(node.val);
    //         if(node.left != null){
    //             stack.push(node.left);
    //         }
    //         if(node.right != null){
    //             stack.push(node.right);
    //         }
    //     }
    //     return res;
    // }
    // 非递归2
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if(root == null){
            return res;
        }
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                res.addFirst(cur.val);
                cur = cur.right;
            }
            else{
                cur = stack.pop();
                cur = cur.left;
            }
        }
        return res;
    }
}
