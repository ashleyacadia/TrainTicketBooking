package trainSeatBookingApplication;
/**
 * Seat hold informaion regarding the seat type, class, reserved or not, and seat position.
 * @author AshleyC
 *
 */

public class Seat {
	private SeatType seatType;
	private boolean firstClass;
	private boolean reserved;
	private SeatPosition seatPosition;

	Seat()
	{
		seatType=SeatType.NONE;
		firstClass=false;
		reserved=false;
		seatPosition=null;
		
	}
	
	Seat(SeatType selectedType, boolean fClass, boolean inReserved, SeatPosition selectedPosition)
	{
		seatType = selectedType;
		firstClass = fClass;
		reserved = inReserved;
		seatPosition = selectedPosition;
	}

	public SeatType getSeatType() {
		//get seat type
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		//set seat type
		this.seatType = seatType;
	}

	public boolean isFirstClass() {
		//get is first class
		return firstClass;
	}

	public void setFirstClass(boolean firstClass) {
		//set is first class
		this.firstClass = firstClass;
	}

	public boolean isReserved() {
		//check if seat is reserved
		return reserved;
	}

	public void setReserved(boolean reserved) {
		//reserve seat
		this.reserved = reserved;
	}

	public SeatPosition getSeatPosition() {
		//get seat position
		return seatPosition;
	}

	public void setSeatPosition(SeatPosition seatPosition) {
		//set seat position
		this.seatPosition = seatPosition;
	}
	public String toDescription()
	{
		//a more described version of seat positions
		String description=" ";
		String booked=" ";
		if(this.isFirstClass())
		{
			description="First class";
		}
		else if(!this.isFirstClass())
		{
			description="Economy class";
		}
		if(this.reserved)
		{
			booked=" is";
		}
		else if(!this.reserved)
		{
			booked=" is not";
		}
		return  description+" "+this.seatType.toString()+" seat at: " +(this.seatPosition.getRow()+1)+this.seatPosition.getColumn()+booked+" booked";
	}
	
	public String toString ()
	{
		//short hand version of seat positions
		String seatString="/0";
		if(this.isFirstClass()==true)
		{
			//printing out seat type
			if(this.getSeatType()==SeatType.WINDOW)
			{
				seatString="W";
			}
			else if(this.getSeatType()==SeatType.AISLE)
			{
				seatString="A";
			}
			else if(this.getSeatType()==SeatType.MIDDLE)
			{
				seatString="M";
			}
			//printing out reserved
			if(this.isReserved()==false)
			{
				seatString+="_";
			}
			else if(this.isReserved()==true)
			{
				seatString+="X";
			}
		}
		else if(this.isFirstClass()==false)
		{
			//printing out seat type
			if(this.getSeatType()==SeatType.WINDOW)
			{
				seatString="w";
			}
			else if(this.getSeatType()==SeatType.AISLE)
			{
				seatString="a";
			}
			else if(this.getSeatType()==SeatType.MIDDLE)
			{
				seatString="m";
			}
			//printing out reserved
			if(this.isReserved()==false)
			{
				seatString+="_";
			}
			else if(this.isReserved()==true)
			{
				seatString+="X";
			}
		}
		return "["+seatString+"]";
	}
	
}
