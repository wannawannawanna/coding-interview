package Offer;
import java.util.ArrayList;
import java.util.Stack;
public class example31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) {
        	return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(pushA[0]);   //需要先堆入一个，否则stack.peek()会报错，
    	  int j = 1;
        for(int i = 0; i < popA.length; i++){                    
        	while(popA[i] != stack.peek()){           
                if(j == pushA.length){  //需要先判断，否则堆入最后一个元素的时候j++，就等于数组长度直接返回false；
                //我自己写的时候先写了push和自加操作，找了好半天bug
                    return false;
                }
                stack.push(pushA[j]);
                j++;
            }
            stack.pop();                  
        }      
        return true;
    }
    public static void main(String[] args) {
    	example31 ex = new example31();
    	int[] A = {1,2,3,4,5};
    	int[] B = {4,5,3,2,1};
    	System.out.println(ex.IsPopOrder(A, B));
    }
}
