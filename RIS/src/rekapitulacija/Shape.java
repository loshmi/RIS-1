package rekapitulacija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable{
	private Color color;
	
	public Shape(Color color) {
		this.color = color;
	}
	
	public abstract void draw(Graphics g);
	
	public Color getBoja() {
		return color;
	}

	public void setBoja(Color color) {
		this.color = color;
	}
	
	
}
