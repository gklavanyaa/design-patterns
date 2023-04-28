package com.lav.dp.creationaldp.singleton;

public class EagerInitialization {

	/*
	 * Should go for lazy initialization only if sure that it will 
	 * be used atleast once. Preffered in lazy initialization always. 
	 */
	private static EagerInitialization instance;
	static {
		instance = new EagerInitialization();
	}
	private EagerInitialization() {
		
	}
	public static EagerInitialization getInstance() {
		return instance;
	}
}
