package command;

import java.awt.Color;

import mvc.DrawingModel;
import rekapitulacija.Point;

public class TestCommand {

	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		Point point = new Point(10, 10, Color.BLACK);
		CmdAddPoint c1 = new CmdAddPoint(model, point);
		c1.execute();
		System.out.println(model.get(0));
		
		c1.unexecute();
		c1.execute();
		System.out.println(model.getShapes().size());
		CmdRemovePoint c2 = new CmdRemovePoint(model, point);
		c2.execute();
		c2.unexecute();
		System.out.println(model.getShapes().size());
		
		Point point2 = new Point(20, 30, Color.BLUE);
		System.out.println(model.get(0));
		CmdUpdatePoint c3 = new CmdUpdatePoint(point, point2);
		c3.execute();
		System.out.println(model.get(0));
		c3.unexecute();
		System.out.println(model.get(0));
		
	}

}
