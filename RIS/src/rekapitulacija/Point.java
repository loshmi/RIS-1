package rekapitulacija;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Point extends Shape implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6623965826167030877L;
	private int x;
	private int y;
	
	public Point() {
		super();
	}
	public Point(int x, int y, Color color) {
		super(color);
		this.x = x;
		this.y = y;
	}
	
	public void metoda() {
		System.out.println("metoda");
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x-1, y, x+1, y);
		g.drawLine(x, y-1, x, y+1);
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int x, int y) {
		this.x += x;
		this.y = this.y + y;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point point = (Point)obj;
			if (x==point.getX() && y==point.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public String toString()
	{
		return "("+x+","+y+")";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}
