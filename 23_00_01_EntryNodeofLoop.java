package Offer;


public class example23_1 {
	public ListNode HasCycle(ListNode pHead){
		if(pHead == null || pHead.next ==null) {
		  	return null;
		}
		ListNode slow = pHead;
		ListNode fast = pHead;
		 
		while(fast != null && fast.next != null && fast.next.next != null) {
		     slow = slow.next;
		     fast = fast.next.next;
		     if(slow == fast) {      		
		         return slow;
		     }
		}
		return null;
	}
	public int GetCycleLength(ListNode listnode) {
	    if(listnode == null) {
	  	return 0;
	    }
	    ListNode current = listnode;
	    int nodenum = 0;
	    while(current != null){
		 current = current.next;
		 nodenum++;
		 if(current == listnode)
		      return nodenum;
	    }
            return nodenum;
	  
	}
	public ListNode EntryNodeOfLoop(ListNode pHead)
	{
	if(pHead == null) {
		return null;
	}
	  ListNode meet = HasCycle(pHead);
	  if(meet == null) {
		  return null;
	  }
	  int length = GetCycleLength(meet);
	  ListNode slow1 = pHead;
	  ListNode fast1 = pHead;
	  for(int i = 0; i < length; i++) {
		   fast1 = fast1.next;
	  }
	  while(fast1 != slow1) {
			  fast1 = fast1.next;
			  slow1 = slow1.next;
		  }	  
		  return fast1;		

	}
}
