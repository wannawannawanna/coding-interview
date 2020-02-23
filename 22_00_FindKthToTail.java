package Offer;
//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int val){
//		this.val = val;
//	}
//}
public class example22 {
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
	 public ListNode FindKthToTail(ListNode head, int k) {
		 if(head == null || k == 0) {
			 return null;
		 }
		 ListNode p1 = head;
		 ListNode p2 = null;
		 for(int i = 0; i < k - 1; i++) {
			 if(p1.next != null) {
				 p1 = p1.next;
			 }
			 else{
                 return null;
             }
		 }
		 p2 = head;
		 while(p1.next != null) {
			 p1 = p1.next;
			 p2 = p2.next;
		 }
		 
		 return p2;		 
	 }

	 public static void main(String[] args) {
		 example22 ex = new example22();
//		 for(int i = 0; i < 10; i++) {
//			 ex.add(i);
//		 }
		 System.out.println(ex.FindKthToTail(ex.head, 5));
		 System.out.println(ex.FindKthToTail(ex.head, 5).val);
	 }
}
