package com.exercise.merchants;

import com.exercise.merchants.impl.InputsImpl;
import com.exercise.merchants.interfaces.Inputs;

//Manage Inputs objects.
public class InputsHandle {

	//Gets the input test	
	public Inputs getInputs(String inputType){
		if (inputType == null){
			return null;
		}
		if (inputType.equalsIgnoreCase("MERCHANTS")){
			return new InputsImpl();
		}
		
		return null;
	}
}
