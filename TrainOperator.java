package trainSeatBookingApplication;
/**
 * train operator gets and sets train operator's name and preferred booking methds, abstract class
 * @author AshleyC
 *
 */

public abstract class TrainOperator {
	String operatorName;
	
	TrainOperator()
	{
		operatorName="UNKNOWN";
	}
	
	TrainOperator(String name)
	{
		operatorName=name;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
	public abstract Seat reserveFirstClass(TrainJourney journey,SeatType seat);
	
	public abstract Seat reserveEconomy(TrainJourney journey, SeatType seat);
	
	public String toString()
	{
		return "Name: " +operatorName;
	}
}
