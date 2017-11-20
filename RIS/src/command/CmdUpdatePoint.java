package command;

import rekapitulacija.Point;

public class CmdUpdatePoint implements Command{
	private Point original;
	private Point newState;
	private Point oldState = new Point();
	
	public CmdUpdatePoint(Point original, Point newState) {
		this.original = original;
		this.newState = newState;
	}

	@Override
	public void execute() {
		oldState.setX(original.getX());
		oldState.setY(original.getY());
		oldState.setBoja(original.getBoja());
		
		original.moveTo(newState.getX(), newState.getY());
		original.setBoja(newState.getBoja());
	}

	@Override
	public void unexecute() {
		original.setX(oldState.getX());
		original.setY(oldState.getY());
		original.setBoja(oldState.getBoja());
	}
}
