package userInterface;
/*
 * Class initializes the UI and elements, also updating them as called.
 */
import javax.swing.*;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
public class CreateWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// Initialize frame contents
	JButton calculate;
	JLabel results;
	JTextField input1, input2;
	
	// Fonts
	private Font font = new Font("Comfortaa", Font.PLAIN, 20);
	
	
	// Constructor
	public CreateWindow() {
		// Set frame parameters
		setTitle("QuikCalcs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Buttons
		calculate = new JButton();
		
		// Labels
		results = new JLabel();
		
		// Text Fields
		input1 = new JTextField();
		
		input2 = new JTextField();
		
		
		// Calculate and set size to 60% of screen
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (size.width * .6);
		int height = (int) (size.height * .6);
		setSize(width,height);
		setLocationRelativeTo(null);
		
		// Set visible
		setVisible(true);
	}
	
	// Helper method that adds components to fram
	private void addComponents(Container pane) {
		// Create Layout
		//TODO Is box layout good?
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		// Add components
	}
	
}
