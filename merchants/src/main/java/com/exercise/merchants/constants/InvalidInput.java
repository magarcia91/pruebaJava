package com.exercise.merchants.constants;

public enum InvalidInput {
	
	INVALID_INPUT(0, "I have no idea what you are talking about");

	private final int id;
	private final String desc;
	
	private InvalidInput(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	@Override
	public String toString() {
		return desc;
	}

}
