package userInterface;
/*
 * Class initializes the UI and elements, also updating them as called.
 */
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
public class CreateWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// Initialize frame contents
	
	// Fonts
	
	
	// Constructor
	public CreateWindow() {
		// Set frame parameters
		setTitle("QuikCalcs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Calculate and set size to 60% of screen
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (size.width * .6);
		int height = (int) (size.height * .6);
		setSize(width,height);
		setLocationRelativeTo(null);
		
		// Set visible
		setVisible(true);
	}
	
	
}
