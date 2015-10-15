import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.*;


public class Airplane extends JFrame{

	private int[][] seating = new int [50][4];
	private final int numberOfColumns = 4;
	private final int numberOfRows = 50;

	/*private void initializeAirplane(int colNum, int rowNum){
		Airplane airplane = new Airplane();
		this.numberOfColumns = colNum;
		this.numberOfRows = rowNum;
		this.seating = new int[colNum][rowNum];
	}*/

	private boolean findSeat(int colNum, int rowNum){
		if(this.seating[colNum][rowNum] == 0){
			//seat is empty
			return true;
		} else return false;
	}

	public static void main(String[] args){

		Airplane airplane = new Airplane();
		Runnable br1 = new automaticbroker(1);
		Runnable br2 = new automaticbroker(2);
		Runnable br3 = new manualbroker(3);
		Thread tbr1 = new Thread(br1);
		Thread tbr2 = new Thread(br2);
		Thread tbr3 = new Thread(br3);
		
		System.out.println(airplane.numberOfRows + airplane.numberOfColumns);

		/*automaticbroker broker1 = (new automaticbroker()).createBroker(1);
		automaticbroker broker2 = (new automaticbroker()).createBroker(2);
		manualbroker broker3 = (new manualbroker()).createBroker(3);
		*/
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500,500));

		JLabel greeting = new JLabel("Select which broker you would like to reserve with.");

		JPanel automaticpanel = new JPanel();
		JPanel manualpanel = new JPanel();
		JButton broker1button = new JButton("Reserve Using Automatic Broker 1");
		JButton broker2button = new JButton("Reserve Using Automatic Broker 2");
		JButton broker3button = new JButton("Reserve");
		automaticpanel.add(broker1button);
		automaticpanel.add(broker2button);
		manualpanel.add(new JLabel("Reserve Using Manual Broker"));
		//manualpanel.add(new JLabel("Please enter your preferred seat location as column, row."));

		manualpanel.add(broker3button);

		frame.setLayout(new FlowLayout());
		frame.add(greeting);
		frame.add(automaticpanel);
		frame.add(manualpanel);
		frame.add(new JTextField(20));
		frame.add(broker3button);
		//fix layout stuff so that it doesnt move when resizing

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		//IMPLEMENT CLICKING OF MANUAL RESERVATION
		//TODO: MAKE THE MENU REAPPEAR? 
		//MAKE SURE WE DONT LOSE DATA
		broker3button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){

				JFrame manualreservation = new JFrame();
				manualreservation.setPreferredSize(new Dimension(800,400));
				JPanel panel = new JPanel(new GridLayout(5,50));

				for(int columns = 0; columns < 4; columns++){
					for(int rows = 0; rows < 50; rows++){
						JButton button = new JButton(Integer.toString(airplane.seating[rows][columns]));
						button.addActionListener(new ActionListener(){

							public void actionPerformed(ActionEvent event){

								//ALL ACTIONS SHOULD BE DONE IN THE THREADS CLASS
								
								/*if(button.getText().equals("0")){
									button.setText("3");
								}
								else{
									//do nothing because seat is reserved
								}
								frame.setVisible(true);*/
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

}