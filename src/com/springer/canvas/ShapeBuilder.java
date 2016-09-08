package com.springer.canvas;

/**
 * Validates and Builds shapes
 * @author Omar
 *
 */
public abstract class ShapeBuilder {
	protected Canvas canvas = null;
	protected String[][] canvasBoundary;
//	boolean isCanvasExisting(){
//		
//	}

	//protected abstract boolean validateShapeParameters(int[] parameters);
	
	//protected abstract Shape createShape(int[] parameters);
	
	protected void buildShape(int[] parameters) throws DrawingException
	{
		if(isCanvasSetUpValid())
		{
			if(validateShapeParameters(parameters))
			{
				createShape(parameters);
			}
				
		}
	}
	
	protected abstract boolean validateShapeParameters(int[] parameters) throws DrawingException;
	
	protected abstract void createShape(int[] parameters) throws DrawingException;

	protected abstract boolean isCanvasSetUpValid() throws DrawingException;
	
	public String[] buildCanvasWithShapes(int[] parameters) throws DrawingException {
		buildShape(parameters);
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		String[][] rawCanvas = getCanvasBoundary(width, height);
		
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
	
	private  String[][] getCanvasBoundary(int width, int height ){
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

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public void setCanvasBoundary(String[][] canvasBoundary) {
		this.canvasBoundary = canvasBoundary;
	}
	public String[][] getCanvasBoundary() {
		return canvasBoundary;
	}
	
	

}
