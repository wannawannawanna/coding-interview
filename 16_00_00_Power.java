public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0){  //次幂是0的时候一般都是1，且0的0次幂没有意义，所以返回什么都无所谓
            return 1;
        }
        if(exponent == Integer.MIN_VALUE && exponent < 0){ 如果次幂是int的范围的最小值，那么直接取绝对值的话，
        //会超出int的范围，后面就不能二进制表示,因此需要先加1，再去绝对值，这样最后求得次幂之后，还得除base，举例2^(-4)==( (1/2)^abs(-4+1) )/2
            return Power(1 / base, Math.abs(exponent + 1)) / base;
        }
        if(!equal(base, 0.0) && exponent < 0){
            return Power(1 / base, Math.abs(exponent)); //exponent<0的时候，书上是直接先求得1.0/(base^exponent),
            //但是double类型当result很大可能会有问题，1/base没问题，因为base还不是很大。因此最好不要用除法
            //改用乘法，先求1/base然后再求幂次
        }
        double result = 1.0;
        double curr = base;
        while(exponent > 0){
            if((exponent & 0x1) != 0){
                result *= curr;
            }
            curr *= curr;
            exponent = exponent >> 1;
        }
        return result;
    }
    boolean equal(double a, double b) { //double类型和float类型判断两个值是否相等，不能用==，需要自己定义一个equal函数
        double epsilon = 1e-15;
        if (Math.abs(a - b) <= epsilon) {
            return true;
        }
        return false;
    }

}
