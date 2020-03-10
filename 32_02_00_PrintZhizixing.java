import java.util.ArrayList;
import java.util.Stack;
/*
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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        if(pRoot == null){
            return res;
        }
        int current = 0;
        stack1.add(pRoot);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(current % 2 == 0){
                while(!stack1.isEmpty()){
                    TreeNode pCurrent = stack1.pop();
                    array.add(pCurrent.val);
                    if(pCurrent.left != null){
                        stack2.add(pCurrent.left);
                    }
                    if(pCurrent.right != null){
                        stack2.add(pCurrent.right);
                    }
                }
            }
            if(current % 2 != 0){
                while(!stack2.isEmpty()){
                    TreeNode pCurrent = stack2.pop();
                    array.add(pCurrent.val);
                    if(pCurrent.right != null){
                        stack1.add(pCurrent.right);
                    }
                    if(pCurrent.left != null){
                        stack1.add(pCurrent.left);
                    }
                }
            }
            res.add(array);
            current++;
            array = new ArrayList<Integer>();
        }
        return res;
    }
}
