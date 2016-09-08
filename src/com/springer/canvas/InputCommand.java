/**
 * 
 */
package com.springer.canvas;

/**
 * Commmand Input Types and Number of arguments
 * @author Omar
 * 
 */
public enum InputCommand {
	C ("CANVAS",2), Q ("QUIT",0);//, L("LINE",4, new LineBuilder()), R("RECTANGLE",4, new RectangleBuilder()), B("BUCKET_COLOUR",3, new CanvasBuilder(true)), Q("QUIT",0,null);

	String input = "";
	int argumentCount = 0;
	ShapeBuilder shapeBuilder = null;
	
	private InputCommand(String command, int argumentCount) {
		this.input = command;
		this.argumentCount= argumentCount;
	}



	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public int getArgumentCount() {
		return argumentCount;
	}

	public void setArgumentCount(int argumentCount) {
		this.argumentCount = argumentCount;
	}
}
