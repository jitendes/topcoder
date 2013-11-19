public class Singleton {
	private static Singleton instance = null;

	private Singleton() {
		// Exists only to defeat instantiation.
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}

public class Singleton{
	private static Singleton instance;
	private Singleton(){
		...
	}

	public static synchronized Singleton getInstance(){
		if (instance == null)
			instance = new Singleton();

		return instance;
	}
	...
	public void doSomething(){
		...	
	}
}
