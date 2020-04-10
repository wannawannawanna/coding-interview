//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

//若队列为空，pop_front 和 max_value 需要返回 -1
//  1 <= push_back,pop_front,max_value的总操作数 <= 10000
//  1 <= value <= 10^5

class MaxQueue {
    int[] Queue; //完成队列
    int[] MaxQueue;  //最大值队列
    int QueueHead = 0;
    int QueueTail = 0;
    int MaxQueueHead = 0;
    int MaxQueueTail = 0;
    public MaxQueue() {
        Queue = new int[10000];//总操作数不超过10000
        MaxQueue = new int[10000];
    }
    
    public int max_value() {
        if(MaxQueueHead == MaxQueueTail){  //表示队列为空
            return -1;
        }
        return MaxQueue[MaxQueueHead];  //队首元素是最大值
    }
    
    public void push_back(int value) {
        Queue[QueueTail++] = value;  //往数据队列中添加元素
        while(MaxQueueHead != MaxQueueTail && MaxQueue[MaxQueueTail - 1] < value){  //判断当前对立面元素是否比当前值小，如果小要弹出
            MaxQueueTail--;
        }
        MaxQueue[MaxQueueTail++] = value;  //再添加可能成为最大值的所有元素
    }
    
    public int pop_front() {
        if(QueueHead == QueueTail){  //队列为空
            return -1;
        }
        int result = Queue[QueueHead];  //弹出队首
        if(result == MaxQueue[MaxQueueHead]){  //判断最大值队列里面是否还存在result，如果存在要弹出
            MaxQueueHead++;  //即QueueHead加1
        }
        QueueHead++;
        return result;  
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
