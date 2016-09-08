package com.springer.canvas;

public class CanvasBuilder extends ShapeBuilder {

	private boolean isBlank = false;
	public CanvasBuilder(boolean isBlank) {
		this.isBlank = isBlank;
	}

//	@Override
//	public Canvas buildShape(int[] parameters) throws DrawingException {
//        if(isCanvasSetUpValid())
//        {
//        	if(validateShapeParameters(parameters))
//    		{
//    			canvas = createShape(parameters);
//    		}
//        }
//        else //if(!isBlank && canvas!=null)
//        {
//            // applicable to when Fill Option has been selected, extract boolean isBlank from new Canvas object
//        	canvas.addFill();
//        }
//		
//		
//		return canvas;
//	}

	
	protected void createShape(int[] parameters) throws DrawingException {
		canvas =  new Canvas(parameters[0] + 2, parameters[1] + 2);
		//return new Canvas(parameters[0], parameters[1]);
	}

	protected boolean validateShapeParameters(int[] parameters) throws DrawingException{
		if(parameters[0] < 3 || parameters[1] < 3){
			// On a canvas of 2 x 2, there is no space for shapes, hence exception thrown  
			throw new DrawingException("Canvas has to have a width or heigth greater than 2 for content to be added");
		}
		return true;
		
	}
	
//	public String[] buildCanvasWithShapes(Canvas canvas) {
//		int width = canvas.getWidth();
//		int height = canvas.getHeight();
//		buildBoundaries(width, height)
//		return null;
//	}

	
	
	/**
	 * Paints Canvas in console -- requires rethink
	 */
//	public void paint() {
//		
//		String[][] boundary = buildBoundaries());
//		
//		if(shapes == null){
//			// 
//		}
//		
//		// convert to one dimensional array
//		//operations.print(buildLineArray());
//		
//	}
	
	
	
	
	protected boolean isCanvasSetUpValid() throws DrawingException
	{
		if(isBlank && canvas != null)
        {
        	throw new DrawingException("Canvas has already been created");
        	
        }
        else if(!isBlank && canvas==null)
        {
        	throw new DrawingException("Fill option is invalid as Canvas has not been created");
        }
		return true;
	}

}
