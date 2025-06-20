package com.hemebiotech.analytics;

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
