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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
       
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){   //val是int型，剑指offer上是double类型，不能用==号，需要自己写Equal函数
                result = DoesTree1HaveTree2(root1, root2);
            }
            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if(!result){
                result = HasSubtree(root1.left, root2);                
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
            
        }
        return result;
    }
    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2){
        //如果Tree2已经遍历完了都能对应的上，返回true
        if(root2 == null){
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false,这句一定要写在root2判断的后面，或者要自己写if(root1 == null && root2 != null)
        if(root1 == null){
            return false;
        }  
        if(root1.val != root2.val){
            return false;
        }
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
    public boolean Equal(double a, bouble b){ //bouble类型判断相不相等
        if(Math.abs(a,b) <= 0.0000001){
            return true;
        }
        else{
            return false;
        }
    }
}
