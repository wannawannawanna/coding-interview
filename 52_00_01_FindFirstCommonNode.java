package Offer;

public class example52 {
	public int getLength(ListNode pHead) {
		if(pHead == null) {
			return 0;
		}
		int length = 0;
		ListNode pNode = pHead;
		while(pNode != null) {
			length ++;
			pNode = pNode.next;
		}
		return length;
	}
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 int lengthhead1 = getLength(pHead1);
		 int lengthhead2 = getLength(pHead2);
		 int lengthDif;
		 ListNode pNode2 = pHead2;
		 ListNode pNode1 = pHead1;
		 if(lengthhead2 > lengthhead1) {
			 lengthDif = lengthhead2 - lengthhead1;
			 for(int i = 0; i < lengthDif; i++) {
				 pNode2 = pNode2.next;
			 }

		 }
		 else {
			 lengthDif = lengthhead1 - lengthhead2;
			 for(int i = 0; i < lengthDif; i++) {
				 pNode1 = pNode1.next;
			 }
		 }
		 while(pNode1 != null && pNode2 != null && pNode1.val != pNode2.val) {
			 pNode1 = pNode1.next;
			 pNode2 = pNode2.next;
		 }
		 ListNode pCommonNode = pNode1;
		 return pCommonNode;
		 
    }
}
