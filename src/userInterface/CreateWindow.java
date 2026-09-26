package userInterface;
/*
 * Class initializes the UI and elements, also updating them as called.
 */
import javax.swing.*;

//import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class CreateWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// Initialize frame contents
	JTabbedPane tabPane;
	JPanel ratioPane, resultsPane, inputPane;
	JButton calculate;
	JLabel results, ratioTitle, resultsTitle, inputTitle;
	JTextField input1, input2;
	
	// Fonts
	private Font font = new Font("Comfortaa", Font.PLAIN, 20);
	private Font smallFont = new Font("Comfortaa", Font.PLAIN, 12);
	private Font bigFont = new Font("Comfortaa", Font.PLAIN, 35);
	
	
	// Constructor
	public CreateWindow() {
		// Set frame parameters
		setTitle("QuikCalcs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Buttons
		calculate = new JButton("Calculate Results");
		calculate.setFont(bigFont);
		calculate.addActionListener(new calculateAction());
		
		// Labels
		results = new JLabel("Results: ");
		results.setFont(font);
		inputTitle = new JLabel("Input two numbers below and press \"Calculate Results\"");
		inputTitle.setFont(font);
		ratioTitle = new JLabel("Ratio Calculation");
		ratioTitle.setFont(font);
		resultsTitle = new JLabel("Previous Results: ");
		resultsTitle.setFont(font);
		
		// Text Fields
		input1 = new JTextField("First number");
		input1.setFont(bigFont);
		input1.addActionListener(new calculateAction());
		input1.addKeyListener(new keyInput());
		
		
		input2 = new JTextField("Second number");
		input2.setFont(bigFont);
		input2.addActionListener(new calculateAction());
		input2.addKeyListener(new keyInput());
		
		// Panels
		tabPane = new JTabbedPane();
		inputPane = new JPanel();
		inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.PAGE_AXIS));
		inputPane.add(inputTitle);
		inputPane.add(input1);
		inputPane.add(input2);
		inputPane.add(calculate);
		
		
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
		tabPane.addTab("Inputs", inputPane);
		tabPane.addTab("Ratio", ratioPane);
		tabPane.addTab("History", resultsPane);
		
		//addComponents(getContentPane());
		setVisible(true);
	}
	
	// Action listener for when calculate button is pressed
	private class calculateAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			System.out.println("Performing calculations...");
			
			// TODO Insert calls to all calculations here
			try {
				
				
				// All complete
				calculate.setText("Calculations complete!");
				System.out.println("Calculations complete");
			} catch (Exception ex) { 
				// Fall back if no expected exceptions are caught
				System.out.print("Error: No expected exceptions caught.");
				calculate.setText("Unexpected error, please check input");
				return;
			}
			
		}
		
	}
	
	// Key listener for when user types inside input fields
	private class keyInput implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// Resets calculate button text to reflect new input
			calculate.setText("Calculate Results");
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	}
	
}
