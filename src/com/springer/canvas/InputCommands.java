/**
 * 
 */
package com.springer.canvas;

/**
 * Commmand Input Types and Number of arguments
 * @author Omar
 * 
 */
public enum InputCommands {
	C ("CANVAS",2), L("LINE",4), R("RECTANGLE",4), B("BUCKET_COLOUR",3), Q("QUIT",0);

	String input = "";
	int argumentCount = 0;
	private InputCommands(String command, int args) {
		this.input = command;
		this.argumentCount= args;
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
