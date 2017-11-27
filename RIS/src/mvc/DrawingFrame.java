package mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class DrawingFrame extends JFrame{

	private DrawingView view = new DrawingView();
	private DrawingController controller;
	private JList lstLog = new JList();
	
	public DrawingView getView() {
		return view;
	}
	
	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	
	public DrawingFrame() {
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.viewMouseClicked(arg0);
			}
		});
		getContentPane().add(view, BorderLayout.CENTER);
		view.setBackground(Color.WHITE);
		
		JPanel pnlNorth = new JPanel();
		getContentPane().add(pnlNorth, BorderLayout.NORTH);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.save();
			}
		});
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.open();
			}
		});
		pnlNorth.add(btnOpen);
		pnlNorth.add(btnSave);
		
		JPanel pnlSouth = new JPanel();
		getContentPane().add(pnlSouth, BorderLayout.SOUTH);
		
		JScrollPane scrollPaneLog = new JScrollPane();
		pnlSouth.add(scrollPaneLog);
		
		
		scrollPaneLog.setViewportView(lstLog);
	}

	public JList getLstLog() {
		return lstLog;
	}

}
