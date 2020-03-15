import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.add(node);
    }
    
    public int pop() {
       if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int current = stack1.pop();
                stack2.add(current);
            }
       }
        //出栈判断一下Stack2是否为空，不为空直接出栈，空的话，先进行stack1的元素堆入stack2,再出栈
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        return 0;
    }
}
