package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Class for symptoms parsing
 * 
 * Read the symptoms through an ISymptomReader, counts their occurrences, sort the results
 * in alphabetical order, then write the results through ISymptomWriter
 */

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	/**
	 * 
	 * @param reader instance to read the symptoms
	 * @param writer instance to write results
	 */
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Retrieve list of symptoms from the reader
	 * 
	 * @return a list of symptoms (strings)
	 */
	
	public List<String> getSymptoms() {
		
		return reader.GetSymptoms();
		
	}
	
	/**
	 * Count the number of occurrences of each symptom of the given list
	 * 
	 * The symptoms are cleaned (trimmed and converted to lowercase) before counting
	 * 
	 * @param symptoms: list of symptoms to count
	 * @return a map associating each symptom with its number of occurrences
	 */
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		
		Map<String, Integer> symptomCounts = new HashMap<>();
		for(String symptom : symptoms) {
			
			String cleanSymptom = symptom.trim().toLowerCase();
			symptomCounts.put(cleanSymptom, symptomCounts.getOrDefault(cleanSymptom, 0) + 1);
			
		}
		
		return symptomCounts;
	}
	
	/**
	 * sort the symptoms in alphabetical order
	 * 
	 * @param symptoms map of symptoms to count
	 * @return a new map sorted (TreeMap) containing symptoms and their occurrences
	 */
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		
		return new TreeMap<>(symptoms);
		
	}
	
	/**
	 * Execute the complete processing: reading, counting, sorting and writing of symptoms
	 * 
	 * Displays the steps in the console
	 */
	
	public void analyzeSymptoms() {
		
		List<String> symptoms = getSymptoms();
		 System.out.println(" Symptômes lus : " + symptoms);
		 
		Map<String, Integer> symptomCounts = countSymptoms(symptoms);
		 System.out.println(" Comptage : " + symptomCounts);
		 
		Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);
		System.out.println("Trié : " + sortedSymptoms);
		
		writer.writeSymptoms(sortedSymptoms);

	}
	
}
