package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Responsible for writing symptom data and their occurrences to the file result.out
 * 
 *Each entry is written in the format: "symptom: count", one per line
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	/**
	 * Create a new writer for a specific output file
	 * 
	 * @param outputFile the path to the file where symptoms will be written
	 */
	
	private String outputFile;
	
	public WriteSymptomDataToFile(String outputFile) {
		
		this.outputFile = outputFile;
		
	}
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		/**
		 * Write the symptoms and their corresponding occurrences to the output file
		 * 
		 * Each line in the file follows the format: "symptom: count"
		 * If an I/O error occurs, it is printed to the console
		 * 
		 * @param symptoms: a map containing symptoms as keys and their number of occurrences as values
		 */
		
		try (FileWriter writer = new FileWriter(outputFile)) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
