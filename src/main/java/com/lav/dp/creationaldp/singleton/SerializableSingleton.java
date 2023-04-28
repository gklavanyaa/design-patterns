package com.lav.dp.creationaldp.singleton;

import java.io.Serializable;

public class SerializableSingleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 2276726317251276092L;

	private static SerializableSingleton instance;

	public SerializableSingleton() {
	}

	public static SerializableSingleton getInstance() {
		if (instance == null) {
			instance = new SerializableSingleton();
		}
		return instance;
	}

	//Singleton serialization problem is solved with this method
	public Object readResolve() {
		return instance;
	}
	
	//Clonable allows cloning the singleton object which can be stopped with this method
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
