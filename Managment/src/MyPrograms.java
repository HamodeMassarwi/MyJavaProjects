import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;

public class MyPrograms extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MyPrograms() {
		setVisible(true);
		setForeground(Color.BLACK);
		setTitle("My Programs");
		setFont(new Font("Calibri", Font.ITALIC, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hamod\\Downloads\\gaming.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 409);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton b1 = new JButton("Snake Game");
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("Arial", Font.ITALIC, 14));
		b1.setIcon(null);
		b1.setBounds(10, 28, 156, 66);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Capture Pic");
		b2.setBackground(new Color(204, 153, 51));
		b2.setFont(new Font("Arial", Font.ITALIC, 14));
		b2.setBounds(176, 28, 156, 66);
		contentPane.add(b2);
		
		JButton btnNewButton = new JButton("Calculator");
		btnNewButton.setBackground(new Color(153, 153, 255));
		btnNewButton.setFont(new Font("Arial", Font.ITALIC, 14));
		btnNewButton.setBounds(342, 28, 144, 66);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Takes A Full ScreenShot");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 104, 156, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hamod\\Downloads\\snake.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 104, 156, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Simple Calculator");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(342, 104, 144, 36);
		contentPane.add(lblNewLabel_2);
	}
}
