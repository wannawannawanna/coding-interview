// 一、
// 寻找二叉搜索树两个节点的最低公共祖先
// 事实上是在寻找第一个位于两个节点之间的一个节点
// 当前节点大于寻找的两个节点时, 最低公共祖先在左子树上,
// 反之, 在右子树上
// 若第一个介于两个搜索节点之间的节点已经找到, 该节点为两节点的最低公共祖先

//10,6,14,4,8,12,16,3,5一个二叉搜索树，3和8的最低公共祖先是6，从下往上找到的第一个公共父节点
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public static void getLastCommonNode(TreeNode pRoot, TreeNode pLeft, TreeNode pRight){  //pRight > pLeft
    TreeNode treeNode = null;
    if(pRoot == null || pLeft.val > pRight.val){
        return null;
    }
    if(pRoot.val >= pRight.val){
        treeNode = getLastCommonNode(pRoot.left, pLeft, pRight);
    }
    if(pRoot.val <= pLeft.val){
        treeNode = getLastCommonNode(pRoot.right, pLeft, pRight);
    }
    if(pRoot.val >= pLeft.val && pRoot.val <= pRight.val){
        return pRoot;
    }
    return treeNode;
}


//二、 普通的树, 寻找两节点的最低公共祖先, 树含有指向父节点的指针
// 转化为求两个链表的第一个共同节点，左旋转90度的Y，剑指offer第52题

// 三、
// 普通的树, 寻找两节点的最低公共节点, 树不含有指向父节点的指针
// 判断当前节点的子树中是否含有搜索的节点, 若某节点的子节点中含有待搜索的节点,
// 但其子节点内却不含有待搜索的节点, 则该节点即为最低公共祖先
// 缺点: 搜索存在重复


// 四、
// 普通的树, 寻找两节点的最低公共节点, 树不含有指向父节点的指针, 使用辅助内存
import java.util.ArrayList;
class TreeNode{
    int val;
    List<TreeNode> children = new ArrayList<TreeNode>();  //其左右子节点
    TreeNode(int val){
        this.val = val;
    }
}
public class Solution{
    public TreeNode getLastCommonParent(TreeNode pRoot, TreeNode p1, TreeNode p2){
        ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();//存储跟节点到目标节点1的路径
        ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();//存储跟节点到目标节点2的路径
        ArrayList<TreeNode> tmpList = new ArrayList<TreeNode>();//临时存储路径中的节点
        getNodePath(pRoot, p1, tmpList, path1); //获取路径中的节点
        getNodePath(pRoot, p2, tmpList, path2);
        if(path1.size() == 0 || path2.size() == 0){  //没有路径
            return null;
        }
        return getLastCommonParent(path1, path2);  //找两个路径中最后一个公共的节点
    }
    public void getNodePath(TreeNode pRoot, TreeNode pNode, ArrayList<TreeNode> tmpList, ArrayList<TreeNode> path){
        if(pRoot == null || pRoot == pNode){
            return;
        }
        tmpList.add(pRoot); //临时存储，递归添加所有到达目标节点时经过的节点
        ArrayList<TreeNode> childs = pRoot.children;  //左右子节点
        for(TreeNode node : childs){
            if(node == pNode){
                path.addAll(tmpList);  //将tmpList里面的所有节点添加到path中
                break;
            }
            getNodePath(node, pNode, tmpList, path);//递归找node的孩子节点判断时候是pNode
        }
        tmpList.remove(tmpList.size() - 1);  //清空tmpList,因为找两个目标节点的路径的时候都用tmpList，所以不清空对第二个目标节点有影响
    }
    public TreeNode getLastCommonParent(ArrayList<TreeNode> path1, ArrayList<TreeNode> path2){
        TreeNode tmpNode = null;
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
            tmpNode = path1.get(i);  //记录的是两个目标节点路径中的最后一个公共节点
        }
        return tmpNode;
    }
}
