//二叉搜索树的左子树比根结点小，右子树比根结点大，所以可以用递归，中序遍历
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
    TreeNode pLast = null;   //全局的一个结点，指向双向链表的尾结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertNode(pRootOfTree);
        //需要返回头结点，因为最初返回的是尾结点，所以要一直向前找left结点
        TreeNode pHead = pLast;
        while(pHead != null && pHead.left != null){
            pHead = pHead.left;
        }
        return pHead;
    }
    public void ConvertNode(TreeNode pNode){
        if(pNode == null){
            return;
        }
        TreeNode pCurrent = pNode;
        //寻找最左子节点
        if(pCurrent.left != null){
            ConvertNode(pCurrent.left);
        }
        
        pCurrent.left = pLast;  //反向指针
        if(pLast != null){
            pLast.right = pCurrent;  //前向指针
        }
        pLast = pCurrent;
        if(pCurrent.right != null){
            ConvertNode(pCurrent.right);
        }
    }
}
