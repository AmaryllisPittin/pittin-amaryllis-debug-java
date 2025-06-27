package com.hemebiotech.analytics;

<<<<<<< HEAD:src/com/hemebiotech/analytics/WriteSymptomDataToFile.java
=======
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

>>>>>>> 4cd5190 (result.out generated):Project02Eclipse/src/com/hemebiotech/analytics/WriteSymptomDataToFile.java
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String outputFile;
	
	public WriteSymptomDataToFile(String outputFile) {
		
		this.outputFile = outputFile;
		
	}
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		try (FileWriter writer = new FileWriter(outputFile)) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
