

public class Airplane{

	private int[][] seating = new int [50][4];
	private final int numberOfColumns = 4;
	private final int numberOfRows = 50;

	/*private void initializeAirplane(int colNum, int rowNum){
		Airplane airplane = new Airplane();
		this.numberOfColumns = colNum;
		this.numberOfRows = rowNum;
		this.seating = new int[colNum][rowNum];
	}*/

	public static void main(String[] args){

		appWindow w = new appWindow();
		Airplane airplane = new Airplane();

		automaticbroker broker1 = new automaticbroker(1);
		automaticbroker broker2 = new automaticbroker(2);
		manualbroker broker3 = new manualbroker(3);

	}

}