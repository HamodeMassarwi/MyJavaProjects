import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.*;

public class Calc extends JFrame implements ActionListener {

	JTextField txt;
	JPanel panel;
	ImageIcon icon = new ImageIcon("calculator.png");
	double num1, num2, res;
	Font myf = new Font("Comic Sans", Font.BOLD, 15);
	JButton[] fun = new JButton[9];
	JButton equal, sub, dec, div, multi, add, del, clr, neg;
	char op;
	JButton[] num = new JButton[10];

	public Calc() {
		setTitle("Calculator");
		setSize(420, 490);
		setLayout(null);
		setResizable(false);
		setIconImage(icon.getImage());
		txt = new JTextField();
		txt.setBounds(50, 25, 300, 30);
		txt.setEditable(false);
		txt.setFont(myf);
		neg = new JButton("(-)");
		add = new JButton("+");
		sub = new JButton("-");
		dec = new JButton(".");
		div = new JButton("/");
		multi = new JButton("*");
		del = new JButton("Delete");
		clr = new JButton("Clear");
		equal = new JButton("=");
		fun[0] = add;
		fun[1] = sub;
		fun[2] = multi;
		fun[3] = div;
		fun[4] = dec;
		fun[5] = equal;
		fun[6] = del;
		fun[7] = clr;
		fun[8] = neg;
		for (int i = 0; i < 9; i++) {
			fun[i].addActionListener(this);
			fun[i].setFont(myf);
			fun[i].setFocusable(false);
		}

		for (int i = 0; i < 10; i++) {
			num[i] = new JButton(String.valueOf(i));
			num[i].addActionListener(this);
			num[i].setFont(myf);
			num[i].setFocusable(false);
		}

		del.setBounds(50, 380, 100, 50);
		clr.setBounds(150, 380, 100, 50);
		neg.setBounds(250, 380, 100, 50);

		panel = new JPanel();
		panel.setBounds(50, 70, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.cyan);

		panel.add(num[1]);
		panel.add(num[2]);
		panel.add(num[3]);
		panel.add(add);
		panel.add(num[4]);
		panel.add(num[5]);
		panel.add(num[6]);
		panel.add(sub);
		panel.add(num[7]);
		panel.add(num[8]);
		panel.add(num[9]);
		panel.add(multi);
		panel.add(dec);
		panel.add(num[0]);
		panel.add(equal);
		panel.add(div);
		add(panel);
		add(neg);
		add(clr);
		add(del);
		add(txt);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == num[i]) {
				txt.setText(txt.getText().concat(String.valueOf(i)));
			}

		}

		if (e.getSource() == dec)
			txt.setText(txt.getText().concat("."));

		if (e.getSource() == add) {
			num1 = Double.parseDouble(txt.getText());
			op = '+';
			txt.setText("");
		}
		if (e.getSource() == multi) {
			num1 = Double.parseDouble(txt.getText());
			op = '*';
			txt.setText("");
		}
		if (e.getSource() == div) {
			num1 = Double.parseDouble(txt.getText());
			op = '/';
			txt.setText("");
		}
		if (e.getSource() == sub) {
			num1 = Double.parseDouble(txt.getText());
			op = '-';
			txt.setText("");
		}
		if (e.getSource() == equal) {
			num2 = Double.parseDouble(txt.getText());

			switch (op) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num1 - num2;
				break;
			case '/':
				res = num1 / num2;
				break;
			case '*':
				res = num1 * num2;
				break;
			}
			txt.setText(String.valueOf(res));
			num1 = res;
		}
		if (e.getSource() == clr) {
			txt.setText("");
			num1 = 0;
			num2 = 0;
		}
		if (e.getSource() == del) {
			String st = txt.getText();
			txt.setText("");
			for (int i = 0; i < st.length() - 1; i++) {
				txt.setText(txt.getText() + st.charAt(i));
			}
		}

		if (e.getSource() == neg) {
			double t = Double.parseDouble(txt.getText());
			t *= -1;
			txt.setText(String.valueOf(t));
		}

	}

}