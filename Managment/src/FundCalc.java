import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class FundCalc extends JFrame implements ActionListener{

	 JPanel p,p2;
	 JTextField txt1,txt2,txt3;
	 JLabel l,l1,l2,l3,l4;
	 JButton b1,b2;
	 JTextArea tArea;
	

		public FundCalc() {
			// TODO Auto-generated constructor stub
		setTitle("Fund Calculator");
		setSize(501,516);
		setVisible(true);
		setForeground(new Color(102, 153, 255));
		setFont(new Font("Agency FB", Font.BOLD, 16));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		p2 = new JPanel();
		p2.setLayout(null);
		
		l = new JLabel("Disability Fund System");
		l.setFont(new Font("Arial", Font.BOLD, 20));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(l);
		
		p = new JPanel();
		p.setBounds(10, 44, 467, 425);
		p2.add(p);
		p.setLayout(null);
		
		l1 = new JLabel("Enter Your Salary:");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(l1);
		
		l2 = new JLabel("Percentage of Physical Disability:");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(l2);
		
		l3 = new JLabel("Percentage of Mental Disability:");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(l3);
		
		l4 = new JLabel("Enter Just numbers !");
		p.add(l4);
		
		txt1 = new JTextField();
		p.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		p.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		p.add(txt3);
		txt3.setColumns(10);
		
		b1 = new JButton("My Fund");
		p.add(b1);
		
		b2 = new JButton("Print");
		p.add(b2);
		
		tArea = new JTextArea();
		p.add(tArea);
		
		boundsSetting();
		add(p2);
		addToTheListener();
		
	}
		public void boundsSetting() {
			l.setBounds(129, 10, 233, 24);
			l1.setBounds(10, 10, 200, 35);
			l2.setBounds(10, 55, 200, 35);
			l3.setBounds(10, 100, 200, 35);
			txt1.setBounds(220, 18, 104, 19);
			txt2.setBounds(220, 63, 105, 19);
			txt3.setBounds(220, 108, 105, 19);
			tArea.setBounds(10, 193, 287, 325);
			b2.setBounds(240, 145, 85, 21);
			b1.setBounds(10, 145, 85, 21);
		}
		public void addToTheListener() {
			b1.addActionListener(this);
			b2.addActionListener(this);
		}
		public static boolean isNumeric(String strNum) {
		    if (strNum == null) {
		        return false;
		    }
		    try {
		        double d = Double.parseDouble(strNum);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    return true;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b2)
			{
			}
			if(e.getSource() == b1)
			{	
				if(txt1.getText().equalsIgnoreCase("")|| txt2.getText().equalsIgnoreCase("") 
						|| txt3.getText().equalsIgnoreCase("") || !isNumeric(txt1.getText()) 
						|| !isNumeric(txt2.getText()) || !isNumeric(txt3.getText())  )
				{
					System.out.println("please check the textfields");
				}else {
				int salary = Integer.parseInt(txt1.getText()) , 
						psycho = Integer.parseInt(txt2.getText()),
							physical = Integer.parseInt(txt3.getText()) ,
								count = 0,
									sum=0 ,
									y=0;// Disability Percent needed to the next Bigger fund	
				if(salary>=5300 && salary<=8000)
				{
					count-=100;
				}else if(salary>8000){
					count-=720;
				}
				psycho=(int)(psycho*0.6);
				physical=(int)(physical*0.4);
				sum=physical+psycho;
				if(sum>59 && sum<80)
				{
					count+=1500;
					y=80-sum;
				}else if(sum>79 && sum<100){
					count+=2800;
					y=100-sum;
				}else if(sum>99){
					count+=3700;
					y=1;
				}else {
					y=59-sum;
				}
				if(y!=1)
					tArea.setText("Your Fund is :"+ count + "\nThe Fund with The Salary => " + (count+salary) + "\nYou Need More ==> " + y + " Disability Percent.\nTo Get A bigger fund $$");
				else
					tArea.setText("Your Fund is :"+ count + "\nThe Fund with The Salary => " + (count+salary));

				}
			}
			
		}
}

