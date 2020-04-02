//二叉搜索树，根结点比左子节点大，比右子节点小
//所以数组的最后一个元素是二叉树的跟节点，数组前面的一部分数据（比根结点值小的一部分数据）是左子树，数组的后面一部分数据（比跟节点值大的数据）是右子树
//然后可以用递归，

//最好还是用begin和end，不要用剑指上的length
public class Solution {
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        int length = sequence.length;
        return VerifySequenceOfBSTCore(sequence, 0, length - 1);
        
    }
    public boolean VerifySequenceOfBSTCore(int[] sequence, int begin, int end){ 
        int root = sequence[end]; //根结点
        System.out.println("root :" + root);
        int i = begin; //找左子树
        for(; i < end; i++){ //如果有某个数比根结点大，那么久改属于右子树，直接跳出
            if(sequence[i] > root){
                break;
            }
        }
        int j = i;  //找右子树
        for(; j < end; j++){ //如果再右子树中找到比根结点小的值，那么返回false，说明不是一个二叉搜索树的后续遍历
            if(sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if(i > begin){
            left = VerifySequenceOfBSTCore(sequence, begin, i - 1);
        }
        boolean right = true;
        if(i <= end - 1){
            right = VerifySequenceOfBSTCore(sequence, i, end - 1);
        }
        return (left && right);
    }
    
}
