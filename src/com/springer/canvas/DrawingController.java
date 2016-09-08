package com.springer.canvas;

public class DrawingController {
	
	private static final String LINE_ERROR_LINE_HEIGHT_IS_EXCEEDS_CANVAS_HEIGHT = "Line height is exceeds Canvas height";
	private static final String LINE_ERROR_HORIZONTAL_OR_VERTICAL_LINES_ARE_ONLY_SUPPORTED = "Horizontal or Vertical Lines are only supported";
	private static final String LINE_ERROR_LINE_WIDTH_IS_EXCEEDS_CANVAS_WIDTH = "Line width is exceeds Canvas width";
	
	private InputOperations inputOperations;
	private PrintOperations printOperations;
	private ShapeBuilderFactory shapeBuilderFactory;
	
	private ShapeBuilder shapeBuilder;
	
	private Canvas canvas = null;
	
	public DrawingController(InputOperations inputOperations,
			PrintOperations printOperations, ShapeBuilderFactory shapeBuilderFactory) {
		this.inputOperations = inputOperations;
		this.printOperations = printOperations;
		this.shapeBuilderFactory = shapeBuilderFactory;
	}
	
	public void makeDrawing(String[] inputParams) throws DrawingException
	{
		InputCommand inputCommand = getCommand(inputParams[0]);
		shapeBuilder = shapeBuilderFactory.createShapeBuilder(inputCommand);
	
		int[] validatedArguments = validateAndExtractInputParamters(inputCommand, inputParams);
//		if(!isCanvasExisting(){
//			
//		}
		//Canvas canvasResult = shapeBuilder.buildShape(validatedArguments);
		String[] results = shapeBuilder.buildCanvasWithShapes(validatedArguments);
		printOperations.print(results);
		return;
	}
		
	
	private InputCommand getCommand(String inputParam) throws DrawingException {
		InputCommand command = null;
		try{
			command = InputCommand.valueOf(inputParam);
		}
		catch(IllegalArgumentException ex)
		{
			throw new DrawingException(inputParam + " is an invalid command ", ex);
		}
		return command;
	}
	
	private int[] validateAndExtractInputParamters(InputCommand command, String[] inputParams) throws DrawingException
	{
		if(command.getArgumentCount() != inputParams.length-1)
		{
			throw new DrawingException(command.getInput() + " does not have the required " + command.getArgumentCount() + "arguments");
		}
		return getValidIntegerArray(inputParams);
	}
	
	/**
	 * Converts String array parameter to integer array parameters
	 * @param inputParams
	 * @return
	 * @throws DrawingException
	 */
	private int[] getValidIntegerArray(String[] inputParams) throws DrawingException{
		int[] validIntegerArray = new int[inputParams.length-1];
		int count = 0;
		for(int i = 1; i < inputParams.length; i++)
		{
			validIntegerArray[count] = getInt(inputParams[i]);
			count++;
		}
		return validIntegerArray;
	}
	
	/**
	 * Converts String to int
	 * @param stringParam
	 * @return
	 * @throws DrawingException
	 */
	private int getInt(String stringParam) throws DrawingException{
		try{
			return Integer.valueOf(stringParam).intValue();
		}
		catch(NumberFormatException ex){
			throw new DrawingException("Parameter is invalid: " + ex);
		}
	}
	
	
	
	

//	private void buildShapeSpec()
//		switch (command) {
//		case C:
//			if(getCanvas() == null){
//				//if(validateArgumentCount(command, inputParams, 2));
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
//		return null;
//	}
	

	public InputOperations getInputOperations() {
		return inputOperations;
	}

	public void setInputOperations(InputOperations inputOperations) {
		this.inputOperations = inputOperations;
	}

	public PrintOperations getPrintOperations() {
		return printOperations;
	}

	public void setPrintOperations(PrintOperations printOperations) {
		this.printOperations = printOperations;
	}

	
	
	

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setShapeBuilderFactory(ShapeBuilderFactory shapeBuilderFactory) {
		this.shapeBuilderFactory = shapeBuilderFactory;
	}

	public ShapeBuilderFactory getShapeBuilderFactory() {
		return shapeBuilderFactory;
	}

	public ShapeBuilder getShapeBuilder() {
		return shapeBuilder;
	}

	public void setShapeBuilder(ShapeBuilder shapeBuilder) {
		this.shapeBuilder = shapeBuilder;
	}

	/**
	 * @param args
	 * @throws DrawingException 
	 */
	public static void main(String[] args) throws DrawingException {
		InputOperations inputOperations = new InputOperatonsImpl();
		PrintOperations printOperations = new PrintOperationsImpl();
		DrawingController controller = new DrawingController(inputOperations, printOperations, new ShapeBuilderFactory());
		String[] inputParams = inputOperations.scanInputParamters();
		controller.makeDrawing(inputParams);
		
		
		// tool.setCommandType() contains validator
		// validate command
		// validate numbers 
		//String[][] canvasSpec = createCommandSpec(tool.setCommandType());

	}

	
	
	
	

	

}
