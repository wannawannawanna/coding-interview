import java.util.Stack;

public class Solution {

    Stack<Integer> s_data = new Stack<Integer>();
    Stack<Integer> s_min = new Stack<Integer>();  //辅助栈，存放最小值
    int min = 0;
    public void push(int node) {
        if(s_data.size() == 0){
            s_data.push(node);
            s_min.push(node);
            min = node;
        }
        else{
            if(min < node){
                s_data.push(node);
                s_min.push(min);
            }else{
                s_data.push(node);
                s_min.push(node);
                min = node;
            }
        }
    }
    
    public void pop() {
        if(!s_data.isEmpty()){
            s_min.pop();
            s_data.pop();
        }
        return;
    }
    
    public int top() {
        if(!s_data.isEmpty()){
            return s_data.peek();
        }
        return 0;
    }
    
    public int min() {
        if(!s_min.isEmpty()){
            return s_min.peek();
        }
        return 0;
    }
}
