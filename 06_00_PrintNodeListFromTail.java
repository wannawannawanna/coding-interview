package Offer;
import java.util.*;
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
}
public class example6 {
	public ListNode head;
	public ListNode current = null;
	public void add(int data) {
		if(head == null) {
			head = new ListNode(data);
			current = head;
		}
		else {
			current.next = new ListNode(data);
			current = current.next;
		}
	}
	public ArrayList<Integer> PrintNodeListFromTail(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
			if(listNode == null) {
				return new ArrayList<Integer>();
			}		
			while(listNode != null) {
				stack.push(listNode.val);
				listNode = listNode.next;
			}
			ArrayList<Integer> arraylist = new ArrayList<>();
			while(!stack.isEmpty()) {
				arraylist.add(stack.pop());
			}
			return arraylist;
	}
	public static void main(String[] args) {
		example6 ex = new example6();
		for(int i = 0; i < 10; i++) {
			ex.add(i);
		}
		System.out.println(ex.PrintNodeListFromTail(ex.head));
	}
}
