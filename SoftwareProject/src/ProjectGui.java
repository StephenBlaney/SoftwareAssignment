
/**
 * @author  Stephen Blaney, Student numbers B00076157 Language Java , Itb room
 *          booking system project project all codeing has been writed by Stephen Blaney 
 */

/**
 * Imported all Nessary packages 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectGui extends JFrame { // extends the JFrame class

	/**
	 * List of all varibles
	 */

	Connection con; // Variable to connect to the mySql Database
	Statement st; // Variable used to excute an SQL quary
	ResultSet rs; // Varible used to to be able to print quary

	/**
	 * list of all global JComponent varibles
	 */

	JButton loginButton = new JButton("Login"); // Creates Login Button
	Container contentPane = getContentPane(); // Creates the content pane for //										// the JFrame
	JTextField loginfield = new JTextField(30); // Creates login textfield
	JTextField loginfield1 = new JTextField(30);// Creates 2nd login textfield

	public ProjectGui() {
		super("ITB Room Booking System"); // Name of the software

		/**
		 * All nessesary panels are created
		 */

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		

		JLabel introLabel = new JLabel("Welcome To The ITB Room Booking System"); // creates
																					// intro
																					// jlabel
																					// and
																					// set
																					// the
																					// text
																					// for
																					// the
																					// label

		JLabel loginLabel = new JLabel("Please Enter ID"); // creates loginlabel
															// Jlabel and sets
															// the text for the
															// label

		JLabel loginLabel1 = new JLabel("Please Enter Password"); // creates
																	// loginlabel1
																	// Jlabel
																	// and sets
																	// the text
																	// for the
																	// label

		Font fancyFont = new Font("Serif", Font.ITALIC, 52); // creates
																// fancyfont for
																// components

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 28); // creates
																// fancyfont2
																// for
																// components

		introLabel.setIcon(new ImageIcon("ITB logo.png")); // Set an icon for
															// the introLabel
															// and the directory
															// path or the image

		/**
		 * adds all the following fonts to the respective components
		 */
		introLabel.setFont(fancyFont);
		loginLabel.setFont(fancyFont2);
		loginLabel1.setFont(fancyFont2);

		/**
		 * adds color to the labels with the rgb codes founded online
		 */

		introLabel.setForeground(new Color(0, 128, 0));
		loginLabel.setForeground(new Color(0, 128, 0));
		loginLabel1.setForeground(new Color(0, 128, 0));

		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // Set a box
																	// layout of
																	// the main
																	// panel
																	// panel1

		/**
		 * Add the following panels to the main panel panel1
		 */
		panel1.add(panel2);
		panel1.add(panel3);
		panel1.add(panel4);
		panel1.add(panel5);

		panel1.setBackground(Color.white); // set the background of the panel1
											// to white

		panel2.add(introLabel, BorderLayout.NORTH); // add introLabel to panel2
													// and add a border layout

		panel2.setBackground(Color.white); // set the background of the panel2
											// to white

		panel3.add(loginLabel, BorderLayout.CENTER); // add loginlabel to panel3
														// and add a border
														// layout

		panel3.add(loginfield, BorderLayout.CENTER); // add loginfield to panel3
														// and add a border
														// layout

		panel3.add(loginLabel1); // add logonlabel1 to panel2


		panel3.setBackground(Color.white); // set background of panel3 to white

		panel4.setBackground(Color.white);
		
		panel4.add(loginLabel1); 
		
		panel4.add(loginfield1);
		
		panel5.setBackground(Color.white);// set background of panel4 to white

		panel5.add(loginButton, BorderLayout.NORTH); // add loginButton to
														// panel4 and add a
														// border layout
		loginButton.setPreferredSize(new Dimension(100, 50)); // change thesize
																// of the login
																// button to the
																// set
																// dimensions

		contentPane.add(panel1);

		setVisible(true); // Set the frame to visible so that we can see it

		connect(); // call the connect method that will esbalishe a connection
					// to the database

		loginButton.addActionListener(new ActionListener() {
			/**
			 * Start of inner class
			 */

			public void actionPerformed(ActionEvent e) {
				/**
				 * Action event method for login button
				 */
				try {

					String user = loginfield.getText().trim(); // get users
																// input from
																// login
																// TextField
																// removing
																// whitespace

					String pass = loginfield1.getText().trim(); // get users
																// input from
																// login
																// TextField
																// removing
																// whitespace

					String sql = "select * from credientials  where  STUDENTNO	='" + user + "' and  PASS='" + pass
							+ "'";

					rs = st.executeQuery(sql);

					int count = 0;

					while (rs.next()) { // while the sql quary is correct

						count = count + 1; // add one to counter

					}

					if (count == 1) { // if count = 1

						JOptionPane.showMessageDialog(null, "Correct User Name And Password Entered"); // Show
																										// message
																										// that
																										// login
																										// was
																										// correct
						MainPage nextframe = new MainPage();
						MainPage.getWindows(); // load next page
						nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH); // set
																											// the
																											// window
																											// to
																											// maximise
																											// on
																											// launch

					} else if (count > 1) { // if count > 1
						JOptionPane.showMessageDialog(null, "Dupilcate user,Acess denied"); // this
																							// will
																							// show
																							// if
																							// theirs
																							// a
																							// dupilcate
																							// user

					} else {

						JOptionPane.showMessageDialog(null, "Login details are incorrect", "Inane error",
								JOptionPane.ERROR_MESSAGE);
						// login in details are incorrect

					}

				} catch (Exception ex) {

				}

			}

		}); // end of inner class

	}

	public static void main(String args[]) // Start of main method

	{

		ProjectGui myFrame = new ProjectGui();
		myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		// INSERT INTO credientials values ('B00076157','hellostephen'); //
		// launch
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //

	} // end of main method

	public void connect() {
		/**
		 * Start of connect method
		 */

		try {

			String driver = "com.mysql.jdbc.Driver"; // driver for database
			Class.forName(driver);// class for database

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Java", "root", "root"); // database
																											// credentials
			st = con.createStatement();// create statement
		}

		catch (Exception e) {

		}

	}

}
