package trainSeatBookingApplication;
/**
 *Seat position holds int and char values according to the seats position in rows and columns
 * @author AshleyC
 *
 */
public class SeatPosition {
	private int row;
	private char column;
	
	SeatPosition()
	{
		row=0;
		column='\0';
	}
	SeatPosition(int selectedRow, char selectedColumn)
	{
		row=selectedRow;
		column=selectedColumn;
	}
	public int getRow() {
		//gets row number
		return row;
	}
	public void setRow(int row) {
		//sets row number
		this.row = row;
	}
	public char getColumn() {
		//gets colunm char
		return column;
	}
	public void setColoum(char column) {
		//sets colunm char
		this.column = column;
	}
	

}
