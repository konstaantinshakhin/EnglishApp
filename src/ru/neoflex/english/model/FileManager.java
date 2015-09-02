package ru.neoflex.english.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FileManager {
	

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 Map<Integer,StringOfText> map =  new FileManager().readFile(null);
		 for(Entry<Integer,StringOfText> entry : map.entrySet()) {
			    Integer key = entry.getKey();
			    StringOfText value = entry.getValue();
			    System.out.println(key+" "+value.getEnglish()+" "+value.getRussian()+" "+value.getEnglishRandomString());
			 
			}
		
		
	}
	
	private StringOfText parseLine(String line){
		String[] str = line.split("\\.");
		StringOfText  strText= new StringOfText();
		strText.setEnglish(str[0]);
		strText.setRussian(str[1]);
		return strText;
	}
	
	public Map<Integer,StringOfText> readFile(String fileName) throws Exception{
		String line;
		if(fileName == null) {
			fileName = "C:\\Users\\kshahin\\workspace\\EnglishApp\\src\\ru\\neoflex\\english\\model\\EnglishTranslate.txt";
		}
		FileReader fileReader = new FileReader(new File(fileName));
		BufferedReader br = new BufferedReader(fileReader);
		int i = 0;
		Map<Integer,StringOfText>  map = new  HashMap<Integer,StringOfText>();
	    while ((line = br.readLine()) != null) {
	    	map.put(new Integer(i), parseLine(line));
	    	i++;
	    }
	    return map;
	}
}
