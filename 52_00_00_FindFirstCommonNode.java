package Offer;
import java.util.*;
public class example52_1 {
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode pNode1 = pHead1;
		ListNode pNode2 = pHead2;
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		while(pNode1 != null) {
			stack1.push(pNode1);
			pNode1 = pNode1.next;
		}
		while(pNode2 != null) {
			stack2.push(pNode2);
			pNode2 = pNode2.next;
		}
		ListNode pRes = null;
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode pRes1 = (ListNode)stack1.pop();
            ListNode pRes2 = (ListNode)stack2.pop();
			if (pRes1 == pRes2) {
				pRes = pRes1;
			}
			else {
				return pRes;
			}		
		}
		return pRes;
	}
	
}
