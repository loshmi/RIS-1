package rekapitulacija;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDrawing extends JFrame {

	private PnlDrawing pnlDrawing;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlDrawing.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlDrawing);

		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point point = new Point(e.getX(), e.getY(), Color.BLUE);
				pnlDrawing.getShapes().add(point);
			}
		});
	}
}
