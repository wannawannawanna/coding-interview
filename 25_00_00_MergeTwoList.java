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



package bishi;
import java.util.Scanner;
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
	}
}
public class genshuixue1 {
	public static Node mergeTwoLists(Node N1, Node N2) {
		if(N1 == null) {
			return N2;
		}
		if(N2 == null) {
			return N1;
		}
		Node pmergeHead = null;
		if(N1.data < N2.data) {
			pmergeHead = N1;
			pmergeHead.next = mergeTwoLists(N1.next, N2);
		}
		else {
			pmergeHead = N2;
			pmergeHead.next = mergeTwoLists(N1, N2.next);
		}
		return pmergeHead;
	}
	public static Node getListHead(String[] list, int index) {
		if(index == list.length) {
			return null;
		}
		Node head = new Node(Integer.valueOf(list[index]));
		head.next = getListHead(list, index+1);
		return head;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String[] list1 = input.nextLine().trim().split(" ");
			String[] list2 = input.nextLine().trim().split(" ");
			Node n1 = getListHead(list1, 0);
			Node n2 = getListHead(list2, 0);
			Node merge = mergeTwoLists(n1, n2);
			while(merge != null) {
				System.out.println(merge.data);
				merge = merge.next; 
			}
		}
		
		
		
		
	}
}

