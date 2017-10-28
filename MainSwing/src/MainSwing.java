import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author gabrielferraz
 * building interfaces by hand is a laborious task since the developer has to build every component on the GUI
 * We can use Google's window builder to take care of those trivial tasks for us
 */
public class MainSwing extends JFrame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		JFrame myMainFrame = new MainSwing();
		myMainFrame.setVisible(true);  // make frame visible
		
		// set the frame layout; see more options here: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
		myMainFrame.setLayout(new FlowLayout());
		
		/**
		 * create container
		 */
		myMainFrame.setTitle("I am the title");
		myMainFrame.setLocation(400, 250); // location on the viewport
		myMainFrame.setSize(500, 500); // GUI size
		
		// exit application when frame is closed
		myMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		/**
		 * create a panel for the container and add it to the container
		 */
		JPanel panel = new JPanel();
		// myMainFrame.add(panel);
		
		/**
		 * create components and add to the container -- can also put containers inside containers
		 */
		JButton myButtonOne = new JButton("Click here");
		JButton myButtonTwo = new JButton("Click here");
		JButton myButtonThree = new JButton("Click here");
		myMainFrame.add(myButtonOne);
		myMainFrame.add(myButtonTwo);
		myMainFrame.add(myButtonThree);
		
		/**
		 * click adds click events to buttons
		 */
		myButtonOne.addActionListener(new MyButtonHandler());
		
		/**
		 * adds listener via anonymous class that implements the ActionListener interface
		 * 
		 */
		myButtonTwo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("I am the other button");
			}
		});
	}
	
	
	/**
	 * 
	 * @author Gabriel Ferraz
	 * Handles click events
	 * has to be static because it is an inner class of MainSwing being instantiated inside a static method
	 */
	static class MyButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Button clicked");
			System.out.println(e);
		}
		
	}

}



