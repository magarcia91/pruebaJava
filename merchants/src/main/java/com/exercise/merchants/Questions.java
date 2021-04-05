package com.exercise.merchants;

import com.exercise.merchants.constants.QuestionsType;
import com.exercise.merchants.constants.Romans;

public class Questions {
	
	private String questions;
	private String[] phrases; 	//Get the questions splitted 

	//Instance a new question
	public Questions(String line) {
		this.questions = line.trim();
		this.phrases = line.trim().split("\\s+");
	}
	
	public String getquestions() {
		return questions;
	}

	public void setquestions(String questions) {
		this.questions = questions;
	}
		
	public String[] getphrases() {
		return phrases;
	}

	public void setphrases(String[] phrases) {
		this.phrases = phrases;
	}	

	//Gets question type.	
	public QuestionsType getType() {
		
		//validate the repetitions of roman number
		if (this.phrases.length == 3 && this.phrases[1].equals("is") &&	Romans.getLetter(this.phrases[2].charAt(0)) != null){
			return QuestionsType.DEFINE_ROMAN;
		}
		
		//validate the 4th repetitions of roman number
		if (this.phrases.length > 4 && this.phrases[this.phrases.length-1].equals("Credits") &&
			this.phrases[this.phrases.length-2].matches("\\d+") &&
			this.phrases[this.phrases.length-3].equals("is")){
			return QuestionsType.DEFINE_CREDITS;
		}
		// Validate the type of questions
		if (this.phrases[this.phrases.length-1].equals("?")){
			if (this.phrases.length > 4 && 	this.questions.startsWith("how much is")){
				return QuestionsType.QUESTION_HOW_MUCH;	
			}else if(this.phrases.length > 5 &&  this.questions.startsWith("how many Credits is")){
				return QuestionsType.QUESTION_HOW_MANY;
			}
		}
		
		return QuestionsType.INVALID_INPUT;
	}
	
}
