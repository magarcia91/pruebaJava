package com.exercise.merchants;

import com.exercise.merchants.interfaces.Inputs;

/**
 * Autor: Miguel García
 *
 */
public class MechantsApp 
{
    public static void main( String[] args )
    {
    	InputsHandle inputsHandle = new InputsHandle();
    	Inputs inputText =  inputsHandle.getInputs("MERCHANTS");
    	System.out.println("Please type all input test lines:");
    	inputText.readInputs();
    	System.out.println("The answers to your input test are:\n");
    	inputText.manipulateInput();
    }
}
