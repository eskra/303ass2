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

		JPanel automaticpanel = new JPanel();
		JPanel manualpanel = new JPanel();
		JButton broker1 = new JButton("Reserve Using Automatic Broker 1");
		JButton broker2 = new JButton("Reserve Using Automatic Broker 2");
		JButton broker3 = new JButton("Reserve");
		automaticpanel.add(broker1);
		automaticpanel.add(broker2);
		manualpanel.add(new JLabel("Reserve Using Manual Broker"));
		//manualpanel.add(new JLabel("Please enter your preferred seat location as column, row."));

		manualpanel.add(broker3);

		frame.setLayout(new FlowLayout());
		frame.add(greeting);
		frame.add(automaticpanel);
		frame.add(manualpanel);
		frame.add(new JTextField(20));
		frame.add(broker3);
		//fix layout stuff so that it doesnt move when resizing

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		broker3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){

				JFrame manualreservation = new JFrame();
				manualreservation.setPreferredSize(new Dimension(800,800));
				JPanel panel = new JPanel(new GridLayout(4,50));

				for(int columns = 0; columns < 4; columns++){
					for(int rows = 0; rows < 50; rows++){
						final JButton button = new JButton(String.parseInt(airplane.seating[columns][rows]));
						button.addActionListener(new ActionListener(){

							public void actionPerformed(ActionEvent event){
								if(button.getText() == 0){
									button.setText("3");
								}
								else{
									//do nothing because seat is reserved
								}
							}
						});
						panel.add(button);
					}
				}

				manualreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				manualreservation.add(panel);
				manualreservation.pack();
				manualreservation.setVisible(true);
				/*frame.add(new JLabel("Please enter your preferred seat location as column, row."));
				frame.add(new JTextField(20));
				JButton reserve = new JButton("Reserve");
				frame.pack();
				frame.setVisible(true);*/
				//on click, we need to reserve a seat
				//aka we need to run the threads
			}

		});
	}

	public static void main(String[] args){
		new appWindow();
	}
}