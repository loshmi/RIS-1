package mvc;

import java.io.Serializable;
import java.util.ArrayList;

import rekapitulacija.Shape;

public class DrawingModel implements Serializable{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	public Shape get(int i) {
		return shapes.get(i);
	}

	public boolean add(Shape shape) {
		return shapes.add(shape);
	}

	public boolean remove(Shape shape) {
		
		 return shapes.remove(shape);
	}
	
}
