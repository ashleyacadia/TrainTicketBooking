package trainSeatBookingApplication;
/**
 * extends train operatorbooks in preffered method of TrainWay
 * @author AshleyC
 *
 */

public class TrainWay extends TrainOperator{

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
			}
		
		
	//search for free first class seat
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
							//check for reservation
							if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
							{
								journey.getSeating().getSeat(searchR,(char)c).setReserved(true);
								reserveSeat=journey.getSeating().getSeat(searchR,(char) c);
								seatFound=true;
							}
						}
						c++;
						if(seatFound)
						{
							searchC=11;
						}
						if(seatFound)
						{
							searchR=11;
						}
					}
				}
			}
			
		
	//search for window seats in economy
			else if(!seatFound)
			{
				int c=65;
				for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
				{
					for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
					{
						//search within first class
						if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==false&&!seatFound)
						{
							if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==SeatType.WINDOW)
							{
								//check for reservation
								if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
								{
									journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
									reserveSeat=journey.getSeating().getSeat(searchR,(char) c);		
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
		return reserveSeat;
	}
	 

	


	@Override
	public Seat reserveEconomy(TrainJourney journey, SeatType seat) {
		boolean eSeatFound=false;
		//reserve requested seat type in first class
		Seat reserveEconomySeat=new Seat();
	
		for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
		{
			int c=65;
			for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
			{
				//search within first class
				if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==false&&!eSeatFound)
				{
					//search for matching seatType
					if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==seat)
					{
						//check for reservation
						if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
						{
							journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
							reserveEconomySeat=journey.getSeating().getSeat(searchR,(char) c);		
							eSeatFound=true;
						}
					}
				}
				c++;
				if(eSeatFound)
				{
					searchC=11;
				}
			}
			if(eSeatFound)
			{
				searchR=11;
			}
		}
		
		//search for first class window seat
		if(reserveEconomySeat==null)
		{
			int c=65;
			for(int searchR=0;searchR<journey.getSeating().nRows;searchR++)
			{
				for(int searchC=0;searchC<journey.getSeating().nColumns;searchC++)
				{
					//search within first class
					if(journey.getSeating().getSeat(searchR,(char)c).isFirstClass()==true&&!eSeatFound)
					{
						if(journey.getSeating().getSeat(searchR,(char)c).getSeatType()==SeatType.WINDOW)
						{
						//check for reservation
							if(journey.getSeating().getSeat(searchR,(char)c).isReserved()==false)
							{
								journey.getSeating().getSeat(searchR, (char)c).setReserved(true);
								reserveEconomySeat=journey.getSeating().getSeat(searchR,(char) c);		
								eSeatFound=true;
							}
						}
					}
					c++;
				}
			}
		}
		return reserveEconomySeat;
	}
}
