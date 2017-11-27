package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import command.CmdAddPoint;
import rekapitulacija.Point;

public class DrawingController {
	private DrawingModel model;
	private DrawingFrame frame;
	private FileHandler fileHandler;
	public final static Logger LOGGER = Logger.getLogger("logger");
	DefaultListModel<String> dlm = new DefaultListModel<String>();

	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
		this.frame.getLstLog().setModel(dlm);
		try {
			File dir = new File("C:\\RIS");
			dir.mkdir();
			String fileName = "C:\\RIS\\log_"+System.currentTimeMillis()+".log";
			File file = new File(fileName);
			if(!file.exists())
				file.createNewFile();
			fileHandler = new FileHandler(fileName);
			LOGGER.addHandler(fileHandler);
			LOGGER.setLevel(Level.INFO);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void viewMouseClicked(MouseEvent arg0) {
		//model.getShapes().add(new Point(arg0.getX(), arg0.getY(), Color.RED));
		CmdAddPoint cmd = new CmdAddPoint(model, new Point(arg0.getX(), arg0.getY(), Color.RED));
		cmd.execute();
		LOGGER.log(Level.INFO, cmd.toString());
		dlm.add(0,cmd.toString());
	}
	public void save() {
		LOGGER.addHandler(fileHandler);
		JOptionPane.showMessageDialog(frame, "Saved!");
	}

	public void open() {
		// The name of the file to open.
		JFileChooser jfc = new JFileChooser("C:\\RIS");
		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			// This will reference one line at a time
			String line = null;
			model.getShapes().clear();
			dlm.clear();
			try {
				// FileReader reads text files in the default encoding.
				FileReader fileReader = new FileReader(selectedFile.getAbsolutePath());
				// Always wrap FileReader in BufferedReader.
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while((line = bufferedReader.readLine()) != null) {
					if(line.contains("message")) {
						int x = Integer.parseInt(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						int y = Integer.parseInt(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						CmdAddPoint cmd = new CmdAddPoint(model, new Point(x, y, Color.BLUE));
						cmd.execute();
						dlm.add(0,cmd.toString());
					}
					frame.getView().repaint();	
				}   
				// Always close files.
				bufferedReader.close();         
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
