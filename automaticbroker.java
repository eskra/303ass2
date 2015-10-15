import java.lang.*;

public class automaticbroker implements Runnable{

	private int brokerID;

	public void createBroker(int id){
		this.brokerID = id;
	}

	public void run(){
		try{

		//search for a seat
		//no delay? because we don't want other threads to get in
		//we will lock the thread in the airplane class
		//we will also make sure to check that not all seats are taken (int?)

		} catch(InterruptedException exception){
			System.out.println("Something went wrong.");
		}


	}


}