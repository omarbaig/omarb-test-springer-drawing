package com.springer.canvas;

import java.util.List;

/**
 * Canvas Class has collections of layers with Shapes - Line, Rectangle
 * @author Omar
 *
 */
public class Canvas {
	
	private int width;
	private int height;
	private String[][] canvasBoundary;
	private PrintOperations operations;
	
	
	public Canvas(int width, int height) throws DrawingException {
		if(width == 2 || height == 2){
			// On a canvas of 2 x 2, there is no space for shapes, hence exception thrown  
			throw new DrawingException("Canvas has to have a width or heigth greater than 0");
		}
		this.width = width;
		this.height = height;
	}
	
	public Canvas(PrintOperations operations, int width, int height) throws DrawingException {
		this(width,height);
		this.operations = operations;
		
	}

	private List<Shape> shapes = null;
	
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	public List<Shape> getShapes() {
		return shapes;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Paints Canvas in console -- requires rethink
	 */
	public void paint() {
		
		setCanvasBoundary(buildBoundaries());
		
		if(shapes == null){
			// 
		}
		
		// convert to one dimensional array
		operations.print(buildLineArray());
		
	}
	
	private  String[][] buildBoundaries(){
		String[][] boundary = new String[height][width];
		
		for(int i= 0; i < height; i++){
			for(int j = 0; j < width; j++)
			{
				if(i==0 || i==height-1)
				{
					boundary[i][j] = "-";
				}
				else
				{
					if(j==0 || j==width-1)
					{
						boundary[i][j] = "|";
					}
					else
					{
						boundary[i][j] = " ";
					}
				}
			}
		}
		return boundary;
	}
	
	private String[] buildLineArray() {
		String[][] rawCanvas = getCanvasBoundary();
		String[] canvasLines = new String[height];
		
		for(int i = 0; i < height; i++)
		{
			canvasLines[i] = buildLine(rawCanvas[i], width);
			
		}
		return canvasLines;
	}
	
	
	private String buildLine(String[] rawCanvas, int width) {
		StringBuilder builder = new StringBuilder();
		for(int j = 0; j < width; j++)
		{
			builder.append(rawCanvas[j]);
		}
		return builder.toString();
	}
	/**
	 * Constructs the boundaries as lines of text 
	 * @param width
	 * @param isTopOrBottomWall
	 * @return
	 */
	private String buildLines(int width, boolean isTopOrBottomWall) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < width; i++)
		{
			if(isTopOrBottomWall)
			{
				builder.append("_");
			}
			else
			{
				if(i==0 || i== width-1)
				{
					builder.append("|");
				}
				else
				{
					builder.append(" ");
				}
				
			}
			
			
		}
		return builder.toString();
	}
	public void setCanvasBoundary(String[][] canvasBoundary) {
		this.canvasBoundary = canvasBoundary;
	}
	public String[][] getCanvasBoundary() {
		return canvasBoundary;
	}
	
	
	

}
