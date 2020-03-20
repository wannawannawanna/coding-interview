// byte:1个字节 8位 -128~127

// short ：2个字节 16位

// int ：4个字节 32位

// long：8个字节 64位

// 浮点型：

// float：4个字节 32 位

// double ：8个字节 64位
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){//int是32位的，所以需要移动32位
            if ((n & (1 << i)) != 0) {   //1左移i位   n & (1 << i)能找到n中第i位是否不为0
                count++;
            }
        }
        return count;
    }
}

private static int NumberOf1_low(int n) {
      int count = 0;
      int flag = 1;
      while (flag != 0) {  //flag==0表示遍历完int的所有位了
          if ((n & flag) != 0) {
              count++;
          }
          flag = flag << 1;  //flag左移一位
      }
      return count;
  }

//最优解
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
