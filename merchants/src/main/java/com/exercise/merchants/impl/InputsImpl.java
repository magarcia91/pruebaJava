package com.exercise.merchants.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.exercise.merchants.Questions;
import com.exercise.merchants.constants.InvalidInput;
import com.exercise.merchants.interfaces.Inputs;
import com.exercise.merchants.util.Arabics;


public class InputsImpl implements Inputs {

	private List<Questions> allInputs;
	private Map<String, String> romanNumberMap; 	//It maps the word and the respective Roman letter
	private Map<String, Double> numberCreditMap; 	//It maps the credot and its value.
	
	
	public InputsImpl(){
		this.allInputs = new ArrayList<Questions>();
		this.romanNumberMap = new HashMap<String, String>();
		this.numberCreditMap = new HashMap<String, Double>();
	}

	public List<Questions> getInputs() {
		return allInputs;
	}
	
	public Map<String, String> getromanNumberMap() {
		return romanNumberMap;
	}

	public Map<String, Double> getnumberCreditMap() {
		return numberCreditMap;
	}
	
	private void romanMapping(Questions question) {
		romanNumberMap.put(question.getphrases()[0], question.getphrases()[2]);
	}
	
	private void invalidInputs() {
		System.out.println(InvalidInput.INVALID_INPUT);		
	}
	
	public void readInputs() {
		Scanner in = new Scanner(System.in);
    	while(in.hasNextLine()){   //read input text from console
    		String line = in.nextLine();    		
    		if(line.isEmpty()){ //validate end of a line
    			break;
    		}else{
    			this.allInputs.add(new Questions(line));
    		}
    	}
    	in.close();
	}

	// Questions based on the input type.
	public void manipulateInput() {
		for (Questions q : this.allInputs){
			switch (q.getType()){
				case DEFINE_ROMAN :
					romanMapping(q);
					break;
				case DEFINE_CREDITS :
					creditMapping(q);
					break;
				case QUESTION_HOW_MUCH :
					handleHowMuchQuery(q);
					break;
				case QUESTION_HOW_MANY :
					handleHowManyQuery(q);
					break;
				default :
					invalidInputs();
					break;					
			}
		}
	}
	
	
	private void handleHowManyQuery(Questions question) {
		double credit = 1;
		StringBuilder builder = new StringBuilder();
		StringBuilder answerBuilder = new StringBuilder();
		for(int i=4; i < question.getphrases().length-1; i++){
			String romanLetter = romanNumberMap.get(question.getphrases()[i]);
			if (romanLetter != null){				
				builder.append(romanLetter); //get the letter of a roman number
				answerBuilder.append(question.getphrases()[i] + " ");
			}else if (numberCreditMap.containsKey(question.getphrases()[i])){		
				credit = numberCreditMap.get(question.getphrases()[i]); //get the character of a credit map
				answerBuilder.append(question.getphrases()[i] + " ");				
			}else{		
				invalidInputs();
				return;
			}
		}
		int romanValue = Arabics.romanToArabic(builder.toString());
		Double creditsAnswer = new Double (romanValue * credit);
		answerBuilder.append("is " + creditsAnswer.intValue() + " Credits");		
		System.out.println(answerBuilder.toString());
	}


	private void handleHowMuchQuery(Questions question) {
		StringBuilder builder = new StringBuilder();
		StringBuilder answerBuilder = new StringBuilder();
		for(int i=3; i < question.getphrases().length-1; i++){
			String romanLetter = romanNumberMap.get(question.getphrases()[i]);
			if (romanLetter != null){				
				builder.append(romanLetter); //get the letter of a roman number
				answerBuilder.append(question.getphrases()[i] + " ");
			}else{				
				invalidInputs();
				return;
			}
		}
		int romanValue = Arabics.romanToArabic(builder.toString());
		answerBuilder.append("is " + romanValue);
		System.out.println(answerBuilder.toString());
	}


	private void creditMapping(Questions question) {
		StringBuilder builder = new StringBuilder();
		String unit = "";
		int credits = -1;
		for(String q : question.getphrases()){
			if (!q.equals("is") && !q.equals("Credits")){
				String romanLetter = romanNumberMap.get(q);
				if (romanLetter != null){
					builder.append(romanLetter);
				} else if (unit.isEmpty()){
					unit = q;
				} else{
					credits = Integer.parseInt(q);
				}
			}
		}
		int romanValue = Arabics.romanToArabic(builder.toString());
		double valueOfUnit = (double) credits/romanValue;
		numberCreditMap.put(unit, valueOfUnit);
		
	}

}
