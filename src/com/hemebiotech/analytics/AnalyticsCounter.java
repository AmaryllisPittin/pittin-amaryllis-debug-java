package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();
		
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		while(line != null) {
			symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
			line = reader.readLine();
		}
		reader.close();
		
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);
	}
	
}
