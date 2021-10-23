package trainSeatBookingApplication;
/**
 * enum of seat types acording to position on train
 * @author AshleyC
 *
 */

public enum SeatType
{
	WINDOW,AISLE,MIDDLE,NONE;
	
	public String toString()
	{
		//returns name of seat type
		return this.name();
	}
}
