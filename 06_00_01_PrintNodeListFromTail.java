package Offer;
//递归
import java.util.*;

public class example6_1 {
	public ListNode head;
	public ListNode current;
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
	ArrayList<Integer> arraylist = new ArrayList<Integer>();
	public ArrayList<Integer> PrintListNodeFromTail(ListNode listNode){
		if(listNode == null) {
			return new ArrayList<Integer>();
		}
		if(listNode != null) {
			if(listNode.next != null) {
				PrintListNodeFromTail(listNode.next);
			}
			arraylist.add(listNode.val);
		}
		return arraylist;
	}
	public static void main(String[] args) {
		example6_1 ex = new example6_1();
		for(int i = 0; i < 10; i++) {
			ex.add(i);
		}
		System.out.println(ex.PrintListNodeFromTail(ex.head));
	}
	
}
