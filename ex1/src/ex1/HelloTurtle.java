package ex1;

import intro.ex1.*;

public class HelloTurtle {
	
/*
 * 
 * this function draw lines of different colors 
 * all the lines started at the same point (where the turtle is when the function called)
 * all the lines have the width and length specified and the angle between them as specified
 * the function returns 0 in case of success,1 when turtle is not initialized or 2 when it gets no colors
 * when finished drawing, the turtle will be at the same place but the other states as they was
 * cause there is no way to get them...
 */
	public static int lines(IntroTurtle turtle,int width,int length,int angle,int[] colors)
	{
		//some checks before we draw
		if (turtle == null)
			return 1;
		if (colors.length == 0)
				return 2;
		
		//to avoid recalculating...
		//java sin() function get radiant, no degrees, so i needed to convert
		int sz = (int) Math.round(length*Math.sin(Math.PI*angle/360)*2), angl = 90+(angle)/2 ,angl2 = 180-angle;
		turtle.setPenSize(width);
		turtle.penDown();
		for(int i=0;i<colors.length;i++){
			turtle.setPenColor(colors[i]);
			turtle.forward(length);
			turtle.penUp();
			i++;
			if (i == colors.length)
			{
				//the end of the array
				turtle.back(length);
				break;
			}
			turtle.right(angl);
			turtle.forward(sz);
			turtle.right(angl);
			turtle.penDown();
			turtle.setPenColor(colors[i]);
			turtle.forward(length);
			turtle.left(angl2);
		}
		//return success code
		return 0;
	}
	
	//program entry point
	public static void main(String[] args) {
		IntroTurtle jurgen = new IntroTurtle();
		int[] Colors = {4,14,6,2,1,13}; //to change the colors or their order, just edit this
		
		jurgen.hideTurtle();

		//the triangle
		jurgen.left(90);
		jurgen.penDown();
		jurgen.forward(100);
		jurgen.right(120);
		jurgen.forward(200);
		jurgen.right(120);
		jurgen.forward(200);
		jurgen.right(120);
		jurgen.forward(100);
		jurgen.right(60);
		
		//the light ray
		jurgen.penUp();
		jurgen.forward(100);
		jurgen.penDown();
		jurgen.left(75);
		jurgen.forward(120);
		jurgen.penUp();
		jurgen.left(173);
		jurgen.forward(218);
		jurgen.right(37);
		
		//the rainbow :)
		lines(jurgen,5,120,2,Colors);
	}

}