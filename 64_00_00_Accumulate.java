//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//解法1，等差数列求和公式，sum = (n + 1)*n/2 = (n^2 + n)/2;因为不能用乘除所以用位移，右移一位相当于除2
public class Solution {
    public int Sum_Solution(int n) {
        int sum = (int)Math.pow(n, 2) + n;  //强制类型转换，Math.pow()是double类型的
        return sum >> 1;
    }
}



//解法2，短路求值，因此可以利用左边的表达式来作为递归结束的判断条件。因此递归的表达式就在右边了。而想到递归的解法，必然是sum=Sum(n)=Sum(n-1)+n
/*使用&&,表示两边都为真，才为真，左边为假，右边就没用了。因此在不断递归时，直到左边为假时，才不执行右边。因此在第一次进行右边的判断时，就进入递归的调用。
想到结束条件在左边，只能是n=0时结束，即从n递减到0结束，所以递归的调用理所当然放在了右边。由于左边需要不断的进行条件判断，因为需要一个每次递归后都递减的
变量，而n是递减的，因此用n来作为左边的变量，int sum = n; 而短路求值左边可以写为(n>0)或（n!=0），右边写为sum +=sum(n-1)，再加一个判断（实际上需要保证
右边的条件一直为真）*/
public class Solution {
    public int Sum_Solution(int n) {
        int sum=n;  //每次进入一个递归的时候给sum进行初始化成n,
        //n=1时直接返回1
        boolean flag=(sum>0)&&((sum+=Sum_Solution(n-1))>0);  //当n=0时，sum=0，&&后面的就不会执行了，flag=0了，返回sum
        return sum;
    }
}
