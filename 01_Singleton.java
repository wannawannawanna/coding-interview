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







package bishi;

//单利模式：确保一个类只有一个实例，并提供该类实例的全局访问点。实现：使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现
//私有构造函数保证了不能通过构造函数来创建实例，只能通过公有静态函数返回唯一的私有静态变量。
	
//1.懒汉式-线程不安全，私有静态变量uniqueInstance被延迟实例化，这样做的好处是，如果没有用到该类，那么就不会实例化
//uniqueInstance从而节省空间。
public class Singleton {	
	public static Singleton uniqueInstance;
	private Singleton() {
		
	}
	public static Singleton newInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;//在多线程环境下非线程安全，如果多个线程能够同时进入if（uniqueInstance == null），
		//并且此时uniqueInstance == null，那么多个线程都会执行uniqueInstance = new Singleton()语句，导致实例化多次
	}
}

//懒汉式-线程安全-但是性能不好，可以直接在newInstance方法上直接加上一把synchronized同步锁，那么在一个时间点只能有一个线程能够同时进
//入该方法，从而避免实例化多次，但是当一个线程进入该方法后，其他试图进入该方法的线程都必须等待，即使uniqueInstance已经被实例化了，这会
//让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。
class Singleton1{
	private static Singleton1 uniqueInstance;
	private Singleton1() {
		
	}
	public static synchronized Singleton1 newInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton1();
		}
		return uniqueInstance;
	}
}

//饿汉式-线程安全--无延迟加载，就是直接采用实例化uniqueInstance的方式，这样就不会产生线程不安全的问题，比较常用,但容易产生垃圾对象
//（丢失了延迟实例化（lazy loading）带来的节约资源的好处）。他基于classloader机制避免了多线程的同步问题，不过instance在类装载
//时就实例化，虽然导致类装在的原因有很多种，在单例模式中大多数都是调用getInstance方法，但是也不能确定有其他的方式（或其他的静态方法）导致
//类装载，这时候初始化instance显然没有达到lazy loading的效果。
class Singleton2{
	private static Singleton2 uniqueInstance = new Singleton2();
	private Singleton2() {
		
	}
	public static Singleton2 newInstance() {
		return uniqueInstance;
	}
	public static String getStr(String str) {//当只调用这个方法的时候也会生成Singleton虽然你不想用这个，也没办法
		return "hello" + str;
	}
}

//双重校验锁-线程安全，uniqueInstance只需要被实例化一次，之后就可以一直使用了，加锁操作只需要对实例化那部分的代码进行，
//只有当uniqueInstance没有被实例化时，才需要进行加锁。双重校验锁先判断uniqueInstance是否已经被实例化，如果没有被实例化，那么
//才对实例化语句进行加锁
class Singleton3{
	private static volatile Singleton3 uniqueInstance;
	private Singleton3() {
		
	}
	public static Singleton3 newInstance() {
		if(uniqueInstance == null) {
			synchronized(Singleton3.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton3();
				}
			}
		}
		return uniqueInstance;
	}
}

//静态内部类实现，当Singleton类加载时，静态内部类holder没有被加载进内存，只有当调用newInstance方法从而触发
//holder.uniqueInstance时holder才会被加载，此时初始化uniqueInstance实例，并且JVM能确保uniqueInstance
//只被实例化一次，这种方式不仅具有延迟初始化的好处，而且由JVM提供了对多线程安全的支持。这种方式是Singleton类被装载了，但是
//uniqueInstance不一定被初始化，因为holder类没有被主动使用，只有通过显式地调用newInstance（）方法时，才会显示装载holder
//类，从而实例化uniqueInstance。
class Singleton4{
	private Singleton4() {}
	private static class Holder{
		private static final Singleton4 uniqueInstance = new Singleton4();
	}
	public static Singleton4 newInstance() {
		return Holder.uniqueInstance;
	}
}


//类加载的时候，会把静态变量和静态方法放到方法区里面，并没有说静态内部类，只有被显示调用的时候才会加载进内存
