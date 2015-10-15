import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appWindow extends JFrame{

	//create (private?) ints to toggle text boxes as you click

	public appWindow(){
	
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500,500));

		JLabel greeting = new JLabel("Select which broker you would like to reserve with.");

		JButton broker1 = new JButton("Reserve Using Automatic Broker 1");
		JButton broker2 = new JButton("Reserve Using Automatic Broker 2");
		JButton broker3 = new JButton("Reserve");

		frame.setLayout(new FlowLayout());
		frame.add(greeting);
		frame.add(broker1);
		frame.add(broker2);
		frame.add(new JLabel("Reserve Using Manual Broker"));
		frame.add(new JLabel("Please enter your preferred seat location as column, row."));
		frame.add(new JTextField(20));
		frame.add(broker3);
		//fix layout stuff so that it doesnt move when resizing

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		broker3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*frame.add(new JLabel("Please enter your preferred seat location as column, row."));
				frame.add(new JTextField(20));
				JButton reserve = new JButton("Reserve");
				frame.pack();
				frame.setVisible(true);*/
				
			}

		});
	}

	public static void main(String[] args){
		new appWindow();
	}
}