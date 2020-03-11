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
    String Serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);
        return sb.toString();
    }
    void Serialize2(TreeNode pRoot, StringBuilder sb){
        if(pRoot == null){
            sb.append("#,");
            return;
        }
        sb.append(pRoot.val);
        sb.append(",");
        Serialize2(pRoot.left, sb);
        Serialize2(pRoot.right, sb);
    }
    TreeNode Deserialize(String str) {
        if(str.length() == 0){
            return null;
        }
        String[] strs = str.split(",");
        return Deserialize2(strs);
    }
    int index = -1;
    TreeNode Deserialize2(String[] str){
        index++;
        if(!str[index].equals("#")){ // ==：比较的是两个字符串内存地址（堆内存）的数值是否相等，属于数值比较；
// equals()：比较的是两个字符串的内容，属于内容比较。
//以后进行字符串相等判断的时候都使用equals()。
            TreeNode root = new TreeNode(Integer.valueOf(str[index]));
            root.left = Deserialize2(str);
            root.right = Deserialize2(str);
            return root;
        }
        return null;
    }
}
