package com.springer.canvas.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.springer.canvas.CanvasException;
import com.springer.canvas.Drawing;
import com.springer.canvas.InputOperations;


public class TestDrawing {
	
	@Test
	public void testValidCanvasDrawing() throws CanvasException{
		
		String[] input  = {"C","1","2"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
		drawing.makeDrawing();
		
	}
	
	@Test(expected=CanvasException.class)
	public void testInvalidCommand() throws CanvasException
	{
		String[] input  = {"Invalid","1","2"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
		drawing.makeDrawing();
	}

	private InputOperations getMockInputOperations(final String[] input) {
		return new InputOperations() {
			
			@Override
			public String[] getInputParameters() throws CanvasException {
				return input;
			}
		};
	}

}
