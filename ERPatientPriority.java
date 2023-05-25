package application;

import java.util.Comparator;

public class ERPatientPriority implements Comparator<ERPatient>
{
	@Override
	public int compare(ERPatient o1, ERPatient o2) {
		if(o1.getClass().equals(o2.getClass()))
		{
			if(o1.getAge()== o2.getAge())
			{
				return (o1.getArrivalTime()-o2.getArrivalTime());
			}
			else
				return (o2.getAge()- o1.getAge());
		}
		else
			return o1.getERPatientPriority().compareTo(o2.getERPatientPriority());
	}
}
