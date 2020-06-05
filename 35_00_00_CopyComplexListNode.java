package Offer;
class RandomListNode{
	int val;
	RandomListNode next;
	RandomListNode random;
//	RandomListNode(int val){
//		this.val = val;
//	}
	
}
public class PreorderReverse {
	public void CloneNode(RandomListNode pHead) {
		//顺序扫描每个节点，然后进行copy,并插入到当前节点后面
		if(pHead == null) {
        	return ;
        }
        RandomListNode pNode = pHead;     
        while(pNode != null) {
        	RandomListNode pCloned = new RandomListNode();
        	pCloned.val = pNode.val;
        	pCloned.next = pNode.next;
        	pCloned.random = null;
        	
        	pNode.next = pCloned;
        	pNode = pCloned.next;
        }		
	}
	public void ConnectRandomNode(RandomListNode pHead) {
		if(pHead == null) {
			return;
		}
		RandomListNode pNode = pHead;
		while(pNode != null) {
			RandomListNode pCloned = pNode.next;
			if(pNode.random != null) {
				pCloned.random = pNode.random.next;
			}
			pNode = pCloned.next;
			
		}
	}
	public RandomListNode ReconnectRandomNode(RandomListNode pHead) {
		if(pHead == null) {
			return null;
		}
		RandomListNode pNode = pHead;
		RandomListNode pClonedHead = null;
		RandomListNode pClonedNode = null;
		if(pNode != null) {
			pClonedHead = pClonedNode = pNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;			
		}
		while(pNode != null) {
			pClonedNode.next = pNode.next;
			pClonedNode = pClonedNode.next;
			pNode.next = pClonedNode.next;
			pNode = pNode.next;
		}
		return pClonedHead;
	}
	public RandomListNode Clone(RandomListNode pHead)
    {
		CloneNode(pHead);
		ConnectRandomNode(pHead);
		return ReconnectRandomNode(pHead);
    }
}
