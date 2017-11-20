package command;

import mvc.DrawingModel;
import rekapitulacija.Point;

public class CmdRemovePoint implements Command {

	private DrawingModel model;
	private Point point;
	
	public CmdRemovePoint(DrawingModel model, Point point) {
		this.point = point;
		this.model = model;
	}
	
	@Override
	public void execute() {
		model.remove(point);
	}

	@Override
	public void unexecute() {
		model.add(point);
	}

}
