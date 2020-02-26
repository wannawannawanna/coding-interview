package Offer;

public class example18_1 {
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
	public void print(ListNode pHead) {
		if(pHead == null) {
			return;
		}
		ListNode pNode = pHead;
		while(pNode != null) {
			System.out.println(pNode.val);
			pNode = pNode.next;
		}
	}
	public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) {
			return null;
		}
		ListNode pPrev = null;
		ListNode pNode = pHead;
		boolean needdel = false;
		while(pNode != null) {
           
            if(pNode.next != null && pNode.next.val == pNode.val){
                ListNode pToBeDel = pNode;
                while(pNode.next != null && pNode.next.val == pNode.val){
                    pNode = pNode.next;                   
                    pToBeDel = pNode;
                }
                if(pPrev == null){
                    pNode = pNode.next;
                    pHead = pNode;
                }
                else{
                    pNode = pNode.next;
                    pPrev.next = pNode;
                }
            }
            else{
                pPrev = pNode;
                pNode = pNode.next;
            }	
		}
		return pHead;
    }
	public static void main(String[] args) {
		example18_1 ex = new example18_1();
		ex.add(1);
		ex.add(1);
		ex.add(2);
		ex.add(2);
		ex.add(3);
		ex.add(3);
		ex.add(4);
		ex.add(5);
		ListNode out = ex.deleteDuplication(ex.head);
		ex.print(out);
		
	}
}
