import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class NewFrame extends JFrame implements ActionListener {

	JButton b, b2, b3, b4, b5, b6;
	JLabel l1, l2, l3;
	JTextField txt;
	JPasswordField txt2;
	JCheckBox show = new JCheckBox("Show");
	JPanel p;
	Font myf = new Font("Comic Sans", Font.BOLD, 15);
	ImageIcon img;
	Random rand;

	public NewFrame() {
		p = new JPanel();
		// image icon
		img = new ImageIcon("gaming.png");
		// Frame
		setIconImage(img.getImage());
		setTitle("My Programs");
		setFont(new Font("Calibri", Font.ITALIC, 14));
		setForeground(Color.BLACK);
		add(p);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 510, 409);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		// Button
		b = new JButton("Calculator");
		b.setBackground(Color.ORANGE);
		b.setFont(new Font("Arial", Font.ITALIC, 14));
		b.setVisible(true);
		b.setForeground(Color.black);		
		
		// Button 2
		b2 = new JButton("Snake Game");
		b2.setVisible(true);
		b2.setBackground(new Color(204, 153, 51));
		b2.setFont(new Font("Arial", Font.ITALIC, 14));
		b2.setForeground(Color.black);
		// Button 3
		b3 = new JButton("Capture");
		b3.setVisible(true);
		b3.setForeground(Color.black);
		b3.setBackground(new Color(153, 153, 255));
		b3.setFont(new Font("Arial", Font.ITALIC, 14));
		//button 4
		b4 = new JButton("Fund Calculator");
		//button 5
		b5 = new JButton("Math Quiz");
		b5.setBackground(Color.pink);
		//button 6
		b6 = new JButton("New button");
		b6.setBackground(Color.yellow);
		//Labels
		l1 = new JLabel("Takes A Full ScreenShot");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setBounds(176, 104, 156, 36);
		//Label 2 
		l2 = new JLabel("");
		l2.setIcon(new ImageIcon("C:\\Users\\hamod\\Downloads\\snake.png"));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setBounds(10, 104, 156, 36);
		//label 3 
		l3 = new JLabel("Simple Calculator");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
	
		// Panel
		p.setBackground(Color.CYAN);
		p.setLayout(null);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		add();
		placeBounds();
		addActionToListener();

	}

	public void addActionToListener() {
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
	}

	public void placeBounds() {
		l1.setBounds(176, 104, 156, 36);
		l2.setBounds(10, 104, 156, 36);
		l3.setBounds(342, 104, 144, 36);
		b.setBounds(342, 28, 144, 66);
		b2.setBounds(10, 28, 156, 66);
		b3.setBounds(176, 28, 156, 66);
		b4.setBounds(176, 150, 156, 66);
		b5.setBounds(10, 150, 156, 66);
		b6.setBounds(342, 150, 144, 66);

	}

	public void add() {
		p.add(b);
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
	}

	public void capture() {
		rand = new Random();
		try {
			Robot r = new Robot();
			Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage screenShot = r.createScreenCapture(rec);
			ImageIO.write(screenShot, "jpg",
					new File("C:\\Users\\hamod\\Desktop\\java images\\screen" + rand.nextInt() + ".jpg"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b) {
			 new Calc();
		}
		if (e.getSource() == b2) {
			 new GameFrame();
		}
		if (e.getSource() == b3) {
			capture();
		}
		if(e.getSource() == b4 ) {
			new FundCalc();
		}
		if(e.getSource() == b5)
		{
			new QuizMe();
		}

	}

}
