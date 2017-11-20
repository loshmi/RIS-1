package command;
import command.Command;
import mvc.DrawingModel;
import rekapitulacija.Point;

public class CmdAddPoint implements Command {

	private DrawingModel model;
	private Point point;
	 
	public CmdAddPoint(DrawingModel model, Point point) {
		this.model = model;
		this.point = point;
	}

	@Override
	public void execute() {
		model.add(point);
		
	}

	@Override
	public void unexecute() {
		model.remove(point);
	}

}
