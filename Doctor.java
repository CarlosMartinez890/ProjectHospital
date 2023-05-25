package application;

public class Doctor 
{
	static int doctorCounter =0;
	public int doctorIDNumber; public int totalERPatientsProcessedByDoctor; public int timeRemainingForCare;
	ERPatient assignedERPatient;
	
	public Doctor()
	{
		setDoctorIDNumber();
	}
	
	public void setDoctorIDNumber()
	{
		doctorCounter++;
		doctorIDNumber = doctorCounter;
	}
	public int getDoctorIDNumber()
	{
		return doctorIDNumber;
	}
	
	public void setAssignedERPatient(ERPatient patient)
	{
		assignedERPatient = patient;
	}
	public ERPatient getAssignedERPatient()
	{
		return assignedERPatient;
	}
	
	public ERPatient removeAssignedPatient()
	{
		ERPatient temp = assignedERPatient;
		assignedERPatient = null;
		totalERPatientsProcessedByDoctor++;
		return temp;
	}
	public int getTotalERPatientsProcessedByDoctor()
	{
		return totalERPatientsProcessedByDoctor;
	}
	
	public void setTimeRemainingForCare(int time)
	{
		timeRemainingForCare = time;
	}
	
	public int getTimeRemainingForCare()
	{
		return timeRemainingForCare;
	}
	
	
	public void decrementTimeRemainingForCare()
	{
		timeRemainingForCare--;
	}
	
	public String toString()
	{
		return "Doctor "+getDoctorIDNumber() + " gives care to " + getTotalERPatientsProcessedByDoctor() + " persons";
	}

}
