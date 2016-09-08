/**
 * 
 */
package com.springer.canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Extracts input parameters and identifies command types based on the Input
 * Commands (enum) - CANVAS("C"), LINE("L"), RECTANGLE("R"), BUCKET_COLOUR("B"),
 * QUIT("Q");
 * 
 * @author Omar
 * 
 */
public class InputOperatonsImpl implements InputOperations {
	BufferedReader br = null;

	public InputOperatonsImpl() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	private String[] getInputParameters() throws DrawingException {
		String input = null;
		String[] params = null;

		try {
			input = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}

		params = input.split(" ");

		if (params != null && params.length > 0) {
			return params;
		}
		throw new DrawingException("Input valid commands");

	}

	@Override
	public String[] scanInputParamters() throws DrawingException {
		String[] params = null;
//		try {
//			while (true) {
				System.out.println();
				System.out.print("enter command: ");
				return getInputParameters();
//			}
//		} catch (IOException e) {
//			throw new DrawingException("Error reading in input parameters");
//		}
		

	}

	@Override
	public void closeReader() throws DrawingException {
		if(br != null)
			try {
				br.close();
			} catch (IOException e) {
				throw new DrawingException("Error closing Reader");
			}	
	}
	
	
}
