package com.exercise.merchants;

import com.exercise.merchants.impl.InputsImpl;
import com.exercise.merchants.interfaces.Inputs;

//Handle the kinds of inputs
public class InputsManager {

	//Get the input text
	private Inputs inputs;
	
	//Instance a new input
	public InputsManager(){
		inputs = new InputsImpl();
	}
	
	public void handleInputs(){
		this.inputs.readInputs();
		this.inputs.manipulateInput();		
	}
}
