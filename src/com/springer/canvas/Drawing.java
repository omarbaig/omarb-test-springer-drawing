//package com.springer.canvas;
//
//
///**
// * Creates Drawing in Java console based on input Inputs For Canvas : C w h
// * 
// * @author Omar
// * 
// */
//public class Drawing {
//
//	private static final String LINE_ERROR_LINE_HEIGHT_IS_EXCEEDS_CANVAS_HEIGHT = "Line height is exceeds Canvas height";
//	private static final String LINE_ERROR_HORIZONTAL_OR_VERTICAL_LINES_ARE_ONLY_SUPPORTED = "Horizontal or Vertical Lines are only supported";
//	private static final String LINE_ERROR_LINE_WIDTH_IS_EXCEEDS_CANVAS_WIDTH = "Line width is exceeds Canvas width";
//	private InputOperations inputOperations;
//	private PrintOperations printOperations;
//	
//	private Canvas canvas = null;
//
//	public Drawing(InputOperations inputOperations, PrintOperations printOperations) {
//		this.inputOperations = inputOperations;
//		this.printOperations = printOperations;
//		
//	}
//
//	/**
//	 * Main drawing method which gets the input parameters
//	 * identifies the shape specification
//	 * build an aggregates with existing shapes if applicable
//	 * prints the canvas with the shapes to the console
//	 * @throws DrawingException
//	 */
//	public void makeDrawing() throws DrawingException {
//		// get Input parameters
//		// List<ShapeSpec> shapeSpecs = new ArrayList<ShapeSpec>();
//		// identify shape - Canvas, Line, Square , Fill,  Quit
//		// get existing shapes set
//		// String[][] shapeInput = getShapeSpec(inputOperations.getInputParameters());
//		
//		// if not quit, save to list
//		// shapeSpecs.add(shapeSpec);
//		// build single dimensional array
//		// print
//		
//		
//		String[] inputParams = inputOperations.getInputParameters();
//		setCommandType(inputParams);
//		paintDrawing();
//
//	}
//
//	private void paintDrawing() {
//		canvas.paint();
//		
//	}
//
//	/**
//	 * Get Command type, investigate Command design, validate incoming
//	 * arguments, if met proceed, otherwise throw error Write initial test case
//	 * 
//	 * @param inputParams
//	 * @return
//	 * @throws DrawingException 
//	 */
//	private void setCommandType(String[] inputParams) throws DrawingException {
//		InputCommand command = null;
//		try{
//			command = InputCommand.valueOf(inputParams[0]);
//		}
//		catch(IllegalArgumentException ex)
//		{
//			throw new DrawingException(inputParams[0] + " is an invalid command ", ex);
//		}
//		switch (command) {
//		case C:
//			if(getCanvas() == null){
//				if(validateArgumentCount(command, inputParams, 2));
//					setCanvas(buildCanvas(inputParams));
//
//			}else {
//				throw new DrawingException("Canvas has already been created");
//			}
//			break;
//		case L:
//			if(getCanvas() == null){
//				throw new DrawingException("Canvas has to be created");
//			}
//			else
//			{
//				if(validateArgumentCount(command, inputParams, 4)){
//					if(validateLineParameters(inputParams) )
//					{
//						//getCanvas().addShape()
//					}
//				}
//			}
//			
//			break;
//		default:
//			throw new DrawingException("Comand not found");
//
//		}
//	}
//
//	private boolean validateLineParameters(String[] inputParams) throws DrawingException {
//		
//		int canvasWidth = getCanvas().getWidth();
//		int canvasHeight = getCanvas().getHeight();
//		int x1 = getInt(inputParams[1]);
//		int y1 = getInt(inputParams[2]);
//		int x2 =getInt(inputParams[3]);
//		int y2 = getInt(inputParams[4]);
//	
//		
//		if(validateStraightLine(x1, y1, x2, y2, LINE_ERROR_HORIZONTAL_OR_VERTICAL_LINES_ARE_ONLY_SUPPORTED))
//		{
//			if(x1 == x2)
//			{
//				if(validateLineLength(canvasHeight, y1, y2, LINE_ERROR_LINE_HEIGHT_IS_EXCEEDS_CANVAS_HEIGHT)){
//					
//				}
//			}
//			else
//			{
//				if(validateLineLength(canvasHeight, x1, x2, LINE_ERROR_LINE_WIDTH_IS_EXCEEDS_CANVAS_WIDTH)){
//					
//				}
//			}
//		}
//		
//		return false;
//	}
//
//	private boolean validateLineLength(int canvasDimension, int point1, int point2, String errorMessage)
//			throws DrawingException {
//		if(point2 - point1 > canvasDimension) {
//			throw new DrawingException(errorMessage);
//		}
//		return true;
//	}
//
//	/**
//	 * validates if input parameters for line or rectangle are straight
//	 * @param inputParams
//	 * @return
//	 * @throws DrawingException
//	 */
//	private boolean validateStraightLine(int x1, int y1, int x2, int y2, String errorMessage)
//			throws DrawingException {
//		if(x1!= x2)
//		{
//			if(y1!= y2)
//				throw new DrawingException(errorMessage);
//		}
//		return true;
//	}
//
//	private Canvas buildCanvas(String[] inputParams) throws DrawingException {
//		return new Canvas(printOperations, getInt(inputParams[1] ) + 2, getInt(inputParams[2]) + 2);
//		
//	}
//
//	/**
//	 * Converts String to int
//	 * @param stringParam
//	 * @return
//	 * @throws DrawingException
//	 */
//	private int getInt(String stringParam) throws DrawingException{
//		try{
//			return Integer.valueOf(stringParam).intValue();
//		}
//		catch(NumberFormatException ex){
//			throw new DrawingException("Parameter is invalid: " + ex);
//		}
//	}
//
//	/**
//	 * Validates the input parameters count associated with the command
//	 * @param commandType
//	 * @param inputParams
//	 * @param argumentCount
//	 * @return boolean
//	 * @throws DrawingException
//	 */
//	private boolean validateArgumentCount(InputCommand commandType, String[] inputParams, int argumentCount) throws DrawingException {
//		boolean isValid = false;
//		if(argumentCount ==inputParams.length-1)
//		{
//			isValid = true;
//		}
//		else
//		{
//			throw new DrawingException(commandType.getInput() + " does not have the required " + argumentCount + "arguments");
//		}
//		return isValid;
//		
//	}
//
//	public void setCanvas(Canvas canvas) {
//		this.canvas = canvas;
//	}
//
//	public Canvas getCanvas() {
//		return canvas;
//	}
//}
