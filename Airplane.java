import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.*;


public class Airplane extends JFrame{

	private int[][] seating = new int [50][4];
	private final int numberOfColumns = 4;
	private final int numberOfRows = 50;

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
	}
}