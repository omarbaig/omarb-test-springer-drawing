/**
 * 
 */
package com.springer.canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Extracts input parameters and identifies command types
 * based on the Input Commands (enum) - CANVAS("C"), LINE("L"), RECTANGLE("R"), BUCKET_COLOUR("B"), QUIT("Q");
 * 
 * @author Omar
 *
 */
public class InputOperatonsImpl implements InputOperations {
	BufferedReader br = null;

	public InputOperatonsImpl() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String[] getInputParameters() throws DrawingException
	{
		String input = null;
		String[] params = null;
		try{
			while(br.ready()){
				try {
					input = br.readLine().trim();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		catch(IOException e)
		{
			throw new DrawingException("Error reading in input parameters");
		}
		
		params = input.split(" ");

		if(params!=null && params.length>0)
		{
			return params;
		}
		throw new DrawingException("Input valid commands");
		
		
	}
}
