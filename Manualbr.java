import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.concurrent.locks.*;

/** Manualbr class sets up the airplane seating using buttons.
 * Sets the buttons to unclickable and updates the global arraylist
 * of buttons and the seating array, when clicked.
 * Has access to Airplanes.aLock, ArrayList&lt;JButton&gt; buttons.
 */

public class Manualbr implements Runnable{

	private int brokerID;
	private Airplane airplane;

	/** Instantiate Manual broker properties.
	 * @param id 			the broker's id
	 * @param airplane 		the airplane object
	 */

	
	public Manualbr(int id, Airplane airplane){
		this.brokerID = id;
		this.airplane = airplane;
	}

	/** Sets up the airplane seating GUI.
	 * Adds in all the buttons, keeping a space for the aisle.
	 * @precondition the button is still clickable
	 */

	public void run(){

		Airplane.aLock.lock();

		JFrame manualreservation = new JFrame();
		manualreservation.setTitle("Airplane Reservation System");
		manualreservation.setPreferredSize(new Dimension(500,500));
		JPanel panel = new JPanel(new GridLayout(50,5));
		JPanel container = new JPanel();

		for(int rows = 0; rows < 50; rows++){
			for(int columns = 0; columns < 5; columns++){
				if(columns == 2){
					JButton empty = new JButton("");
					empty.setEnabled(false);
					panel.add(empty);

				}
				else{
					JButton button = new JButton();

					if(columns >2){
						button.setText((rows) + "," + (columns-1));
						Airplane.buttons.add(button);
					}
					else{
						button.setText((rows) + "," + (columns));
						Airplane.buttons.add(button);
					}

					/** Attached an Action Listener to every button.
					 * Sets the clicked button to un-clickable
					 * and updates the button ArrayList and seating array.
					 */

					button.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent seatselected){
									
							JButton buttonclicked = (JButton)seatselected.getSource();
							String[] temp = buttonclicked.getText().split(",");
							int[] location = new int[temp.length];
							for(int i = 0; i < temp.length; i++){
								location[i] = Integer.parseInt(temp[i]);
							}
							int loc = location[0]*4 + location[1];

							airplane.setSeat(location[0], location[1], 3);
							buttonclicked.setText("3");
							buttonclicked.setEnabled(false);
							Airplane.buttons.add(buttonclicked);
							Airplane.buttons.get(loc).setEnabled(false);
							Airplane.buttons.get(loc).setText("3");
						}
					});
				panel.add(button);
				}
			}
		}
				
		container.add(panel);
		JScrollPane jsp = new JScrollPane(container);

		manualreservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		manualreservation.add(jsp);
		manualreservation.pack();
		manualreservation.setVisible(true);

		Airplane.aLock.unlock();
	}
}