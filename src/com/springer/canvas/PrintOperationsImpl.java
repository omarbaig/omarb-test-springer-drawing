package com.springer.canvas;

/**
 * Prints output to console
 * @author Omar
 *
 */
public class PrintOperationsImpl implements PrintOperations {

	
	@Override
	public void print(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}

}
