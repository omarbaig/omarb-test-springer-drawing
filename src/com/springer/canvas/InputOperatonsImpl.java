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
	
	public String[] getInputParameters() throws CanvasException
	{
		String input = null;
		try {
			input = br.readLine().trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] params = input.split(" ");

		if(params!=null && params.length>0)
		{
			return params;
		}
		throw new CanvasException("Input valid commands");
		
		
	}
	
	

	public void drawCanvas(){
		String input = "";
		
		
	}


}
