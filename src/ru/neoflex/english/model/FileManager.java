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
			    System.out.println(key+" "+value.getEngString()+" "+value.getRusString()+" "+value.getEnglishRandomString());
			 
			}
		
		
	}
	
	private String formatString(String str,int j){
		String[] str0 = str.split(" ");
		StringBuilder strb= new StringBuilder();
		for(int i= 0;i<str0.length;i++){
			if ( (i!= 0)&&((i % j) == 0)){
				strb.append(str0[i]+"\n");
			}
			else strb.append(str0[i]+" ");
		}
		return strb.toString();
	}
	
	private StringOfText parseLine(String line){
		StringOfText  strText = null;
		String[] str = line.split("\\|");
		
		strText= new StringOfText(formatString(str[0],4),formatString(str[1],2));
		
		return strText;
	}
	
	public Map<Integer,StringOfText> readFile(File file) throws Exception{
		String line;
		if(file == null) {
			file = new File("C:\\Users\\kshahin\\workspace\\EnglishApp\\src\\ru\\neoflex\\english\\model\\EnglishTranslate.txt");
		}
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		int i = 0;
		Map<Integer,StringOfText>  map = new  HashMap<Integer,StringOfText>();
	    while ((line = br.readLine()) != null) {
	    	if(line.split("\\|").length == 2){
	    	map.put(new Integer(i), parseLine(line));
	    	i++;
	    	}
	    }
	    return map;
	}
}
