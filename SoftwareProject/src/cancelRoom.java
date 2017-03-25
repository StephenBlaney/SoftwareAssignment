

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @authors Stephen Blaney, Student numbers B00076157 Language Java , Itb room
 *          booking system project
 * 
 */
public class cancelRoom extends JFrame {

	JButton loginButton = new JButton("Cancel Room");
	JButton registerButton = new JButton("Back to main page");
	Container contentPane = getContentPane();
	String rooms[] = { "A04", "A11", "E116", "F12", "E115" };
	String times[] = { "9:00 AM", "10:00 AM", "11:00 AM", "12:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM" };
	JComboBox<String> combo1 = new JComboBox<String>(rooms);
	JComboBox<String> combo2 = new JComboBox<String>(times);
	JLabel roomselect = new JLabel("");
	JLabel timeselect = new JLabel("");


	public cancelRoom() {

		super("ITB Room Booking System");

		Container contentPane = getContentPane();

		JPanel guiPanel = new JPanel();
		JPanel paintPanel = new JPanel();
		JPanel labels = new JPanel();
		JPanel labels1 = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel buttons = new JPanel();

		JLabel introLabel = new JLabel("Welcome To The Cancel Room Page");

		JLabel loginLabel = new JLabel("Please Enter the room you want to cancel");

		JLabel loginLabel1 = new JLabel("Please Enter the time you want to cancel");

		Font fancyFont = new Font("Serif", Font.ITALIC, 52);

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 28);

		introLabel.setIcon(new ImageIcon("ITB logo.png"));

		// add a font to the Jlabel
		introLabel.setFont(fancyFont);
		loginLabel.setFont(fancyFont2);
		loginLabel1.setFont(fancyFont2);
		roomselect.setFont(fancyFont2);
		timeselect.setFont(fancyFont2);

		introLabel.setForeground(new Color(0, 128, 0));
		loginLabel.setForeground(new Color(0, 128, 0));
		loginLabel1.setForeground(new Color(0, 128, 0));
		roomselect.setForeground(new Color(0, 128, 0));
		timeselect.setForeground(new Color(0, 128, 0));

		guiPanel.setLayout(new BoxLayout(guiPanel, BoxLayout.Y_AXIS));

		guiPanel.add(paintPanel);

		guiPanel.add(textPanel);

		guiPanel.add(combo1);
		combo1.setPreferredSize(new Dimension(150, 25));

		guiPanel.add(combo2);
		combo2.setPreferredSize(new Dimension(150, 25));

		guiPanel.add(labels1);

		guiPanel.add(labels);

		guiPanel.add(buttons);

		guiPanel.setBackground(Color.white);

		paintPanel.add(introLabel, BorderLayout.NORTH);

		paintPanel.setBackground(Color.white);

		textPanel.add(loginLabel, BorderLayout.CENTER);

		textPanel.add(combo1);

		labels1.add(loginLabel1);

		labels1.add(combo2);

		labels1.setBackground(Color.white);

		labels.add(roomselect, BorderLayout.SOUTH);

		labels.add(timeselect, BorderLayout.SOUTH);

		textPanel.setBackground(Color.white);

		buttons.setBackground(Color.white);

		labels.setBackground(Color.white);

		buttons.add(loginButton, BorderLayout.NORTH);
		loginButton.setPreferredSize(new Dimension(100, 50));

		buttons.add(registerButton, BorderLayout.NORTH);
		registerButton.setPreferredSize(new Dimension(200, 50));

		contentPane.add(guiPanel);

		setSize(400, 300);
		setVisible(true);

		combo1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				roomselect.setText("Room Selected  " + combo1.getSelectedItem().toString());

			}
		});

		combo2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				timeselect.setText("And Time Selected  " + combo2.getSelectedItem().toString());
			}
		});

		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainPage nextframe = new MainPage();
				MainPage.getWindows(); // load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			}
		});

		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog(null, "Are you sure you want to cancel ",
						(combo1.getSelectedItem().toString() + " At " + combo2.getSelectedItem().toString()));
				
				
				JOptionPane.showMessageDialog(null, "Room booked succesfully Canceled", "Room canceled",
						JOptionPane.INFORMATION_MESSAGE);
				MainPage nextframe = new MainPage();
				MainPage.getWindows(); // load next page
				nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				
			}
		});

	}

	public static void main(String args[])

	{

		cancelRoom myFrame = new cancelRoom();
		myFrame.setExtendedState(myFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

