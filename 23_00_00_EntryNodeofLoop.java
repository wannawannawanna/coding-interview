package Offer;

public class example23 {
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
	public void add(ListNode listnode) {
		if(head == null) {
			head = listnode;
			current = head;
		}
		else {
			current.next = listnode;
			current = current.next;
		}
	}
	public boolean HasCycle(ListNode pHead){
        boolean hadloop = false;
        if(pHead == null || pHead.next == null) {
        	return false;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
       
        while(fast != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast) {      		
        		hadloop = true;
        		return hadloop;
        	}
        }
        return hadloop;
    }
	public int GetCycleLength(ListNode pHead) {
		if(pHead == null || pHead.next == null) {
        	return 0;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        ListNode meet = null;
        while(fast != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if(slow == fast) {      		
        		meet = slow;
        		break;
        	}
        }
        int nodenum = 0;
        while(meet != null) {
        	meet = meet.next;
        	nodenum++;
        	if(meet == slow)
        		return nodenum;
        }
        return nodenum;
        
	}
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		if(pHead == null) {
			return null;
		}
        if(HasCycle(pHead) != false) {
        	int nodenum = GetCycleLength(pHead);
        	ListNode slow1 = pHead;
        	ListNode fast1 = pHead;
        	for(int i = 0; i < nodenum; i++) {
        		fast1 = fast1.next;
        	}
        	while(fast1 != slow1) {
        		fast1 = fast1.next;
            	slow1 = slow1.next;
            	
        	}
        	return slow1;
        }
        return null;
    }
	 public static void main(String[] args) {
		 example23 ex = new example23();
//		 或
//		 ListNode second = null; //把第二个结点记下来
//         for (int i = 1; i < 6; i++) {
//        	 ex.add(i);
//
//        	 if (i == 3) {
//        		 second = ex.current;  //把第二个结点记下来
//             }
//         }
//
//         ex.add(second);
		 //或
		 ex.add(1);
		 System.out.println(ex.EntryNodeOfLoop(ex.head));

	 }
}
