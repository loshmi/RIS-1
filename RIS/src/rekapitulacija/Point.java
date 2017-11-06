package rekapitulacija;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	
	public Point(int x, int y, Color color) {
		super(color);
		this.x = x;
		this.y = y;
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
