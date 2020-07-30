package Offer;
//example1是Singleton单例模式
public class example1 {
	private volatile static example1 uniqueInstance; //uniqueInstance不能被外部访问，所以是private
	private example1() {}  //example1外不能new一个单例模式，所以构造函数也是private
	public static example1 getInstance() { //因为不能new Singleton,所以必须static，才能通过Singleton.getInstance()来实例化单例模式
		if(uniqueInstance == null) {  //双重校验
			synchronized(example1.class) { //对Singleton.class上锁
				if(uniqueInstance == null) {
					uniqueInstance = new example1();
				}
			}
		}
		return uniqueInstance;
	}
	public static void main(String[] args) {  //验证是否只有一个实例
		example1 ex1 = getInstance();
		example1 ex2 = getInstance();
		System.out.println(ex1 == ex2); //判断是不是一个实例，返回true
	}
}
