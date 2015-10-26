import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.*;
import java.util.*;
import java.util.concurrent.locks.*;

/** Airplane class has global variables ArrayList&lt;JButton&gt; buttons,
 * ReentrantLock aLock. Airplane object is initialized with an int[][] seating
 * array, which is passed to other classes when they are initialized.
 * Contains get and set methods for the seating array.
 */

public class Airplane extends JFrame{

	public static ArrayList<JButton> buttons = new ArrayList<JButton>();
	public static Lock aLock = new ReentrantLock();
	private int[][] seating = new int [50][4];

	/** Initialize airplane with empty seating array.
	*/

	public void Airplane(){
		this.seating = seating;
	}

	/** Returns false if airplane is not full, true otherwise.
	 * @return true			if airplane full
	 * @return false		if airplane not full
	 */

	public boolean isFull(){
		for(int i = 0; i < 50; i++){
			for(int j = 0; j < 4; j++){
				if(this.seating[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}

	/** Return the int[][] seating array of the airplane.
	 * @return int[][] seating
	 */

	public int[][] getSeating(){
		return seating.clone();
	}

	/** Returns true is the seat specified is empty, false otherwise.
	 * @param rowNum			the select row number
	 * @param colNum			the select column number
	 * @precondition the seat targeted has value 0 in seat array 
	 * @return boolean			true if seat is not taken
	 *							false if seat is taken
	 */

	public boolean findSeat(int rowNum, int colNum){
		if(this.seating[rowNum][colNum] == 0){
			return true;
		} else return false;
	}

	/** Sets the seat coordinates with the specified id.
	 * @param rowNum 		the select row number
	 * @param colNum 		the select column number
	 * @param id 			the reserving broker's id
	 * @precondition the seat is not already taken */

	public void setSeat(int rowNum, int colNum, int id){

		if(this.findSeat(rowNum, colNum)){
			this.seating[rowNum][colNum] = id;
		}
	}

	public static void main(String[] args){

		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(200,200));
		frame.setTitle("Airplane Seat Reservation");
		JPanel panel = new JPanel();
		JButton begin = new JButton("Begin");
		panel.add(begin);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		begin.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent seatselected){
				Airplane airplane = new Airplane();

				Runnable br1 = new Automaticbroker(1, airplane);
				Runnable br2 = new Automaticbroker(2, airplane);
				Runnable br3 = new Manualbr(3, airplane);
				Thread tbr1 = new Thread(br1);
				Thread tbr2 = new Thread(br2);
				Thread tbr3 = new Thread(br3);

				tbr3.start();
				tbr1.start();
				tbr2.start();
			}
		});
	}
}