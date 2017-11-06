package rekapitulacija;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;


public class PnlDrawing extends JPanel{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void paint(Graphics g) {
		Iterator it = shapes.iterator();
		while(it.hasNext()) {
			
			Shape shape = (Shape) it.next();
			shape.draw(g);
		}
		repaint();
	}
}
