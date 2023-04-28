package com.lav.dp.creationaldp.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSingleton {

	public static void main(String[] args) {
		System.out.println("--------Issue with lazy Initialization--------");
		DateUtil dateUtil1 = DateUtil.getInstance();
		DateUtil dateUtil2 = DateUtil.getInstance();
		
		if(dateUtil1 == dateUtil2) {
			System.out.println("These are the same instances from singleton, but by lazy initialization");
		}
		
		System.out.println("--------Issue with Eager Initialization--------");
		EagerInitialization eg1 = EagerInitialization.getInstance();
		EagerInitialization eg2 = EagerInitialization.getInstance();
		
		if(eg1 == eg2) {
			System.out.println("These are the same instance from singleton, but by eager initialization.");
		}
		
		//Issue with Serializable
		System.out.println("--------Issue with Serializable--------");
		SerializableSingleton s1 = SerializableSingleton.getInstance();
		SerializableSingleton s2;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			oos.writeObject(s1);
			
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Object.ser"));
			s2 = (SerializableSingleton) ois.readObject();
			
			if(s1 == s2) {
				System.out.println("These are the same instance from singleton.");
			} else {
				System.out.println("These are not the same instance from singleton.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		

		//Issue with reflection solving reflection problem
		System.out.println("--------Issue with reflection--------");
		EnumSingleton instance = EnumSingleton.INSTANCE;
		System.out.println("Instance of enum with nothing assigned : "+instance.getName());
		instance.setName("Lavanya");
		System.out.println("Instance of enum with name assigned : "+instance.getName());
	}

}
