package com.lav.dp.creationaldp.singleton;

public class ThreadSafeSingleton1 {

	private static ThreadSafeSingleton1 instance;
	
	private ThreadSafeSingleton1() {
	}
	
	public static synchronized ThreadSafeSingleton1 getInstanceSyncMethod() {
		if(instance == null) {
			instance = new ThreadSafeSingleton1();
		}
		return instance;
	}
	
	public static ThreadSafeSingleton1 getInstance() {
		//synchronized (instance) {  => also can be given for thread safety
		synchronized (ThreadSafeSingleton1.class) {
			if(instance == null) {
				instance = new ThreadSafeSingleton1();
			}
		}
		return instance;
	}
}
