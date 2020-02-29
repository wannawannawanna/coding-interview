package Offer;
import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val = val;
	}
}

public class PreorderReverse {
////	递归法
//	void preOrder(TreeNode root, ArrayList<Integer> result) {
//		if(root == null) {
//			return;
//		}
//		result.add(root.val);
//		preOrder(root.left, result);
//		preOrder(root.right, result);
//	}
//	public ArrayList<Integer> preOrderReverse(TreeNode root){
//		if(root == null) {
//			return new ArrayList<Integer>();
//		}
//		ArrayList<Integer> res = new ArrayList<Integer>();
//		preOrder(root, res);
//		return res;
//	}
	
//	非递归法
	public ArrayList<Integer> preOrderReverse(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
			
		}
		return res;
	}
}
