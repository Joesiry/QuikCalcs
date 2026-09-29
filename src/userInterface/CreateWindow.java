package userInterface;
/*
 * Class initializes the UI and elements, also updating them as called.
 */
import javax.swing.*;
import calculator.Calculations;
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
	
	int resultCounter;
	// Declare frame contents
	JTabbedPane tabPane;
	JPanel ratioPane, historyPane, inputPane;
	JButton calculate;
	JLabel results, ratioTitle, historyTitle, inputTitle, ratioDescription;
	JTextField input1, input2;
	JTable historyTable, ratioResults;
	
	// Fonts
	private Font font = new Font("Comfortaa", Font.PLAIN, 20);
	private Font smallFont = new Font("Comfortaa", Font.PLAIN, 12); // TODO Remove font if not used
	private Font bigFont = new Font("Comfortaa", Font.PLAIN, 35);
	
	
	// Constructor
	public CreateWindow() {
		// Set global variables
		resultCounter = 0;
		
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
		ratioTitle.setFont(bigFont);
		ratioDescription = new JLabel("Results are (in order): Smallest common divisor, simple 1:x");
		ratioDescription.setFont(font);
		historyTitle = new JLabel("Previous Numbers: ");
		historyTitle.setFont(bigFont);
		
		// Text Fields
		input1 = new JTextField("First number");
		input1.setFont(bigFont);
		input1.addActionListener(new calculateAction());
		input1.addKeyListener(new keyInput());
		
		input2 = new JTextField("Second number");
		input2.setFont(bigFont);
		input2.addActionListener(new calculateAction());
		input2.addKeyListener(new keyInput());
		
		// Tables
		historyTable = new JTable(10, 1);
		historyTable.setFont(font);
		historyTable.setRowHeight(20);;
		
		ratioResults = new JTable(3, 1);
		ratioResults.setFont(bigFont);
		ratioResults.setRowHeight(35);
		
		// Panels
		tabPane = new JTabbedPane();
		inputPane = new JPanel();
		inputPane.setLayout(new BoxLayout(inputPane, BoxLayout.PAGE_AXIS));
		inputPane.add(inputTitle);
		inputPane.add(input1);
		inputPane.add(input2);
		inputPane.add(calculate);
		
		
		historyPane = new JPanel();
		historyPane.setLayout(new BoxLayout(historyPane, BoxLayout.PAGE_AXIS));
		historyPane.add(historyTitle);
		historyPane.add(historyTable);
		
		
		ratioPane = new JPanel();
		ratioPane.setLayout(new BoxLayout(ratioPane, BoxLayout.PAGE_AXIS));
		ratioPane.add(ratioTitle);
		ratioPane.add(ratioDescription);
		ratioPane.add(ratioResults);
		
		
		
		// Calculate and set size to 40% of screen
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (size.width * .5);
		int height = (int) (size.height * .5);
		setSize(width,height);
		setLocationRelativeTo(null);
		
		// Add components and set visible
		add(tabPane);
		tabPane.addTab("Inputs", inputPane);
		tabPane.addTab("Ratio", ratioPane);
		tabPane.addTab("History", historyPane);
		
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
				double firNum = Double.parseDouble(input1.getText());
				double secNum = Double.parseDouble(input2.getText());
				String[] ratioOutput = Calculations.ratio(firNum, secNum);
				
				// TODO Update all tabs with calculated results
				for(int i = 0; i < ratioOutput.length; i++) {
					ratioResults.setValueAt(ratioOutput[i], i, 0);
				}
				
				// All complete
				historyTable.setValueAt((firNum + ":" + secNum), resultCounter, 0);
				resultCounter++;
				calculate.setText("Calculations complete!");
				System.out.println("Calculations complete");
				
			} catch (NumberFormatException ex) {
				// Format of numbers is invalid (contains a letter or character)
				System.out.println("Invalid number input.");
				calculate.setText("Please enter a valid number");
			} catch (NullPointerException ex) {
				// No text in input boxes
				System.out.println("No input in one or more fields.");
				calculate.setText("Please enter numbers");
				return;
			} catch (Exception ex) { 
				// Fall back if no expected exceptions are caught
				System.out.println("Error: No expected exceptions caught.\n" + ex);
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
