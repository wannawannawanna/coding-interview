package Offer;

public class example18 {
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
	public void print(ListNode head) {
		if(head == null) {
			return;
		}
		ListNode pNode = head;
		while(pNode != null) {
			System.out.println(pNode.val);
			pNode = pNode.next;
			
		}
	}
	public void DeleteNode(ListNode head, ListNode pToBeDeleted) {
		if(head == null || pToBeDeleted == null) {
			return;
		}
		if(pToBeDeleted.next != null) {  //非尾结点
			System.out.println("hahaha");
			pToBeDeleted.val = pToBeDeleted.next.val;
			pToBeDeleted.next = pToBeDeleted.next.next;
			pToBeDeleted.next = null;
		}
		if(head.next == null) {
			pToBeDeleted = null;
			head = null;
		}
		if(pToBeDeleted.next == null) {
			ListNode pNode = head;
			while(pNode.next != null) {
				pNode = pNode.next;
			}
			pNode.next = null;
			pToBeDeleted = null;
		}
		print(head);
	}
	public static void main(String[] args) {
		example18 ex = new example18();
		ListNode pTobeDel = null;
		for(int i = 0; i < 10; i++) {
			ex.add(i);
			if(i == 3) {
				pTobeDel = new ListNode(i);
			}
		}
		ex.print(ex.head);
		ex.DeleteNode(ex.head, pTobeDel);
		
	}
}
