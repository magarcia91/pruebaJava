package com.exercise.merchants.util;

import com.exercise.merchants.constants.Romans;

public final class Arabics {
    

	public static int romanToArabic(String romanNumber) {
        int arabic = 0, auxNumber = 0;
        for (int i = romanNumber.length() - 1; i >= 0 ; i--) {
            Romans roman = Romans.getLetter(romanNumber.charAt(i));
            if (roman != null){
	            arabic = getArabic(roman.getRoman(), auxNumber, arabic);            
	            auxNumber = roman.getRoman();
            }
        }
        return arabic;
    }


    private static int getArabic(int arabic, int auxNumber, int auxArabic) {
        if (auxNumber > arabic){
            return auxArabic - arabic;
        } 
        
        return auxArabic + arabic;
    }
}
