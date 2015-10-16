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
	public int[][] getSeating(){
		return this.seating;
	}

	public int getSeatID(int rowNum, int colNum){
		return this.seating[rowNum][colNum];
	}

	public boolean findSeat(int rowNum, int colNum){
		//returns true is seat is empty, false if full
		if(this.seating[rowNum][colNum] == 0){
			//seat is empty
			return true;
		} else return false;
	}

	public boolean isFull(){

		int c = this.numberOfColumns;
		int r = this.numberOfRows;

		for(int x = 0; x < c; x++){
			for(int y= 0; y < r; y++){
				if(this.seating[y][x] == 0){
					return false;
				}
			}
		}
		return true;
	}

	public void setSeat(int rowNum, int colNum, int id){

		if(this.findSeat(rowNum, colNum)){
			this.seating[rowNum][colNum] = id;
		}
	}

	public static void main(String[] args){

		//appWindow w = new appWindow(airplane);
		//instantiate airlane, runnables, threads
		Airplane airplane = new Airplane();

		//appWindow w = new appWindow();
		appWindow w = new appWindow(airplane);
		//w.create(airplane);
		/*Runnable br1 = new automaticbroker().createBroker(1, airplane);
		Runnable br2 = new automaticbroker().createBroker(2, airplane);
		Runnable br3 = new manualbroker().createBroker(3, airplane);
		Thread tbr1 = new Thread(br1);
		Thread tbr2 = new Thread(br2);
		Thread tbr3 = new Thread(br3);
		*/
		//AppWindow(airplane);

		/*automaticbroker broker1 = (new automaticbroker()).createBroker(1);
		automaticbroker broker2 = (new automaticbroker()).createBroker(2);
		manualbroker broker3 = (new manualbroker()).createBroker(3);
		*/
		
		/*JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500,500));

		JLabel greeting = new JLabel("Automatic brokers are currently running.");
		//JLabel greeting = new JLabel("Select which broker you would like to reserve with.");

		//for organization
		JPanel automaticpanel = new JPanel();
		JPanel manualpanel = new JPanel();

		//create buttons and window layout
		//JButton broker1button = new JButton("Reserve Using Automatic Broker 1");
		//JButton broker2button = new JButton("Reserve Using Automatic Broker 2");
		JButton broker3button = new JButton("Reserve");

		//automaticpanel.add(broker1button);
		//automaticpanel.add(broker2button);
		manualpanel.add(new JLabel("If you would like to View the Airplane..."));
		manualpanel.add(new JLabel("Reserve Using Manual Broker"));
		manualpanel.add(broker3button);

		frame.setLayout(new FlowLayout());
		frame.add(greeting);
		frame.add(automaticpanel);
		frame.add(manualpanel);
		//frame.add(new JTextField(20));
		frame.add(broker3button);
		//fix layout stuff so that it doesnt move when resizing

		//finalize frame and display
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		//IMPLEMENT BUTTONS ACTIONS

		//FOR NOW COMMENT OUT AUTOMATIC BROKER BUTTONS
		//THE POINT OF THIS WHOLE THING IS THAT THE AUTOMATIC 
		//BROKERS ARE LOOKING ALWAYS FOR SEATS

		/*broker1button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				tbr1.start();
				//TODO: IMPLEMENT LOCKING ??
			}
		});

		broker2button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				tbr2.start();
			}
		});*/

		//IMPLEMENT CLICKING OF MANUAL RESERVATION
		//TODO: MAKE THE MENU REAPPEAR? 
		//MAKE SURE WE DONT LOSE DATA
		/*broker3button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){

				JFrame manualreservation = new JFrame();
				manualreservation.setPreferredSize(new Dimension(800,400));
				JPanel panel = new JPanel(new GridLayout(5,50));

				for(int columns = 0; columns < 4; columns++){
					for(int rows = 0; rows < 50; rows++){
						JButton button = new JButton(Integer.toString(airplane.seating[rows][columns]));
						button.addActionListener(new ActionListener(){

							public void actionPerformed(ActionEvent event){

								tbr1.start();

								//ALL ACTIONS SHOULD BE DONE IN THE THREADS CLASS
								
								/*if(button.getText().equals("0")){
									button.setText("3");
								}
								else{
									//do nothing because seat is reserved
								}
								frame.setVisible(true);*/
							/*}
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
			/*}

		});*/
	}
}