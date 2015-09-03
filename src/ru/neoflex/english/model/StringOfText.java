package ru.neoflex.english.model;

import java.util.Arrays;
import java.util.HashSet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringOfText {
	
	private String english;
	private String russian;
	
	private final StringProperty engString;
    private final StringProperty rusString;
    
    public StringOfText() {
        this(null, null);
    }
	
    public StringOfText(String engString, String rusString) {
        this.engString = new SimpleStringProperty(engString);
        this.rusString = new SimpleStringProperty(rusString);
    }
	public String getEnglishRandomString(){
		
		String arrStr[] = getEngString().split(" ");
		HashSet<String> strSet = new HashSet<String>(Arrays.asList(arrStr));
		StringBuilder result= new StringBuilder();
		for(String str:strSet){
			result.append(str+" ");
		}
		return result.toString()+".";
	}
	
	public String getEngDescription(){
		return getEngString().substring(0, 7)+"...";
	}
	
	public String getRusDescription(){
		return getRusString().substring(0, 7)+"...";
	}
	
	private int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

	public String getEngString() {
		return engString.get();
	}

	public String getRusString() {
		return rusString.get();
	}
	
	public void setRusString(String rusString){
			this.rusString.set(rusString);
		} 
	
	public void setEngString(String engString){
		this.engString.set(engString);
		} 
	
	public StringProperty engStringProperty() {
        return engString;
		}
	
	public StringProperty rusStringProperty() {
        return rusString;
		}
	}
	


