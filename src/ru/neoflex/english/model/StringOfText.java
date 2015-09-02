package ru.neoflex.english.model;

import java.util.Arrays;
import java.util.HashSet;

public class StringOfText {
	
	private String english="They are from England";
	private String russian;
	
	public String getEnglishRandomString(){
		//String str = getEnglish();
		String arrStr[] = getEnglish().split(" ");
		HashSet<String> strSet = new HashSet<String>(Arrays.asList(arrStr));
		StringBuilder result= new StringBuilder();
		for(String str:strSet){
			result.append(str+" ");
		}
		return result.toString()+".";
	}
	
	public String getDescription(){
		return english.substring(0, 7)+"...";
	}
	
	private int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	

	public String getRussian() {
		return russian;
	}

	public void setRussian(String russian) {
		this.russian = russian;
	}



	public String getEnglish() {
		return english;
	}



	public void setEnglish(String english) {
		this.english = english;
	}
	public static  void main(String[] arg){
		System.out.println(new StringOfText().getDescription());
		String m = new StringOfText().getEnglishRandomString();
		System.out.println(m);
		
	}

}
