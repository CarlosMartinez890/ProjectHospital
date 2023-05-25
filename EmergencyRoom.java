package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class EmergencyRoom 
{
	Random randy;
	public PriorityQueue<ERPatient> erWaitingQ;
	public ArrayList<Doctor> doctorAvailableList = new ArrayList<>();
	public ArrayList<Doctor> doctorBusyList = new ArrayList<>();
	public ArrayList<ERPatient> caredFor = new ArrayList<>();
	private String erName;
	private int currentTime = 0;
	DecimalFormat df = new DecimalFormat("0.##");
	
	public EmergencyRoom(String name, int seed)
	{
		erName = name;
		erWaitingQ = new PriorityQueue<>(new ERPatientPriority());
		randy = new Random(seed);
	}
	
	public void initializeER(int numDoctors) {
        for (int i = 0; i < numDoctors; i++) 
        {
            doctorAvailableList.add(new Doctor());
        }
            for (int a = 0; a < 15; a++) 
            {
                int value = this.randy.nextInt(10-1+1) + 1;
                if (value >= 1 && value <= 2) {
                    erWaitingQ.add(new HighPriortyPatient(currentTime));
                } else if (value >= 3 && value <= 5) {
                    
                    erWaitingQ.add(new IntermediatePriorityPatient(currentTime));

                } else {
                    erWaitingQ.add(new LowPriorityPatient(currentTime));
                }
            }
           
            currentTime = 1;
        }
	
	public void operateEmergencyRoom(int durationForArriving)
	{
		int endArrivalsTime = currentTime + durationForArriving;
		ERPatient tempPatient;
		Doctor tempDoctor;
		int randomNum;
		
		while(!(this.caredFor.size() == ERPatient.erPatientIDCounter) || currentTime < endArrivalsTime)
		{
			if(currentTime< endArrivalsTime)
			{
				for(int i = 0;i<3;i++)
				{
					randomNum = randy.nextInt(10-1+1) + 1;
					if(randomNum >= 1 && randomNum <= 2)
					{
						erWaitingQ.add(new LowPriorityPatient(currentTime));
					}
					else if(randomNum >= 3 && randomNum <= 5)
					{
						erWaitingQ.add(new IntermediatePriorityPatient(currentTime));
					}
					else
						erWaitingQ.add(new HighPriortyPatient(currentTime));
				}
			}
			for(int j = 0; j<doctorBusyList.size();j++)
			{
				tempDoctor = doctorBusyList.get(j);
				tempDoctor.decrementTimeRemainingForCare();
				if(tempDoctor.getTimeRemainingForCare() == 0)
				{
					tempPatient = tempDoctor.getAssignedERPatient();
					caredFor.add(tempPatient);
					tempPatient.setTotalTime(currentTime);
					tempDoctor.removeAssignedPatient();
					doctorBusyList.remove(tempDoctor);
					doctorAvailableList.add(tempDoctor);
					j--;
				}
			}
			
			while(!doctorAvailableList.isEmpty() && !erWaitingQ.isEmpty())
			{
				tempPatient = erWaitingQ.remove();
				tempPatient.setStartCareTime(currentTime);
				tempDoctor = doctorAvailableList.remove(0);
				//doctorAvailableList.remove(0);
				doctorBusyList.add(tempDoctor);
				tempDoctor.setAssignedERPatient(tempPatient);
				tempPatient.setERPatientDoctor(tempDoctor);
				randomNum = randy.nextInt(40-10+1)+10;
				tempPatient.setCareDuration(randomNum);
				tempDoctor.setTimeRemainingForCare(randomNum);
			}
			currentTime++;
		}
		
	}
	
	public void generateEmergencyRoomResults(String line) throws FileNotFoundException
	{
		PrintWriter outputFile = new PrintWriter(line);
		
		outputFile.println("Data For Emergency Room " + erName);
		
		outputFile.println("Summary Data");
		for(int i =0;i<doctorAvailableList.size();i++)
		{
			outputFile.println(doctorAvailableList.get(i).toString());
		}
		outputFile.println();
		
		int counter = 0;
		double waitPat = 0;
		for(int j = 0;j<caredFor.size();j++)
		{
			if(caredFor.get(j).getERPatientPriority() == "High")
			{
				counter++;
				waitPat =+ caredFor.get(j).getTotalTime();
			}
		}
		outputFile.println("The average total time in ER for " + counter + " High Priority Patients is " + df.format(waitPat/counter) + " minutes");
		
		int counter2 = 0;
		double waitPat2 = 0;
		for(int j = 0;j<caredFor.size();j++)
		{
			if(caredFor.get(j).getERPatientPriority() == "Intermediate")
			{
				counter2++;
				waitPat2 =+ caredFor.get(j).getTotalTime();
			}
		}
		outputFile.println("The average total time in ER for " + counter2 + " Intermediate Priority Patients is " + df.format(waitPat2/counter2) + " minutes");
		
		int counter3 = 0;
		double waitPat3 = 0;
		for(int j = 0;j<caredFor.size();j++)
		{
			if(caredFor.get(j).getERPatientPriority() == "low")
			{
				counter3++;
				waitPat3 =+ caredFor.get(j).getTotalTime();
			}
		}
		outputFile.println("The average total time in ER for " + counter3 + " Low Priority Patients is " + df.format(waitPat3/counter3) + " minutes");
		
		int counter4 = 0;
		double waitPat4 = 0;
		for(int j = 0;j<caredFor.size();j++)
		{
				counter4++;
				waitPat4 =+ caredFor.get(j).getTotalTime();
		}
		outputFile.println("The average total time in ER for all " + counter4 + " High Priority Patients is " + df.format(waitPat4/counter4) + " minutes");
		
		
		outputFile.println("PATIENT ID      PRIORITY    DOCTOR ID    AGE    ARRIVAL TIME   WAIT TIME START CARE TIME CARE DURATION  TOTAL TIME");
		for(int c = 0;c<caredFor.size();c++)
		{
			outputFile.println(caredFor.get(c).erPatientID + "      " + caredFor.get(c).getERPatientPriority()+ "        " + caredFor.get(c).getERPatientDoctor().getDoctorIDNumber() + "        " + caredFor.get(c).getAge() + "        " + caredFor.get(c).getArrivalTime() + "        " + caredFor.get(c).getWaitTime() + "        " + caredFor.get(c).getStartCareTime() + "         " + caredFor.get(c).getCareDuration() + "          " + caredFor.get(c).getTotalTime());
		}
		
		outputFile.close();
	}
	

}
