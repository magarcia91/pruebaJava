package com.exercise.merchants.constants;

public enum Romans {
	I (1),
	V (5),
	X (10),
	L (50),
	C (100),
	D (500),
	M (100);	

	private int roman;
	
	
	private Romans(int roman) {
		this.roman = roman;
	}


	public int getRoman() {
		return roman;
	}


	public void setRoman(int roman) {
		this.roman = roman;
	}


	public static Romans getLetter(final char character){
		for (Romans roman : Romans.values()){
			if (roman.name().charAt(0) == character){
				return roman;
			}
		}
		return null;
	}
	
}	
	




