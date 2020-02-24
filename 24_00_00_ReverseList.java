package Offer;

public class example24 {
	public ListNode head;
	public ListNode current;
	public void add(int data) {
		if(head == null) {
			head = new ListNode(data);
			current = head;
		}else {
			current.next = new ListNode(data);
			current = current.next;
		}
	}
	public ListNode ReverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode reversedhead = null;
		ListNode pNode = head;
		ListNode pPrev = null;	
		while(pNode != null) {
			ListNode pNext = pNode.next;
			if(pNext == null) {
				reversedhead = pNode;
			}
			pNode.next = pPrev;
			
			pPrev = pNode;
			pNode = pNext;			
		}
		return reversedhead;
    }
	public static void main(String[] args) {
		example24 ex = new example24();
		for(int i = 0; i < 10; i++) {
			ex.add(i);
		}
		System.out.println(ex.ReverseList(ex.head).val);
	}
}
