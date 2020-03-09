import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;
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
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return array;
        }
        queue.add(root);
        while(queue.size() != 0){
            TreeNode pCurrent = queue.pop();
            array.add(pCurrent.val);
            if(pCurrent.left != null){
                queue.add(pCurrent.left);
                
            }
            if(pCurrent.right != null){
                queue.add(pCurrent.right);
                
            }
        }
        return array;
    }
}
