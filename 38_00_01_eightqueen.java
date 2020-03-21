import java.util.ArrayList;
public class Solution {
	public ArrayList<ArrayList<Integer>> eightqueen(int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(k <= 0) {
			return result;
		}
		ArrayList<Integer> queen = new ArrayList<Integer>(k);	
		for(int i = 0; i < k; i++) {
			queen.add(0);
		}
		int begin = 0;
		eightqueenCore(queen, begin, result);
		System.out.println(queen.set(0, 1));
		System.out.println(System.identityHashCode(result.get(0)));//为了查看是不是同一个内存地址
		System.out.println(System.identityHashCode(result.get(1)));
		System.out.println(System.identityHashCode(result.get(2)));
//		System.out.println("result1:" + result.size());
		return result;
	}
	public void eightqueenCore(ArrayList<Integer> queen, int begin, ArrayList<ArrayList<Integer>> result) {
		if(begin == queen.size()) {
//			System.out.println(queen);
//基本类型：byte, short, int, long, float, double, boolean, char
//引用类型：类 接口 数组 枚举 标注
//特例：String 属于引用类型，但是是传值，原因：String 对象称为不可变的（只读），
//因为一旦创建了该对象，就不能修改该对象的值。看来似乎修改了 String 对象的方法实际上是返回一个包含修改内容的新 String 对象.
//所以字符串排列那道题不用new顺利通过编译
			ArrayList<Integer> temp = new ArrayList<Integer>(queen);  //基本数据类型是传值，就可以不用new这种了，
      //但是引用类型需要新建一个临时地址，因为引用类型是传引用的,每进行修改的时候之前保存下来的值也会跟着被修改，因为他们都指向同一个内存地址
			result.add(temp);
			System.out.println("result2:" + result.size());
			return ;	
		}
		for(int col = 0; col < queen.size(); col++) {
//			System.out.println("queen.size()" + queen.size());
			queen.set(begin, col);
			if(CanPlaceQueen(begin,queen)) {				
				eightqueenCore(queen, begin + 1, result);
			}
		}
			
	}
	public boolean CanPlaceQueen(int begin, ArrayList<Integer> queen) {
		for(int i = 0; i < begin; i++) {
			if( queen.get(i) == queen.get(begin) || Math.abs(i - begin) == Math.abs( queen.get(i) - queen.get(begin) ) ) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		example38_1 ex = new example38_1();
//		ArrayList<Integer> array = new ArrayLis
		System.out.println(ex.eightqueen(8));
	}
}
