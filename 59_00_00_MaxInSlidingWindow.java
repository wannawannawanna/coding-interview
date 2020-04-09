//不管当前值是否比队列里面的值大，都要加到队列里面，只是如果比队列里面的元素大的话，先从队列里面把那些小的值删掉，然后再加进来。
//因为比队列里面小的数也有可能成为下一个滑窗的最大值
//重点：在队列里面存储的数组的下标
//还要判断队列头部的值，是否已经不在滑窗范围之内，队列头部的值会是每个滑窗的最大值
import java.util.ArrayList;
import java.util.LinkedList;   //双端队列
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        if(num == null || num.length == 0 || size <= 0 || num.length < size){  //特殊情况要好好想
            return result;
        }
        for(int i = 0; i < num.length; i++){
            while(!qmax.isEmpty() && num[qmax.peekLast()] < num[i]){  //peekLast()可以返回队尾的值，但是不从队列中弹出
                qmax.pollLast();  //pollLast() 从队列中弹出
            }
            qmax.addLast(i);
            if(!qmax.isEmpty() && i - size == qmax.peekFirst()){  //跟peekLast()和pollLast一样，这个是判断队首的元素是否已经超出滑窗范围之内
                qmax.pollFirst();
            }
            if(i >= size - 1){  //从size - 1开始加入result
                result.add(num[qmax.peekFirst()]);
            }
        }
        return result;
    }
}
