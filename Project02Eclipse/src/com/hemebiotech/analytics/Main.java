package com.hemebiotech.analytics;

/**
 * Main class of the symptom processing application
 * 
 * It initializes the reading, parsing, and writing components and starts the complete parsing process
 */

public class Main {
	
	/**
	 * Entry point of the application
	 * 
	 * Initialize the reader and the writer of the symptoms, create an AnalyticsCounter object and start
	 * the parsing process
	 */
	
	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		counter.analyzeSymptoms();
		
	}

}
