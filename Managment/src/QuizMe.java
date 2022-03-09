import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class QuizMe extends JFrame implements ActionListener{

	private JPanel p1,p2;
	private JButton b1 , b2 ;
	private JRadioButton r1,r2,r3,r4;
	private JLabel l1 ,l2;
	private String[][] options = {{"10","10","70","499","92"},{"5","51","40","511","93"},{"9","50","39","501","91"},{"11","29","3","502","94"}};
	private String[] questions = {"5+5=","100-50=","30+20-10=","500-9+10=","200-100-2-5="};
	private int count = 0 , raw = 0 ,checking =1 , correct = 0 , wrong = 0 ;
	
	public QuizMe() {
		setVisible(true);
		setForeground(Color.DARK_GRAY);
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("QuizMe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 498, 383);
		p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p1);
		p1.setLayout(null);
		
		p2 = new JPanel();
		p2.setBackground(new Color(204, 204, 204));
		p2.setBounds(10, 10, 462, 168);
		p1.add(p2);
		p2.setLayout(null);
		
		l1 = new JLabel(questions[0]);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(l1);
		
		l2 = new JLabel("Choose Answer !");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setVisible(false);
		p1.add(l2);
		
		r1 = new JRadioButton(options[0][count]);
		p1.add(r1);
		
		r2 = new JRadioButton(options[1][count]);
		p1.add(r2);
		
		r3 = new JRadioButton(options[2][count]);
		p1.add(r3);
		
		r4 = new JRadioButton(options[3][count]);
		p1.add(r4);
		
		b1 = new JButton("Next");
		b1.setBackground(Color.darkGray);
		p1.add(b1);
		
		b2 = new JButton("Try Again");
		b2.setBackground(Color.darkGray);
		p1.add(b2);
		boundsAdd();
		addToLis();
	}
	public void boundsAdd() {
		r4.setBounds(10, 310, 231, 21);
		r3.setBounds(10, 280, 231, 21);
		r2.setBounds(10, 250, 231, 21);
		r1.setBounds(10, 220, 231, 21);
		b1.setBounds(313, 310, 100, 21);
		b2.setBounds(313, 280, 100, 21);
		l2.setBounds(313, 240, 100, 21);
		l1.setBounds(10, 10, 442, 148);
	}
	public void addToLis() {
		b2.addActionListener(this);
		b1.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);

	}
	public void unselect() {
		//-------------------------------
		r1.setSelected(false);
		r2.setSelected(false);
		r3.setSelected(false);
		r4.setSelected(false);
		//-------------------------------
		r1.setEnabled(true);
		r2.setEnabled(true);
		r3.setEnabled(true);
		r4.setEnabled(true);
		//-------------------------------
		
	}
	public boolean notselected()
	{
		if(r4.isSelected()||r3.isSelected()||r2.isSelected()||r1.isSelected())
		{
			return true;
		}
		return false;
	}
	public void visible() {
		l2.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == b1)
		{
			if(notselected()) {
				if(checking<=questions.length) {
					if(checking == 1)
					{
						if(r1.isSelected())
							correct++;
						else
							wrong++;
					}
					if(checking == 2)
					{
						if(r3.isSelected())
							correct++;
						else
							wrong++;
					}
					if(checking == 3)
					{
						if(r2.isSelected())
							correct++;
						else
							wrong++;
					}
					if(checking == 4)
					{
						if(r3.isSelected())
							correct++;
						else
							wrong++;
					}
					if(checking == 5)
					{
						if(r2.isSelected())
							correct++;
						else
							wrong++;
					}
					checking++;
				}
				if(count<questions.length-1) {
				l1.setText(questions[++count]);
				r1.setText(options[raw][count]);
				r2.setText(options[++raw][count]);
				r3.setText(options[++raw][count]);
				r4.setText(options[++raw][count]);
				raw=0;
				
				unselect();
				
				
				}else {
				System.out.println(correct);
				r1.setEnabled(false);
				r2.setEnabled(false);
				r3.setEnabled(false);
				r4.setEnabled(false);
				if(correct == questions.length)
				{
					p2.setBackground(Color.green);
					l1.setText("Good Job ! \nYour Score is " + correct + "/" + questions.length + ", Wrong Answers is : "+wrong);
				}else {
					p2.setBackground(Color.red);
					l1.setText("Try Again ! Your Score is " + correct + "/" + questions.length + "\n Wrong Answers is : "+wrong);
				}
				
				}
			}else {visible();}
		}
		//Radio 1
		if(e.getSource() == r1 )
		{
			if (r1.isSelected()) {
				r2.setEnabled(false);
				r3.setEnabled(false);
				r4.setEnabled(false);
				if(l2.isVisible())
					l2.setVisible(false);
			} else {
				r2.setEnabled(true);
				r3.setEnabled(true);
				r4.setEnabled(true);
			}
		}
		//radio 2 
		if(e.getSource() == r2 )
		{
			if (r2.isSelected()) {
				r1.setEnabled(false);
				r3.setEnabled(false);
				r4.setEnabled(false);
				if(l2.isVisible())
					l2.setVisible(false);
			} else {
				r1.setEnabled(true);
				r3.setEnabled(true);
				r4.setEnabled(true);
			}
		}
		//radio 3
		if(e.getSource() == r3 )
		{
			if (r3.isSelected()) {
				r2.setEnabled(false);
				r1.setEnabled(false);
				r4.setEnabled(false);
				if(l2.isVisible())
					l2.setVisible(false);
			} else {
				r2.setEnabled(true);
				r1.setEnabled(true);
				r4.setEnabled(true);
			}
		}
		//radio 4
		if(e.getSource() == r4 )
		{
			if (r4.isSelected()) {
				r2.setEnabled(false);
				r3.setEnabled(false);
				r1.setEnabled(false);
				if(l2.isVisible())
					l2.setVisible(false);
			} else {
				r2.setEnabled(true);
				r3.setEnabled(true);
				r1.setEnabled(true);
			}
		}
		if(e.getSource() == b2)
		{
			dispose();
			new QuizMe();
		}
		
	}
}
