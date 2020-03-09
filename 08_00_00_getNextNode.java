/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;  //next节点是父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null){
            return null;
        }
        TreeLinkNode pCurrent = pNode;
        TreeLinkNode pNext = null;
        if(pCurrent.right != null){ //有右子树的情况下，每个根结点的下一节点是其右子树的最左子节点
            pNext = pCurrent.right;
            while(pNext.left != null){
                pNext = pNext.left;
            }
            return pNext;
        }
        while(pCurrent.next != null){ //没有右子树，分两种，如果当前节点是左子节点的话，其下一个节点是其父节点，
        //如果当前节点是右子节点，向上找父节点，直到找到一个节点是其父节点的左子节点
            TreeLinkNode proot = pCurrent.next;
            if(proot.left == pCurrent){
                return proot;
            }
            pCurrent = proot;
        }
        return null;
    }
}
