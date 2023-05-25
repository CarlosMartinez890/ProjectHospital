package application;

public class IntermediatePriorityPatient extends ERPatient
{
	public String erPatientPriorty;

	public IntermediatePriorityPatient(int arrivalTime) 
	{
		super(arrivalTime);
		setERPatientPriority();
	}

	@Override
	public
	void setERPatientPriority() 
	{
		erPatientPriorty = "Intermediate";
	}

	@Override
	public
	String getERPatientPriority() 
	{
		return erPatientPriorty;
	}
	
	public String toString()
	{
		return "The intermediate priority patient who is "+ getAge() + "  years old with ID "+ getERPatientDoctor() + " waited "+ getWaitTime()+ " minutes to be seen";
	}
}
