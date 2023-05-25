package application;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModelEmergencyRoom {
	
	public static Scanner KB = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException 
	{
		System.out.println("Please enter the name of the Emergency Room:");
		String name = KB.nextLine();
		System.out.println("Please enter a seed value as an int:");
		int seed = KB.nextInt();
		
		EmergencyRoom obj = new EmergencyRoom(name, seed);
		
		System.out.println("Please enter the number of doctors as an int:");
		int numOfDocs = KB.nextInt();
		
		obj.initializeER(numOfDocs);
		
		System.out.println("Please enter the number of minutes to keep Emergency Room open for new patients:");
		int minutes = KB.nextInt();
		obj.operateEmergencyRoom(minutes);
		
		System.out.println("Please enter the name of the output file for Emergency Room results: ");
		String fileName = KB.next();
		obj.generateEmergencyRoomResults(fileName);

	}

}
