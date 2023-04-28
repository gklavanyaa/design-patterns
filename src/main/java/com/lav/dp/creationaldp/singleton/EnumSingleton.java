package com.lav.dp.creationaldp.singleton;

public enum EnumSingleton {
	INSTANCE;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
