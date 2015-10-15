import java.lang.*;
import java.util.*;

public class automaticbroker implements Runnable{

	private int brokerID;
	private Airplane airplane;

	public automaticbroker createBroker(int id, Airplane airplane){
		this.brokerID = id;
		this.airplane = airplane;
		return this;
	}

	private int getBrokerID(){
		return this.brokerID;
	}

	public void run(){
		//implement a try, catch ?

		while(!airplane.isFull()){
			//range for column is [0,4[
			//range for row is [0,50[

			int randomrow = (Math.random() * (50));
			int randomcolumn = (Math.random() * (4));
			if(airplane.findSeat(randomrow, randomcolumn)){
				//sets the seat as taken by that broker
				airplane.setSeat(randomrow, randomcolumn, this.brokerID);
			}
			Thread.sleep(900);
		}

		//for a random ints, between 0 and 50 and between 0 and 4, 
		//randomly reserve seats if it isnt already
		/*try{

		//search for a seat
		//no delay? because we don't want other threads to get in
		//we will lock the thread in the airplane class
		//we will also make sure to check that not all seats are taken (int?)

		} catch(InterruptedException exception){
			System.out.println("Something went wrong.");
		}*/


	}
}