package Offer;

public class example25 {
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
	public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) {
        	return list2;
        }
        if(list2 == null) {
        	return list1;
        }
        ListNode pmergedhead = null;
        if(list1.val < list2.val) {
            pmergedhead = list1;
            pmergedhead.next = Merge(list1.next, list2);
            
        }
        else {
            pmergedhead = list2;
            pmergedhead.next = Merge(list1, list2.next);
            
        }       	       
        return pmergedhead;
    }
	public static void main(String[] args) {
		example25 ex1 = new example25();
		example25 ex2 = new example25();
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				ex1.add(i);
			}
			else {
				ex2.add(i);
			}
		}
		ListNode merge = Merge(ex1.head, ex2.head);
		if(merge == null) {
			System.out.println(0);
		}
		while(merge != null) {
			System.out.println(merge.val);
			merge = merge.next;
		}
	}
}
