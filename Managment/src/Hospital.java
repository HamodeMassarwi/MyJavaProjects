import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hospital extends JFrame implements ActionListener {

	JButton b, b2;
	JLabel l1, l2, l3;
	JTextField txt;
	JPasswordField txt2;
	JCheckBox show = new JCheckBox("Show Password");

	Font myf = new Font("Comic Sans", Font.BOLD, 15);

	public Hospital() {
		// CheckBox-----------------------------------------------
		show.setBackground(Color.white);
		show.setForeground(Color.LIGHT_GRAY);
		// Frame-------------------------------------------------
		setTitle("Login Form");// title
		setVisible(true);
		setFont(new Font("Calibri", Font.PLAIN, 14));
		setSize(420, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close When X is Clicked
		// icon
		ImageIcon img = new ImageIcon("human-skull.png");
		setIconImage(img.getImage());
		getContentPane().setBackground(Color.white);
		// button-----------------------------------------------
		b = new JButton("Log in");
		// b.setHorizontalAlignment(JButton.CENTER);
		// b.setVerticalAlignment(JButton.TOP);
		b.setFocusable(false);
		b.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b.setForeground(Color.DARK_GRAY);
		b.setBorder(BorderFactory.createRaisedBevelBorder());
		// button
		b2 = new JButton("Clear");
		// b2.setHorizontalAlignment(JButton.CENTER);
		// b2.setVerticalAlignment(JButton.TOP);
		b2.setFocusable(false);
		b2.setForeground(Color.black);
		b2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b2.setForeground(Color.DARK_GRAY);
		b2.setBorder(BorderFactory.createRaisedBevelBorder());

		// text -------------------------------------------------
		txt = new JTextField();
		txt.setEditable(true);
		txt.setFont(myf);
		// Password ---------------------------------------------
		txt2 = new JPasswordField();
		txt2.setEditable(true);
		txt2.setFont(myf);
		// labels------------------------------------------------
		l2 = new JLabel("Username:");
		l2.setVisible(true);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//----------------------------------------------------
		l3 = new JLabel("Password :");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l3.setVisible(true);
	
		

		add();
		placeBounds();
		addActionToListener();
		// pack(); this resize the window for the right size
	}

	public void addActionToListener() {
		b.addActionListener(this);
		b2.addActionListener(this);
		show.addActionListener(this);

	}

	public void placeBounds() {
		show.setBounds(102, 98, 123, 21);
		l3.setBounds(10, 64, 69, 24);
		l2.setBounds(10, 29, 69, 25);
		txt2.setBounds(102, 63, 260, 24);
		txt.setBounds(102, 29, 260, 24);
		b2.setBounds(270, 125, 92, 25);
		b.setBounds(102, 125, 92, 25);

	}

	public void add() {
		add(b);
		add(show);
		add(b2);
		add(l2);
		add(l3);
		add(txt);
		add(txt2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Login Button
		if (e.getSource() == b) {
			String y = txt.getText();
			String x = txt2.getText();
			if (y.equalsIgnoreCase("") && x.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(this, "Login Successful");
				dispose();
				NewFrame l = new NewFrame();
			} else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}
		}
		// Clear Button
		if (e.getSource() == b2) {
			txt.setText("");
			txt2.setText("");
		}
		if (e.getSource() == show) {
			if (show.isSelected()) {
				txt2.setEchoChar((char) 0);
			} else {
				txt2.setEchoChar('*');
			}

		}

	}

}
