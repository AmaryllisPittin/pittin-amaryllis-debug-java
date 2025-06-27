package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() {
		
		return reader.GetSymptoms();
		
	}
	
	public void analyzeSymptoms() {
		
		List<String> symptoms = getSymptoms();	
		Map<String, Integer> symptomCounts = new HashMap<>();
		
		for(String symptom : symptoms) {
			
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
			
		}
		
		writer.writeSymptoms(symptomCounts);

	}
	
	public static void main(String[] args) {
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		counter.analyzeSymptoms();
		
	}
	
}
