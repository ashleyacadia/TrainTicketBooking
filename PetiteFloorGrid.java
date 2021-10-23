package trainSeatBookingApplication;
/**
 * Petite Floor grid extends FloorGrid and initalises a smaller floor grid for a smaller train.
 * @author AshleyC
 *
 */

public class PetiteFloorGrid extends FloorGrid {
	public PetiteFloorGrid()
	{
		super();
		this.nRows=10;
		this.nColumns=7;
		this.nFirstClass=4;
		this.seats=new Seat[nRows][nColumns];

	}
	public void initalisedFloorGrid()
	{
		//initalises floor grid
		for (int row=0; row < nRows; row++)
		{
			char c ='A';

			for(int column=0;column<nColumns; column++)
			{
				//setting seat position
				SeatPosition sp=new SeatPosition();
				sp.setColoum(c);
				sp.setRow(row);
				//
				Seat trial= new Seat();
				seats[row][column]=trial;
				
				trial.setSeatPosition(sp);
				
				//setting first class
				if(row<nFirstClass)
				{
					seats[row][column].setFirstClass(true);
				}
				else if(row>nFirstClass)
				{
					seats[row][column].setFirstClass(false);
				}
				
				//setting seat types
				if(column==0||column==6)
				{
					seats[row][column].setSeatType(SeatType.WINDOW);
				}
				else if(column==1||column==2||column==4||column==5)
				{
					seats[row][column].setSeatType(SeatType.AISLE);
				}
				else if(column==3)
				{
					seats[row][column].setSeatType(SeatType.MIDDLE);
				}
				c++;
			}
		}
	}
}

