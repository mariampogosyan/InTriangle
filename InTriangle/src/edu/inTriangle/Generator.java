package edu.inTriangle;

import java.util.Random;

public class Generator {
	private int x1, y1, 
				x2, y2, 
				x3, y3;
	private double det;
	private Random rand = new Random();
	public Generator(int i) {
		 while (getDet()== 0.0) {
			x1 = rand.nextInt(i);
			y1 = rand.nextInt(i);
			x2 = rand.nextInt(i);
			y2 = rand.nextInt(i);
			x3 = rand.nextInt(i);
			y3 = rand.nextInt(i);
		 }; 
	}
	protected double getDet() {
		det = x1*(y2 - y3) - y1*(x2 - x3) + (x2*y3 - x3*y2);
		return det;
	}
	protected int getX1() {
		return this.x1;
	}
	protected int getY1() {
		return this.y1;
	}	
	protected int getX2() {
	  return this.x2;
	}
	protected int getY2() {
	  return this.y2;
	}
	protected int getX3() {
	  return this.x3;
	}
	protected int getY3() {
	  return this.y3;
	}
}	
