class ListNode{
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
}
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        for(int i = 1; i < n; i++){
            current.next = new ListNode(i);
            current = current.next;
        }
        current.next = head;   //到这儿已经建立了循环链表
        ListNode current2 = null;
        while(n != 1){  //寻找最后剩下的节点，所以终止条件是n == 1
            current2 = head;//循环更新head
            for(int i = 1; i < m - 1; i++){ //假设m = 3,那么只需要找到第二个，然后跳过第三个节点即可，
                                              //所以current = current.next只需执行一次就可以找到第二个节点
                current2 = current2.next;
            }
            current2.next = current2.next.next;  //跳过第m个节点，指向第m+1个节点
            head = current2.next;  //在下一轮中，头结点就是第m+1个节点
            n--;  //节点总数目减1
        }
        return head.val;
    }
}

//解法二，
/* 链接：https://www.nowcoder.com/questionTerminal/f78a359491e64a50bce2d89cff857eb6
来源：牛客网

问题描述：n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，剩下的人 继续从0开始报数。求胜利者的编号。

 我们知道第一个人(编号一定是m%n-1) 出列之后，剩下的n-1个人组成了一个新      的约瑟夫环（以编号为k=m%n的人开始）:

        k  k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-2并且从k开始报0。

现在我们把他们的编号做一下转换：

k     --> 0

k+1   --> 1

k+2   --> 2

...

...

k-2   --> n-2

k-1   --> n-1

变换后就完完全全成为了(n-1)个人报数的子问题，假如我们知道这个子问题的解： 例如x是最终的胜利者，那么根据上面这个表把这个x变回去不刚好就是n个人情 况的解吗？！！变回去的公式很简单，相信大家都可以推出来：x'=(x+k)%n。

令f[i]表示i个人玩游戏报m退出最后胜利者的编号，最后的结果自然是f[n]。

递推公式

f[1]=0;

f[i]=(f[i-1]+m)%i;  (i>1)

有了这个公式，我们要做的就是从1-n顺序算出f[i]的数值，最后结果是f[n]。 因为实际生活中编号总是从1开始，我们输出f[n]+1。*/
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for(int i = 2; i <= n; i++){
            last = (last + m) % i;
        }
        return last;
    }
}
