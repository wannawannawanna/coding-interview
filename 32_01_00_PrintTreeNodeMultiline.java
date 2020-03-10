import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        if(pRoot == null){
            return res;
        }
        int ToBePrinted = 1; //记录当前层剩余打印的节点数
        int nextLength = 0;  //记录下一层总节点数
        que.add(pRoot);
        while(!que.isEmpty()){
            TreeNode pCurrent = que.pop();
            array.add(pCurrent.val);
            if(pCurrent.left != null){
                que.add(pCurrent.left);
                nextLength++;
            }
            if(pCurrent.right != null){
                que.add(pCurrent.right);
                nextLength++;
            }
            ToBePrinted--;
            if(ToBePrinted == 0){
                ToBePrinted = nextLength;
                nextLength = 0;
                res.add(array);
                array = new ArrayList<Integer>();
                
            }
        }
        return res;
    }
    
}
