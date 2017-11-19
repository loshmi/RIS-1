package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;

import rekapitulacija.Point;

public class DrawingController {
	private DrawingModel model;
	private DrawingFrame frame;

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}

	public void viewMouseClicked(MouseEvent arg0) {
		model.getShapes().add(new Point(arg0.getX(), arg0.getY(), Color.RED));
	}

}
