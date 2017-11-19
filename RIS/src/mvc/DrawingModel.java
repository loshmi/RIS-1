package mvc;

import java.util.ArrayList;

import rekapitulacija.Shape;

public class DrawingModel {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public Shape get(int i) {
		return shapes.get(i);
	}
	
}
