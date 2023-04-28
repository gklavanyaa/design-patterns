package com.lav.dp.creationaldp.singleton;

public class ImprovedThreadSafeSingleton2 {

	// volatile key word ensure only one thread can work on this.
	private static volatile ImprovedThreadSafeSingleton2 instance;

	private ImprovedThreadSafeSingleton2() {
	}

	public static ImprovedThreadSafeSingleton2 getInstance() {
		if (instance == null) {
			//To avoid wait if already instance is created
			synchronized (ImprovedThreadSafeSingleton2.class) {
				if (instance == null) {
					instance = new ImprovedThreadSafeSingleton2();
				}
			}
		}
		return instance;
	}
}
