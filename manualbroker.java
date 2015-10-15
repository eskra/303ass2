import java.lang.*;

public class manualbroker implements Runnable{

	private int brokerID;

	public void createBroker(int id){
		this.brokerID = id;
	}

	public void run(){
		try{
		//should i make this a broker interface instead?
		//advantages of making a broker interface:
			//1. the run methods are not all the same and they don't have to be
			//2. interfaces can work across different types of object
			//note that 2 is not really needed because our objects are specifically
			//of type broker
			//so we could instead create a class called broker, and implement different
			//methods with that, but is that useful?
			//let's stick with this for now

		//search for a seat
		//no delay? because we don't want other threads to get in
		//we will lock the thread in the airplane class
		//we will also make sure to check that not all seats are taken (int?)

		} catch(InterruptedException exception){
			System.out.println("Something went wrong.");
		}


	}


}