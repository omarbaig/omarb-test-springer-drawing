package com.springer.canvas;

public interface InputOperations {
	//public String[] getInputParameters() throws DrawingException;
	public String[] scanInputParamters() throws DrawingException;
	public void closeReader() throws DrawingException;
	
}
