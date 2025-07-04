package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface representing method of writing symptoms and their frequency.
 * 
 * Allowing the saving of a list of symptoms and their number of occurrences in result.out.
 */

public interface ISymptomWriter {
	
	/**
	 * Write symptoms and number of occurrences
	 * 
	 * @param symptoms: A map containing the symptoms as keys and their number of occurrence as values
	 **/
	
	void writeSymptoms(Map<String, Integer> symptoms);

}
