package application;

public class LowPriorityPatient extends ERPatient 
{
	public String erPatientPriorty;

	public LowPriorityPatient(int arrivalTime) 
	{
		super(arrivalTime);
		setERPatientPriority();
	}

	@Override
	public
	void setERPatientPriority() 
	{
		erPatientPriorty = "low";
	}

	@Override
	public
	String getERPatientPriority() 
	{
		return erPatientPriorty;
	}
	
	public String toString()
	{
		return "The low priority patient who is "+ getAge() + "  years old with ID "+ getERPatientDoctor() + " waited "+ getWaitTime()+ " minutes to be seen";
	}

}
