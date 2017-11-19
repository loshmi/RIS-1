package mvc;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;

import rekapitulacija.Shape;

public class DrawingView extends JPanel{
	private DrawingModel model;
	
	public void setModel(DrawingModel model) {
		this.model = model;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(model != null) {
			Iterator<Shape> it = model.getShapes().iterator();
			while(it.hasNext()) {
				it.next().draw(g);
			}
			repaint();			
		}
		
	}

}
