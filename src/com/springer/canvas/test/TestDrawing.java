package com.springer.canvas.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.springer.canvas.DrawingException;
import com.springer.canvas.Drawing;
import com.springer.canvas.InputOperations;


public class TestDrawing {
	
	@Test
	public void testValidCanvasDrawing() throws DrawingException{
		
		String[] input  = {"C","1","2"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
		drawing.makeDrawing();
		assertNotNull(drawing.getCanvas());
		assertTrue(1==drawing.getCanvas().getWidth());
		assertTrue(2==drawing.getCanvas().getHeight());
		
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidCommand() throws DrawingException
	{
		String[] input  = {"Invalid","1","2"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
		drawing.makeDrawing();
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidCreateMoreThanOneCanvas() throws DrawingException
	{
		String[] input  = {"C","1","2"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
		drawing.makeDrawing();
		assertNotNull(drawing.getCanvas());
		drawing.makeDrawing();
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidArgumentForCanvas() throws DrawingException
	{
		String[] input  = {"C","invalid","invalid"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
		drawing.makeDrawing();
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidArgumentCountForCanvas() throws DrawingException
	{
		String[] input  = {"C","invalid"};
		InputOperations operations = getMockInputOperations(input);
		Drawing drawing = new Drawing(operations);
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

}
