package com.springer.canvas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.springer.canvas.Canvas;
import com.springer.canvas.Drawing;
import com.springer.canvas.DrawingException;
import com.springer.canvas.InputOperations;
import com.springer.canvas.PrintOperations;


public class TestDrawing {
	
	@Test
	public void testValidEmptyCanvasDrawing() throws DrawingException{
		
		String[] input  = {"C","10","16"};
		Drawing drawing = setUpDrawing(input);
		drawing.makeDrawing();
		assertNotNull(drawing.getCanvas());
		assertTrue(12==drawing.getCanvas().getWidth());
		assertTrue(18==drawing.getCanvas().getHeight());
		
		String[][] boundary = drawing.getCanvas().getCanvasBoundary();
		
		String[][] expectedBoundary = getCanvasEmptyArray();
				
		for(int i= 0; i < 18; i++){
			for(int j = 0; j < 12; j++){
				assertEquals(expectedBoundary[i][j], boundary[i][j]);
				//assertEquals(i + " " + j + " expected: " + expectedBoundary[i][j] + ", but was " + boundary[i][j], expectedBoundary[i][j], boundary[i][j]);
			}
			
		}
		
	}


	private Drawing setUpDrawing(String[] input) {
		InputOperations inputOperations = getMockInputOperations(input);
		PrintOperations printOperations = getMockPrintOperations();
		
		Drawing drawing = new Drawing(inputOperations, printOperations);
		return drawing;
	}

	@Test(expected=DrawingException.class)
	public void testInvalidCommand() throws DrawingException
	{
		String[] input  = {"Invalid","1","2"};
		Drawing drawing = setUpDrawing(input);
		drawing.makeDrawing();
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidCreateMoreThanOneCanvas() throws DrawingException
	{
		String[] input  = {"C","1","2"};
		Drawing drawing = setUpDrawing(input);
		drawing.makeDrawing();
		assertNotNull(drawing.getCanvas());
		drawing.makeDrawing();
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidArgumentForCanvas() throws DrawingException
	{
		String[] input  = {"C","invalid","invalid"};
		Drawing drawing = setUpDrawing(input);
		drawing.makeDrawing();
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidArgumentCountForCanvas() throws DrawingException
	{
		String[] input  = {"C","invalid"};
		Drawing drawing = setUpDrawing(input);
		drawing.makeDrawing();
		
	}
	
	@Ignore
	public void testValidLineOnCanvas() throws DrawingException
	{
		String[] input  = {"L","1","2","6","2"};
		Drawing drawing = setUpDrawing(input);
		drawing.setCanvas(new Canvas(12,18));
		drawing.getCanvas().setCanvasBoundary(getCanvasEmptyArray());
		
		drawing.makeDrawing();
		assertNotNull(drawing.getCanvas());
		drawing.makeDrawing();
	}

	private InputOperations getMockInputOperations(final String[] input) {
		return new InputOperations() {
			
			@Override
			public String[] getInputParameters() throws DrawingException {
				return input;
			}
		};
	}
	
	private PrintOperations getMockPrintOperations() {
		return new PrintOperations() {
			
			@Override
			public void print(String[] lines) {
				System.out.println("finished");
				
			}
		};
	}
	
	//Test results

	private String[][] getCanvasEmptyArray() {
		String[][] expectedBoundary = {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
									   {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};
		return expectedBoundary;
	}
	

}
