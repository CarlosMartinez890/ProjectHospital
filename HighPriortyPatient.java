package application;

public class HighPriortyPatient extends ERPatient 
{
	public String erPatientPriorty;

	public HighPriortyPatient(int arrivalTime) 
	{
		super(arrivalTime);
		setERPatientPriority();
	}

	@Override
	public
	void setERPatientPriority() 
	{
		erPatientPriorty = "High";
	}

	@Override
	public
	String getERPatientPriority() 
	{
		return erPatientPriorty;
	}
	
	public String toString()
	{
		return "The High priority patient who is "+ getAge() + "  years old with ID "+ getERPatientDoctor() + " waited "+ getWaitTime()+ " minutes to be seen";
	}

}
