public class ClassicSingleton {
	private static ClassicSingleton instance;
	private ClassicSingleton() {
		// Exists only to defeat instantiation.
	}
	public static ClassicSingleton getInstance() {
		if (instance == null)
			instance = new ClassicSingleton();
		return instance;
	}
}

class SingletonThreadsafe {
	private static SingletonThreadsafe instance;

	private SingletonThreadsafe() {
	}
	public static synchronized SingletonThreadsafe getInstance() {
		if (instance == null)
			instance = new SingletonThreadsafe();
		return instance;
	}
	public void doSomething() {
	}
}

//Lazy instantiation using double locking mechanism.
class Singleton {
	private static Singleton instance;
	private Singleton() {
	}
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					System.out
							.println("getInstance(): First time getInstance was invoked!");
					instance = new Singleton();
				}
			}
		}

		return instance;
	}
	public void doSomething() {
	}
}


//Early instantiation using implementation with static field.
class Singleton{
	private static Singleton instance = new Singleton();
	private Singleton(){
	}
	public static Singleton getInstance(){    
		return instance;
	}
	public void doSomething(){
	}
}

