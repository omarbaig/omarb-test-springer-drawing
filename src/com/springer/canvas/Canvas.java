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
	
	
	public Canvas(int width, int height) throws DrawingException {
		if(width == 0 || height == 0){
			throw new DrawingException("Canvas has to have a width or heigth greater than 0");
		}
		this.width = width;
		this.height = height;
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
		
//		String[][] boundaries = new String[height-1][];
//		for (int i = 0; i < boundaries[0].length; i++) {
//			for (int j = 0; j < boundaries.length; j++) {
//				
//			}
//		}
//		
//		if(shapes == null){
//			// 
//		}
//		
//		
		
	}
	
//	private  String[] buildTopOrBottomBoundary(){
//		String[] boundary = new String[width];
//		for(int i= 0; i < width; i++){
//			boundary[i] = "-";
//		}
//		return boundary;
//		
//	}
	
	

}
