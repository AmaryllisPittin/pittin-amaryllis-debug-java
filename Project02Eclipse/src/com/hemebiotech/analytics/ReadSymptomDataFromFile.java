package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	/**
	 * Read the file located at the specified path and return the list of symptoms
	 * 
	 * Each line of the file is a distinct symptom
	 **/
	
	@Override
	public List<String> getSymptoms() {
		
		/**
		 * Read the symptoms file and return the list of symptoms
		 * 
		 * Handles cases where the file is missing or empty by returning an empty list
		 * 
		 * @return a list of symptoms (strings), never null.
		 **/
		
		final ArrayList<String> result = new ArrayList<>();
		
		
		if (filepath != null) {	
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
