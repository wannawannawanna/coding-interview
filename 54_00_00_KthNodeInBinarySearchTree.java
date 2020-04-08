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
        if(list.size() == k){
            return;
        }
        if(pRoot.right != null){
            KthNodeCore(pRoot.right, k, list);
        }
    }
}


//也可以用二叉树非递归中序遍历
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
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>(); 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(pRoot == null || k <= 0){  //判断k <= 0
            return null;
        }
        TreeNode pNode = pRoot;
        while(pNode != null || !stack.isEmpty()){
            while(pNode != null){  //一直找当前节点的左子树，找不到之后出栈，加入结果集里
                stack.push(pNode);
                pNode = pNode.left;
            }
            if(!stack.isEmpty()){
                pNode = stack.pop();  //返回栈顶元素作为当前节点，然后指向他的右子树，然后一直找他的左子树
                list.add(pNode);  //说明是根结点
                if(list.size() == k){
                    break;
                }
                pNode = pNode.right;
                
            }
        }
        if(k > list.size()){  //还要判断k是不是大于所有节点数量
            return null;
        }
        return list.get(k - 1);
    }
    
}
