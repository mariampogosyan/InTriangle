package edu.inTriangle;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton btn;
	Triangle tri;
	public TFrame() {
		super("Random Triangle");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		tri = new Triangle();
		btn = new JButton("New Triangle");
		btn.addActionListener(al);
		add(tri, BorderLayout.CENTER);
		add(btn, BorderLayout.NORTH);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}	
	private ActionListener al = ae -> {
			tri.clearPoints();
			tri.newTriangle();
			repaint();
	};
	public static void main(String[] sa) {
		EventQueue.invokeLater(
				() -> new TFrame()
		);
	}
}
