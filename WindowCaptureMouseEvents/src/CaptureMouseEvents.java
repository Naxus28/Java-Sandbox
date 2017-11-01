import java.awt.EventQueue;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class CaptureMouseEvents {

	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaptureMouseEvents window = new CaptureMouseEvents();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaptureMouseEvents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// create frame and bounds and default close operation
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create label and set horizontal alignment
		label = new JLabel("Frame Label");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		// adds label to the "North" of the layout
		frame.getContentPane().add(label, BorderLayout.NORTH);
		
		// pass MouseHandler to frame's mouse listener
		// if the parent class CaptureEvents was the one implementing the  
		// MouseListener interface (and we would have implement the interfaces' methods on CaptureEvents)
		// we could pass 'this' into addMouseListener
		frame.addMouseListener(new MouseHandler());
	}
	
	/**
	 * 
	 * @author gabrielferraz
	 * class that handles mouse events
	 */
	private class MouseHandler implements MouseListener {
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			label.setText("Mouse Clicked");
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			label.setText("Mouse Pressed");
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			label.setText("Mouse Released");
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			label.setText("Mouse Entered");
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			label.setText("Mouse Exited");
		}
	}
	
}
