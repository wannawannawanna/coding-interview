import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        int current = 0;
        FindPath(root, arr, res, target, current);
        return res;
    }
    public void FindPath(TreeNode root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> res, int target, int current){
        if(root == null){
            return;
        }
        current += root.val;
        arr.add(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if(current == target && isLeaf){
            res.add(new ArrayList<Integer>(arr));
            arr.remove(arr.size()-1);
            return;
        }
        if(root.left != null){
            FindPath(root.left, arr, res, target, current);
        }
        if(root.right != null){
            FindPath(root.right, arr, res, target, current);
        }
        arr.remove(arr.size()-1);
       // current -= root.val;
        
    }
}
