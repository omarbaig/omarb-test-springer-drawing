package com.springer.canvas;


/**
 * Creates Drawing in Java console based on input Inputs For Canvas : C w h
 * 
 * @author Omar
 * 
 */
public class Drawing {

	private InputOperations operations;

	public Drawing(InputOperations operations) {
		this.operations = operations;
	}

	public void makeDrawing() throws CanvasException {
		String[] inputParams = operations.getInputParameters();
		getCommandType(inputParams);

	}

	/**
	 * Get Command type, investigate Command design, validate incoming
	 * arguments, if met proceed, otherwise throw error Write initial test case
	 * 
	 * @param inputParams
	 * @return
	 * @throws CanvasException 
	 */
	private void getCommandType(String[] inputParams) throws CanvasException {
		InputCommands command = null;
		try{
			command = InputCommands.valueOf(inputParams[0]);
		}
		catch(IllegalArgumentException ex)
		{
			throw new CanvasException(inputParams[0] + " is an invalid command ", ex);
		}
		switch (command) {
		case C:
			if(validateArgumentCount(command, inputParams, 2));
				drawCanvas(inputParams);
			break;
		default:
			throw new CanvasException("Comand not found");

		}
	}

	private void drawCanvas(String[] inputParams) {
		// TODO Auto-generated method stub
		
	}

	private boolean validateArgumentCount(InputCommands commandType, String[] inputParams, int argumentCount) throws CanvasException {
		boolean isValid = false;
		if(argumentCount ==inputParams.length-1)
		{
			isValid = true;
		}
		else
		{
			throw new CanvasException(commandType.getInput() + " does not have the required " + argumentCount + "arguments");
		}
		return isValid;
		
	}
}
