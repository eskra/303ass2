import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class appWindow extends JFrame{

	//create (private?) ints to toggle text boxes as you click

	public appWindow(Airplane airplane){

		JFrame frame = new JFrame();
		frame.setTitle("Airplane Reservation System");
		frame.setPreferredSize(new Dimension(500,500));

		//for organization
		JPanel automaticpanel = new JPanel();
		JPanel manualpanel = new JPanel();
		JPanel viewplane = new JPanel();

		//create buttons and window layout
		JButton autobrbutton = new JButton("Reserve using automatic broker");
		JButton manualbrbutton = new JButton("Reserve");
		JButton viewairplane = new JButton("View Airplane Seating");

		automaticpanel.add(autobrbutton);
		manualpanel.add(new JLabel("Reserve Using Manual Broker"));
		manualpanel.add(manualbrbutton);
		viewplane.add(new JLabel("If you would like to View the Airplane..."));
		viewplane.add(viewairplane);

		frame.setLayout(new FlowLayout());
		frame.add(automaticpanel);
		frame.add(manualpanel);
		frame.add(viewplane);

		//finalize frame and display
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		//IMPLEMENT BUTTONS ACTIONS

		//FOR NOW COMMENT OUT AUTOMATIC BROKER BUTTONS
		//THE POINT OF THIS WHOLE THING IS THAT THE AUTOMATIC 
		//BROKERS ARE LOOKING ALWAYS FOR SEATS

		Runnable br1 = new automaticbroker().createBroker(1, airplane);
		Runnable br2 = new automaticbroker().createBroker(2, airplane);
		Runnable br3 = new manualbroker().createBroker(3, airplane);
		Thread tbr1 = new Thread(br1);
		Thread tbr2 = new Thread(br2);
		Thread tbr3 = new Thread(br3);

		autobrbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){

				//we need to check which broker gets the seat first
				tbr1.start();
				tbr2.start();

				//NEED TO MAKE IT SO THAT ONLY ONE SEAT IS RESERVED AT A TIME
				//AKA WHICHEVER METHOD IS FASTEST RESERVES THE SEAT
				//tbr1.terminate();
				//tbr1.terminate();


				//TODO: IMPLEMENT LOCKING ??
			}
		});

		//IMPLEMENT CLICKING OF MANUAL RESERVATION
		//TODO: MAKE THE MENU REAPPEAR? 
		//MAKE SURE WE DONT LOSE DATA
		manualbrbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){

				JFrame manualreservation = new JFrame();
				manualreservation.setTitle("Manual Reservation");
				manualreservation.setPreferredSize(new Dimension(500,500));
				JPanel panel = new JPanel(new GridLayout(50,4));
				JPanel container = new JPanel();

				for(int rows = 0; rows < 50; rows++){
					for(int columns = 0; columns < 4; columns++){
							JButton button = new JButton();
						if(airplane.getSeating()[rows][columns] == 0){
							button.setText(rows + 1 + "," + (columns + 1));
						}
						else{
							button.setText(Integer.toString(airplane.getSeating()[rows][columns]));
						}
						button.addActionListener(new ActionListener(){

							public void actionPerformed(ActionEvent event){
								//System.out.println(button.getText());
							}
						});
						panel.add(button);
					}
				}
				container.add(panel);
				JScrollPane jsp = new JScrollPane(container);

				manualreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				manualreservation.add(jsp);
				manualreservation.pack();
				manualreservation.setVisible(true);
			}
		});
	}

	public static void main(String[] args){
		//appWindow w = create(airplane);
	}
}