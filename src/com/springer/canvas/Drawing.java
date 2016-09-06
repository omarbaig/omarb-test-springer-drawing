package com.springer.canvas;


/**
 * Creates Drawing in Java console based on input Inputs For Canvas : C w h
 * 
 * @author Omar
 * 
 */
public class Drawing {

	private InputOperations operations;
	
	private Canvas canvas = null;

	public Drawing(InputOperations operations) {
		this.operations = operations;
	}

	public void makeDrawing() throws DrawingException {
		String[] inputParams = operations.getInputParameters();
		setCommandType(inputParams);
		paintDrawing();

	}

	private void paintDrawing() {
		canvas.paint();
		
	}

	/**
	 * Get Command type, investigate Command design, validate incoming
	 * arguments, if met proceed, otherwise throw error Write initial test case
	 * 
	 * @param inputParams
	 * @return
	 * @throws DrawingException 
	 */
	private void setCommandType(String[] inputParams) throws DrawingException {
		InputCommands command = null;
		try{
			command = InputCommands.valueOf(inputParams[0]);
		}
		catch(IllegalArgumentException ex)
		{
			throw new DrawingException(inputParams[0] + " is an invalid command ", ex);
		}
		switch (command) {
		case C:
			if(getCanvas() == null){
				if(validateArgumentCount(command, inputParams, 2));
					setCanvas(buildCanvas(inputParams));

			}else {
				throw new DrawingException("Canvas has already been created");
			}
			break;
		default:
			throw new DrawingException("Comand not found");

		}
	}

	private Canvas buildCanvas(String[] inputParams) throws DrawingException {
		return new Canvas(getInt(inputParams[1]), getInt(inputParams[2]));
		
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

	/**
	 * Validates the input parameters count associated with the command
	 * @param commandType
	 * @param inputParams
	 * @param argumentCount
	 * @return boolean
	 * @throws DrawingException
	 */
	private boolean validateArgumentCount(InputCommands commandType, String[] inputParams, int argumentCount) throws DrawingException {
		boolean isValid = false;
		if(argumentCount ==inputParams.length-1)
		{
			isValid = true;
		}
		else
		{
			throw new DrawingException(commandType.getInput() + " does not have the required " + argumentCount + "arguments");
		}
		return isValid;
		
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}
}
