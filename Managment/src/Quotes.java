
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.SwingConstants;
	import java.awt.Color;
public class Quotes extends JFrame implements ActionListener{

		private JPanel p;
		private JLabel l1 ;
		private Random r = new Random();
		private	int low = 0;
		private	int high = 16;
		private String [] quotes = {"When you have a dream, you’ve got to grab it and never let go.",
				"Nothing is impossible. The word itself says ‘I’m possible!",
				"There is nothing impossible to they who will try.",
				"The bad news is time flies. The good news is you’re the pilot.",
				"Life has got all those twists and turns. You’ve got to hold on tight and off you go.",
				"Keep your face always toward the sunshine, and shadows will fall behind you.",
				"Success is not final, failure is not fatal: it is the courage to continue that counts.",
				"You define your own life. Don’t let other people write your script.",
				"You are never too old to set another goal or to dream a new dream.",
				"Spread love everywhere you go.",
				"You can be everything. You can be the infinite amount of things that people are.",
				"You don’t always need a plan. Sometimes you just need to breathe, trust, let go and see what happens.",
				"Belief creates the actual fact.",
				"It is during our darkest moments that we must focus to see the light.",
				"Not having the best situation, but seeing the best in your situation is the key to happiness.",
				"Believe you can and you’re halfway there."};
		private final JButton b1 = new JButton("Random");
		
		public Quotes() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 800, 155);
			setVisible(true);
			setTitle("Quotes");
			p = new JPanel();
			p.setBackground(new Color(255, 255, 204));
			p.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(p);
			p.setLayout(null);
			b1.setBackground(new Color(51, 102, 255));
			b1.setBounds(325, 72, 150, 36);
			b1.addActionListener(this);
			p.add(b1);
			
			l1 = new JLabel("");
			l1.setHorizontalAlignment(SwingConstants.CENTER);
			l1.setBounds(10, 10, 780, 33);
			p.add(l1);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1)
		{
			int result = r.nextInt(high-low) + low;
			l1.setText(quotes[result]);
			
		}
			
		}

	}


