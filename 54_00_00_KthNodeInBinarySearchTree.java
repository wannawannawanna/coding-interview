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
//中序遍历，递归，借助ArrayList存储每次遍历到的节点
import java.util.ArrayList;
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>(); 
        if(pRoot == null || k <= 0){  //判断k <= 0
            return null;
        }
        KthNodeCore(pRoot, k, list);
        if(k > list.size()){  //还要判断k是不是大于所有节点数量
            return null;
        }
        return list.get(k - 1);
    }
    public void KthNodeCore(TreeNode pRoot, int k, ArrayList<TreeNode> list){
        if(pRoot == null){
            return;
        }
        if(pRoot.left != null){
            KthNodeCore(pRoot.left, k, list);
        }
        list.add(pRoot);
        if(pRoot.right != null){
            KthNodeCore(pRoot.right, k, list);
        }
    }
}


//也可以用二叉树非递归中序遍历
