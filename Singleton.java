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
		// ...
	}

	public static synchronized SingletonThreadsafe getInstance() {
		if (instance == null)
			instance = new SingletonThreadsafe();
		return instance;
	}

	public void doSomething() {
		// ...
	}
}
