package trainSeatBookingApplication;
/**
 * Floor grid abstract class for two other versions of a floor grid
 * @author AshleyC
 *
 */

public abstract class FloorGrid {
	protected Seat seats[][];
	protected int nRows;
	protected int nColumns;
	protected int nFirstClass;
	
	abstract protected void initalisedFloorGrid();
	//ti initalise floor grid acording to size
	
	public char lastSeatPosition()
	{
		//get ;ast seat position
		char lastSeat=(char)this.nColumns;
		return lastSeat;
	}
	
	public int lastSeatRow()
	{
		//get lst seat row
		return this.nRows;
	}
	public Seat getLeftSeat(Seat selectedSeat)
	{
		//get if left seat is empty
		Seat leftSeat=new Seat();
		leftSeat.getSeatPosition().setColoum((char) ((char)selectedSeat.getSeatPosition().getColumn()-1));
//		setSeatPosition((char)(selectedSeat.getSeatPosition().getColumn()-1));
		 return leftSeat;  
	}
	
	public Seat getRightSeat(Seat selectedSeat)
	{
		//get if right seat is empty
		Seat rightSeat=new Seat();
		rightSeat.getSeatPosition().setColoum((char) ((char)selectedSeat.getSeatPosition().getColumn()+1));
		return rightSeat;
	}
	
	public String toString()
	{
		//print out floor grid
		String floorGridString="\0";
		int c=65;
		String spacing="   ";

		//print out letters
		for(int z=0;z<this.nColumns;z++)
		{
			floorGridString+=spacing+(char)(c+z)+spacing;
		}
		floorGridString+="\n";
		//print out seats
		for(int rows=0;rows<this.nRows;rows++)
		{
			for(int columns=-1; columns<this.nColumns; columns++)
			{
				if(columns==-1)
				{
					if(rows>=9)
					{
						floorGridString+= (rows+1)+"  ";
					}
					else
					{
						floorGridString+= (rows+1)+spacing;
					}
				}
				else
				{
					floorGridString+= this.seats[rows][columns].toString()+spacing;
				}
			}
				floorGridString+='\n';
		}
		return floorGridString;
	}
	
	public Seat queryAvailableEconomySeat(SeatType aType)
	{
		//find available seat
		boolean availableFound=false;
		Seat availableSeat=new Seat();
		//searching for matching seats rows
		for(int x=(0+this.nFirstClass);x<this.nRows; x++)
		{
			int c=65;
			//search through columns
			for(int y=0; y<this.nColumns; y++)
			{
				if(getSeat(x,(char)c).isFirstClass()==false)
				{
					if(getSeat(x,(char)c).isReserved()==false)
					{
						if(getSeat(x,(char)c).getSeatType()==aType)
						{
							availableSeat=getSeat(x,(char)c);
							availableFound=true;
						}
					}
				}
				c++;
				if(availableFound)
				{
					y=11;
				}
			}
			if(availableFound)
			{
				x=11;
			}
		}
		return availableSeat;
	}
	
	 
	public Seat queryAvailableFirstClassSeat(SeatType fClass)
	{
		//find available seat
		boolean availableFound=false;
		Seat fClassAvailableSeat=new Seat();
		//searching for matching seats rows
		for(int x=0;x<this.nRows; x++)
		{
			int c=65;
			//search through columns
			for(int y=0; y<this.nColumns; y++)
			{
				if(getSeat(x,(char)c).isFirstClass()==true)
				{
					if(getSeat(x,(char)c).isReserved()==false)
					{
						if(getSeat(x,(char)c).getSeatType()==fClass)
						{
							fClassAvailableSeat=getSeat(x,(char)c);
							availableFound=true;
						}
					}
					
				}
				c++;
				if(availableFound)
				{
					y=11;
				}
			}
			if(availableFound)
			{
				x=11;
			}
		}
		return fClassAvailableSeat; 
	}
	
	public Seat getSeat(int row, char c)
	{
		//get seat
//		Seat newSeat=new Seat();
		 return this.seats[row][(int)(c-65)];
//		 = newSeat;
	}
	
}


	


