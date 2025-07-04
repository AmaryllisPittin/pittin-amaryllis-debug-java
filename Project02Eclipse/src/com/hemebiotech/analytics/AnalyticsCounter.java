package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

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
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		
		Map<String, Integer> symptomCounts = new HashMap<>();
		for(String symptom : symptoms) {
			
			String cleanSymptom = symptom.trim().toLowerCase();
			symptomCounts.put(cleanSymptom, symptomCounts.getOrDefault(cleanSymptom, 0) + 1);
			
		}
		
		return symptomCounts;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		
		return new TreeMap<>(symptoms);
		
	}
	
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
