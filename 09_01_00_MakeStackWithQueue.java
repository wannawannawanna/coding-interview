package Offer;
import java.util.Queue;
import java.util.LinkedList;

public class example9_1 {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	public void push(int node) {
		if(q1.isEmpty() && q2.isEmpty()) {			
			q1.add(node);		//队列没有push()函数,push()是栈的
		}
		else if(!q1.isEmpty()) {			
			q1.add(node);		
		}
		else if(!q2.isEmpty()) {
			q2.add(node);
		}
	}
	public int pop() {
		if(!q1.isEmpty() && q2.isEmpty()) {
			int length = q1.size();  //如果想用for那必须先获得队列的长度，然后作为i的上界，
			//否则队列长度是变化的，直接在for里面写q1.size()的话会越界,,,,,或者直接用while，判断队列长度不为1就好了
			for(int i = 0; i < length - 1; i++) {				
				int current = q1.poll();				
				q2.add(current);
			}			
			return q1.poll();
		}
		else if(!q2.isEmpty() && q1.isEmpty()) {
			while(q2.size() != 1) {			
				int current = q2.poll();  //返回队列顶元素，并删除，没有pop()这个函数，pop是栈的，，，
				//如果只想返回队列顶元素不删除，那么用peek（）
				q1.add(current);
			}			
			return q2.poll();
		}
		return 0;
	}
	public static void main(String[] args) {
		example9_1 ex = new example9_1();
		ex.push(1);
		ex.push(2);
		ex.push(3);
		System.out.println(ex.pop());
		System.out.println(ex.pop());
		ex.push(4);
		System.out.println(ex.pop());
		System.out.println(ex.pop());
	}
	
}
