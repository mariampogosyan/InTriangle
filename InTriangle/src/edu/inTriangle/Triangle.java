package edu.inTriangle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class Triangle extends JPanel {
	private static final long serialVersionUID = 1L;
	private java.util.List<Point2D> in = new ArrayList<>();
	private java.util.List<Point2D> out = new ArrayList<>();
	Generator gnrt = new Generator(700);
	private double x, y;
		public Triangle() {
		super();
		setBackground(Color.WHITE);
		setLayout(null);
		MouseInputAdapter mil = new MyMouseInputListener();
		addMouseListener(mil);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g.create();
		g2d.setPaint(Color.BLUE);
		g2d.setStroke(new BasicStroke(1.5f));
		Shape s = getTriangle();
     		g2d.setPaint(Color.lightGray);
		g2d.fill(s);
		for (int i = 0; i < in.size(); i++) {
				Ellipse2D.Double inside = new Ellipse2D.Double(
					in.get(i).getX(),
					in.get(i).getY(),
					6.0,
					6.0
				);
				g2d.setPaint(Color.RED);
				g2d.fill(inside);
		}
		for (int i = 0; i < out.size(); i++) {
					Ellipse2D.Double outside = new Ellipse2D.Double(
						out.get(i).getX(),
						out.get(i).getY(),
						6.0,
						6.0
					);
					g2d.setPaint(Color.GREEN);
					g2d.fill(outside);
		}
		g2d.dispose();
	}
	private Shape getTriangle(){
		int x1 = gnrt.getX1();
		int y1 = gnrt.getY1();
		int x2 = gnrt.getX2();
		int y2 = gnrt.getY2();
		int x3 = gnrt.getX3();
		int y3 = gnrt.getY3();
		Shape s;
		s = new Path2D.Double();
		((Path2D) s).moveTo (x1, y1);
		((Path2D) s).lineTo (x2, y2);
		((Path2D) s).lineTo (x3, y3);
		((Path2D) s).closePath();
		return s;
	}
	protected void clearPoints() {
		in.clear();
		out.clear();
	}
	public boolean checkIfIn() {
		int x1 = gnrt.getX1();
		int y1 = gnrt.getY1();
		int x2 = gnrt.getX2();
		int y2 = gnrt.getY2();
		int x3 = gnrt.getX3();
		int y3 = gnrt.getY3();
		double denom = ((y2 - y3)*(x1 - x3) +(x3 - x2)*(y1 - y3));
		double a = ((y2 - y3)*(x - x3) + (x3 - x2)*(y - y3)) / denom;
		double b = ((y3 - y1)*(x - x3) + (x1 - x3)*(y - y3)) / denom;
		double c = 1 - a - b;
		if( 0 <= a && a <= 1 && 0 <= b && b <= 1 && 0 <= c && c <= 1) {
			return true;	
		} else {
			return false;
		}
	}
	protected void newTriangle() {
			gnrt = new Generator(700);
	}
	private class MyMouseInputListener extends MouseInputAdapter {
		@Override
		public void mouseReleased(MouseEvent me) {
			x = (double) me.getX();
			y = (double) me.getY();
			if(checkIfIn()){
				in.add(new Point2D.Double(x, y));
			} else {
				out.add(new Point2D.Double(x, y));
			}
			repaint();
		}
	}
}