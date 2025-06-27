<<<<<<< HEAD
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();
		
		System.out.println("Lecture du fichier symptoms.txt...");
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		while(line != null) {
			symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
			line = reader.readLine();
		}
		reader.close();
		System.out.println("Lecture terminée. Nombre de symptômes : " + symptomCounts.size());
		
		System.out.println("Écriture dans result.out...");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);
		System.out.println("Fichier écrit !");
	}

	
}
=======
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		Map<String, Integer> symptomCounts = new HashMap<>();
		
		System.out.println("Lecture du fichier symptoms.txt...");
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		while(line != null) {
			symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
			line = reader.readLine();
		}
		reader.close();
		System.out.println("Lecture terminée. Nombre de symptômes : " + symptomCounts.size());
		
		System.out.println("Écriture dans result.out...");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);
		System.out.println("Fichier écrit !");
	}

	
}
>>>>>>> dev-latest
