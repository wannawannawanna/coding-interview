/*
既然不能用乘法，分析题目，我们可以将乘积拆为两项。即:
C[i] = A[0] * A[1] *...*A[i-1]
D[i] = A[i + 1] *...* A[n-1]
B[i] = C[i] * D[i]
我们先来计算C[i]，使用数学归纳法：
C[0] = 1
C[1] = A[0]
C[2] = A[0] * A[1]
C[3] = A[0] * A[1] * A[2]
...
我们可以得出规律：C[i] = C[i-1] * A[i -1](i >=1)
我们继续用数学归纳法计算D[i]:
D[n - 1] = 1
D[n - 2] = A[n -1]
D[n - 3] = A[n - 1] * A[n - 2]
我们可以得出规律：D[i] = D[i + 1]* A[i + 1](i <= n-2)  */
//一个二维矩阵，分为左下角和右上角的两个三角形，主对角线上元素都是1，

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        if(A == null || length <= 0){
            return A;
        }
        int[] result = new int[length];
        result[0] = 1;
        for(int i = 1; i < length; i++){  //先计算左下角元素，即先把左下角的元素一个个当成result的因子，从左上开始
            result[i] = result[i - 1] * A[i - 1];
        }
        int temp = 1;
        for(int i = length - 2; i >= 0; i--){  //计算右上角，看好i的上限，把右上角的元素一个个从右下开始一个个补上
            temp = temp * A[i + 1];
            result[i] = result[i] * temp;
            
        }
        return result;
    }
}
