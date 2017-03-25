
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainPage extends JFrame implements ActionListener {
	
	JButton loginbutton1 = new JButton("Book Room");
	JButton loginbutton4 = new JButton("Cancel Room");
	JButton loginbutton6 = new JButton("Exit");


	MainPage() {

		super("Welcome to the main page"); // Name of frame

		Container contentPane = getContentPane(); // Create ContentPane

		JPanel panel = new JPanel(); // creates panel

		JLabel label1 = new JLabel("Welcome to the Main Page please select an option");

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 25);

		Font font1 = new Font("Serif", Font.ITALIC, 42);
		
		Border thickBorder = new LineBorder(Color.black, 2);

		label1.setIcon(new ImageIcon("ITB logo.png"));

		label1.setForeground(new Color(0, 128, 0));

		// Add to panel
		panel.add(label1);

		loginbutton1.setBorder(thickBorder);

		loginbutton4.setBorder(thickBorder);
		loginbutton6.setBorder(thickBorder);

		// add fonts to panels
		label1.setFont(font1);
		loginbutton1.setFont(fancyFont2);
		
		loginbutton4.setFont(fancyFont2);
		loginbutton6.setFont(fancyFont2);

		// add buttons to panel
		panel.add(loginbutton1);
		loginbutton1.addActionListener(this);
		
		panel.add(loginbutton4);
		loginbutton4.addActionListener(this);

		panel.add(loginbutton6);
		loginbutton6.addActionListener(this);

		// add gridlayout
		panel.setLayout(new GridLayout(2, 4, 100, 100));

		// change the color of the panel to white
		panel.setBackground(Color.white);

		// Set text to red on all buttons
		loginbutton1.setForeground(Color.RED);
		loginbutton4.setForeground(Color.RED);
		loginbutton6.setForeground(Color.RED);

		// Set background color of buttons to whi
		loginbutton1.setBackground(Color.WHITE);
		loginbutton4.setBackground(Color.WHITE);
		loginbutton6.setBackground(Color.WHITE);

		// Add to content pane
		contentPane.add(label1, BorderLayout.NORTH);
		contentPane.add(panel);
		contentPane.setBackground(Color.white);

		setSize(700, 500); // set size of frame
		setVisible(true); // set fram visbilty

	}

	public static void main(String[] args) {
		MainPage mainPage = new MainPage();
		mainPage.setExtendedState(mainPage.getExtendedState() | JFrame.MAXIMIZED_BOTH);

	}// end of main method

	public void actionPerformed(ActionEvent e) {
		/**
		 * Action event on all buttons that brings the user to their their respective pages 
		 */

		if (e.getSource() instanceof JButton) {
			if (e.getActionCommand().equals("Book Room")) {
				bookroom nextframe = new bookroom(); 
				bookroom.getWindows(); //load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			}
			
			if (e.getActionCommand().equals("Get Timetable")) {
				bookroom nextframe = new bookroom(); 
				bookroom.getWindows(); //load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);

			}
						
			if (e.getActionCommand().equals("Cancel Room")) {
				bookroom nextframe = new bookroom(); 
				bookroom.getWindows(); //load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			}
			
			if (e.getActionCommand().equals("Exit")) {
				System.exit(0);

			}

		}
	}
}// end of class
