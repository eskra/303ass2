import java.lang.*;
import java.util.*;

public class automaticbroker implements Runnable{

	private int brokerID;
	private Airplane airplane;
	private boolean running;

	public automaticbroker createBroker(int id, Airplane airplane){
		this.brokerID = id;
		this.airplane = airplane;
		this.running = false;
		return this;
	}

	private int getBrokerID(){
		return this.brokerID;
	}

	public void terminate(){
		this.running = false;
	}

	public void run(){
		try{

			this.running = true;

			while(running){
			//while(!airplane.isFull()){
				//range for column is [0,4[
				//range for row is [0,50[

				int randomrow = ((new Random()).nextInt(50));
				int randomcolumn = ((new Random()).nextInt(4));
				System.out.println(randomrow);
				System.out.println(randomcolumn);

				//if seat is not already taken
				if(airplane.findSeat(randomrow, randomcolumn)){
					//if the chosen ints are valid
					if(randomrow >= 0 && randomrow < 50 && randomcolumn >= 0 && randomcolumn < 4){
						//sets the seat as taken by that broker
						airplane.setSeat(randomrow, randomcolumn, this.brokerID);
						System.out.println(airplane.getSeatID(randomrow, randomcolumn));
					}
				}
				Thread.sleep(900);
				this.terminate();

			}
		} catch (InterruptedException exception){
			System.out.println("Something went wrong.");
		}
	}
}