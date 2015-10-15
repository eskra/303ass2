import java.awt.*;
import javax.swing.*;

public class FrameTester{
	
	public static void main(String[] args){

		JFrame frame = new JFrame();

		JButton broker1 = new JButton("Reserve Using Automatic Broker 1");
		JButton broker2 = new JButton("Reserve Using Automatic Broker 2");
		JButton broker3 = new JButton("Reserve Using Manual Broker 3");

		final JLabel greeting = new JLabel("Select which broker you would like to reserve with.");

		frame.setLayout(new FlowLayout());
		frame.add(greeting);
		frame.add(broker1);
		frame.add(broker2);
		frame.add(broker3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}