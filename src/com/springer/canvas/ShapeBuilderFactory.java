package com.springer.canvas;

public class ShapeBuilderFactory {
	public ShapeBuilder createShapeBuilder(InputCommand inputCommand) throws DrawingException
	{
		
		switch (inputCommand) {
				case C:
		//			if(canvas== null){
						return new CanvasBuilder(true);
						//setCanvas(buildCanvas(inputParams));
		
//					}else {
//						throw new DrawingException("Canvas has already been created");
//					}
					
		//		case L:
		//			if(getCanvas() == null){
		//				throw new DrawingException("Canvas has to be created");
		//			}
		//			else
		//			{
		//				if(validateLineParameters(inputParams) )
		//				{
		//						//getCanvas().addShape()
		//					
		//				}
		//			}
		//			
		//			break;
				case Q: 
					System.exit(0);
				default:
					throw new DrawingException("Comand not found");
		
				}
	}
}

