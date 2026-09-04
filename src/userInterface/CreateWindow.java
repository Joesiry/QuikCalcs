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
	JTabbedPane tabPane;
	JPanel ratioPane, resultsPane;
	JButton calculate;
	JLabel results, ratioTitle, resultsTitle;
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
		results = new JLabel("Result: ");
		results.setFont(font);
		ratioTitle = new JLabel("Ratio Calculation");
		ratioTitle.setFont(font);
		resultsTitle = new JLabel("All Results: ");
		resultsTitle.setFont(font);
		
		// Text Fields
		input1 = new JTextField();
		
		input2 = new JTextField();
		
		// Panels
		tabPane = new JTabbedPane();
		resultsPane = new JPanel();
		resultsPane.add(resultsTitle);
		
		ratioPane = new JPanel();
		ratioPane.add(ratioTitle);
		
		
		// Calculate and set size to 40% of screen
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (size.width * .4);
		int height = (int) (size.height * .4);
		setSize(width,height);
		setLocationRelativeTo(null);
		
		// Add components and set visible
		add(tabPane);
		tabPane.addTab("Ratio", ratioPane);
		tabPane.addTab("History", resultsPane);
		
		//addComponents(getContentPane());
		setVisible(true);
	}
	
	// Helper method that adds components to frame
	private void addComponents(Container pane) {
		
	}
	
}
