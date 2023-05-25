package application;

import java.util.Random;

abstract class ERPatient 
{
	static int erPatientIDCounter = 0;
	public int variablesAge; public int arrivalTime; public int startCareTime; public int careDuration; public int waitTime; public int totalTime;
	public String erPatientID;
	public Doctor erPatientDoctor;
	static Random randy = new Random(2);
	
	public ERPatient(int arrivalTime)
	{
		setAge();
		setERPatientID();
	    setArrivalTime(arrivalTime);
	}
	
	public int getERPatientDoctorIDNumber()
	{
		return Integer.parseInt(erPatientID);
	}
	
	public int getERPatientIDCounter()
	{
		return erPatientIDCounter;
	}
	
	public void setArrivalTime(int num)
	{
		arrivalTime = num;
	}
	public int getArrivalTime()
	{
		return arrivalTime;
	}
	
	public void setAge()
	{
		variablesAge = randy.nextInt(75-20)+20;
	}
	public int getAge()
	{
		return variablesAge;
	}
	public void setERPatientID()
	{
		erPatientIDCounter++;
		String line = String.valueOf(erPatientIDCounter);
		String patient = "ERPatient";
		erPatientID = patient.concat(line);
	}
	public String getERPatientID()
	{
		return erPatientID;
	}
	
	public void setERPatientDoctor(Doctor ref)
	{
		erPatientDoctor=ref;
	}
	public Doctor getERPatientDoctor()
	{
		return erPatientDoctor;
	}
	
	public void setStartCareTime(int num)
	{
		startCareTime = num;
		waitTime = startCareTime - arrivalTime;
	}
	public int getStartCareTime()
	{
		return startCareTime;
	}
	public int getWaitTime()
	{
		return waitTime;
	}
	
	public void setTotalTime(int endTime)
	{
		totalTime = endTime - arrivalTime;
	}
	public int getTotalTime()
	{
		return totalTime;
	}
	
	public void setCareDuration(int careDurationT)
	{
		careDuration = careDurationT;
	}
	public int getCareDuration()
	{
		return careDuration;
	}
	
	public abstract void setERPatientPriority();
	public abstract String getERPatientPriority();

}
