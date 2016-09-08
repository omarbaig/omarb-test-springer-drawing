package com.springer.canvas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.springer.canvas.Canvas;
import com.springer.canvas.DrawingController;
import com.springer.canvas.DrawingException;
import com.springer.canvas.InputOperations;
import com.springer.canvas.PrintOperations;
import com.springer.canvas.ShapeBuilderFactory;


public class TestDrawing {
	
//	@InjectMocks
//	PrintOperations mockPrintOperations;
//	
	@Test
	public void testValidEmptyCanvasDrawing() throws DrawingException{
		
		String[] input  = {"C","10","16"};
		DrawingController drawing = setUpDrawing(input);
		drawing.makeDrawing(input);
		assertNotNull(getCanvas(drawing));
		assertTrue(12==getCanvas(drawing).getWidth());
		assertTrue(18==getCanvas(drawing).getHeight());

		String[] expectedBoundary = getCanvasEmptyArray();
		
		ArgumentCaptor<String[]> argumentCaptor = ArgumentCaptor.forClass(String[].class);
		verify(drawing.getPrintOperations()).print(argumentCaptor.capture());
		String[] boundary = argumentCaptor.getValue();
		
		for(int i= 0; i < 18; i++){
			assertEquals(expectedBoundary[i], boundary[i]);
		}
	
//		for(int i= 0; i < 18; i++){
//			for(int j = 0; j < 12; j++){
//				assertEquals(expectedBoundary[i][j], boundary[i][j]);
//				//assertEquals(i + " " + j + " expected: " + expectedBoundary[i][j] + ", but was " + boundary[i][j], expectedBoundary[i][j], boundary[i][j]);
//			}

		
	}


	

	@Test(expected=DrawingException.class)
	public void testInvalidCommand() throws DrawingException
	{
		String[] input  = {"Invalid","1","2"};
		DrawingController drawing = setUpDrawing(input);
		drawing.makeDrawing(input);
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidCreateMoreThanOneCanvas() throws DrawingException
	{
		String[] input  = {"C","1","2"};
		DrawingController drawing = setUpDrawing(input);
		drawing.makeDrawing(input);
		assertNotNull(drawing.getCanvas());
		drawing.makeDrawing(input);
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidArgumentForCanvas() throws DrawingException
	{
		String[] input  = {"C","invalid","invalid"};
		DrawingController drawing = setUpDrawing(input);
		drawing.makeDrawing(input);
	}
	
	@Test(expected=DrawingException.class)
	public void testInvalidArgumentCountForCanvas() throws DrawingException
	{
		String[] input  = {"C","invalid"};
		DrawingController drawing = setUpDrawing(input);
		drawing.makeDrawing(input);
	}
	
//	@Ignore
//	public void testValidLineOnCanvas() throws DrawingException
//	{
//		String[] input  = {"L","1","2","6","2"};
//		Drawing drawing = setUpDrawing(input);
//		drawing.setCanvas(new Canvas(12,18));
//		drawing.getCanvas().setCanvasBoundary(getCanvasEmptyArray());
//		
//		drawing.makeDrawing();
//		assertNotNull(drawing.getCanvas());
//		drawing.makeDrawing();
//	}
	
	private Canvas getCanvas(DrawingController drawing) {
		return drawing.getShapeBuilder().getCanvas();
	}


	private DrawingController setUpDrawing(String[] input) {
		PrintOperations mockPrintOperations = mock(PrintOperations.class);
		InputOperations inputOperations = getMockInputOperations(input);
		ShapeBuilderFactory shapeBuilderFactory = new ShapeBuilderFactory();
		
		
		
		DrawingController drawing = new DrawingController(inputOperations, mockPrintOperations, shapeBuilderFactory);
		return drawing;
	}

	private InputOperations getMockInputOperations(final String[] input) {
		return new InputOperations() {
			@Override
			public String[] scanInputParamters() throws DrawingException {
				return input;
			}

			@Override
			public void closeReader() throws DrawingException {
				System.out.println("Reader closed");
				
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

//	private String[][] getCanvasEmptyArray() {
//		String[][] expectedBoundary = {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|"},
//									   {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};
//		return expectedBoundary;
//	}
//	
	private String[] getCanvasEmptyArray(){
		String[] expectedBoundary = {"------------", 
									 "|          |", "|          |", "|          |", "|          |", "|          |", 
									 "|          |", "|          |", "|          |", "|          |", "|          |", 
									 "|          |", "|          |", "|          |", "|          |", "|          |", 
									 "|          |", "------------"};
		return expectedBoundary;
	}
}
