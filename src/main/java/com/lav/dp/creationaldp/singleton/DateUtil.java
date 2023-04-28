package com.lav.dp.creationaldp.singleton;

/*
 * Singleton pattern cab be achieved in 3 below steps
 * 1. Having a private constructor
 * 2. Having a private static variable
 * 3. Having a public getInstance method that returns the instance of this class
 * 
 * e.g : logger, DB connection data source, Property file reader
 */
public class DateUtil {
	
	//This is lazy initialization, only when required it is being created
	//Preffered mostly 
	private static DateUtil instance;
	private DateUtil() {
		
	}
	public static DateUtil getInstance() {
		if(instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}
}
