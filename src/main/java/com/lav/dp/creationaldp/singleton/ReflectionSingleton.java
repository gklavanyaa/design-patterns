package com.lav.dp.creationaldp.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingleton {

	public static void main(String[] args) {
		DateUtil instance1 = DateUtil.getInstance();
		DateUtil instance2 = null;
		
		//Get the constructors
		Constructor[] declaredConstructors = DateUtil.class.getDeclaredConstructors(); 
		for (Constructor constructor : declaredConstructors) {
			//Provide complete access and create instance
			constructor.setAccessible(true);
			try {
				instance2 = (DateUtil) constructor.newInstance();
				break;
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("instance1 Hashcode : "+instance1.hashCode());
		System.out.println("instance2 Hashcode : "+instance2.hashCode());
		if(instance1 == instance2) {
			System.out.println("These are the same instances.");
		} else {
			System.out.println("These are not the same instances.");
		}
	}

}
