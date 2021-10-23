package trainSeatBookingApplication;
/**
 * extends train operatorbooks in preffered method of TrainSmart
 * @author AshleyC
 *
 */

public class TrainSmart extends TrainOperator {

	@Override
	public Seat reserveFirstClass(TrainJourney journey, SeatType seat) {
		boolean seatFound=false;
		Seat reserveSeat = new Seat();
	//reserve requested seat type in first class
		
		for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
		{
			int c=65;
			for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
			{
				//search within first class
				if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==true&&!seatFound)
				{
					//search for matching seatType
					if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==seat)
					{
						//check for reservation
						if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
						{
							journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
							reserveSeat=journey.getSeating().getSeat(searchR,(char) c);
						//stop searching
							seatFound=true;			
						}
					}
				}
				c++;
				if(seatFound)
				{
					searchC=11;
				}
			}
			if(seatFound)
			{
				searchR=11;
			}
		}
	//search for AISLE or WINDOW in economy
	 if(!seatFound)
	 {
		 int c=65;
		 for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
			{
				for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
				{
					//search within first class
					if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==false&&!seatFound)
					{
						if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==SeatType.WINDOW
								||journey.getSeating().getSeat(searchR,(char)c).getSeatType()==SeatType.AISLE)
						{
						//check for reservation
							if(journey.getSeating().getLeftSeat(journey.getSeating().getSeat(searchR,(char)c)).isReserved()==false)
							{
								journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
								reserveSeat=journey.getSeating().getSeat(searchR,(char) c);
							//stop searching
								seatFound=true;							}
							else if(journey.getSeating().getRightSeat(journey.getSeating().getSeat(searchR,(char)c)).isReserved()==false)
							{
								journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
								reserveSeat=journey.getSeating().getSeat(searchR,(char) c);
							//stop searching
								seatFound=true;							}
							//should still be null if both are false
						}
						//if not window or aisle then should loop 
					}
					c++;
					if(seatFound)
					{
						searchC=11;
					}
				}
				if(seatFound)
				{
					searchR=11;
				}
			}
	 }
	return reserveSeat;
}

	@Override
	public Seat reserveEconomy(TrainJourney journey, SeatType seat) {
		boolean seatFound=false;
		Seat reserveEconomySeat = new Seat();
		//reserve requested seat type in first class	
		for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
		{
			int c=65;
			for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
			{
				//search within first class
				if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==false&&!seatFound)
				{
					//search for matching seatType
					if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==seat)
					{
						//check for reservation
						if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
						{
							journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
							reserveEconomySeat=journey.getSeating().getSeat(searchR,(char) c);
						//stop searching
							seatFound=true;
						}
					}
				}
				c++;
				if(seatFound)
				{
					searchC=11;
				}
			}
			if(seatFound)
			{
				searchR=11;
			}
		}
		
		//search for first class window seat
		if(!seatFound)
		{
			int c=65;
			for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
			{
				for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
				{
					//search within first class
					if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==true&&!seatFound)
					{
						if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==SeatType.WINDOW)
						{
						//check for reservation
							if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
							{
								journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
								reserveEconomySeat=journey.getSeating().getSeat(searchR,(char) c);
							//stop searching
								seatFound=true;
							}
						}
					}
					c++;
					if(seatFound)
					{
						searchC=11;
					}
				}
				if(seatFound)
				{
					searchR=11;
				}
			}
		}
		return reserveEconomySeat;
	}

}
