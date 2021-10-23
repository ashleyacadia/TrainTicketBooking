package trainSeatBookingApplication;
/**
 * Train journey hold relevant information about the journey, start and end destination, depature time, journey number, and seating floor grid
 * @author AshleyC
 *
 */

public class TrainJourney {
	private String sourceCity;
	private String destCity;
	private String departureTime;
	private String journeyNumber;
	private FloorGrid seating;
	
	TrainJourney()
	{
		sourceCity="UNKNOWN";
		destCity="UNKNOWN";
		departureTime="UNKNOWN";
		journeyNumber="UNKNOWN";
		seating=null;
	}
	TrainJourney(String startCity, String destinationCity, String leaveTime, 
			String number, FloorGrid seatingPlan)
	{
		sourceCity=startCity;
		destCity=destinationCity;
		departureTime=leaveTime;
		journeyNumber=number;
		seating=seatingPlan;
	}
	public String getSourceCity() {
		//get source city
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		//	setting source city
		this.sourceCity = sourceCity;
	}
	public String getDestCity() {
		//get destination city
		return destCity;
	}
	public void setDestCity(String destCity) {
		//set destination city
		this.destCity = destCity;
	}
	public String getDepartureTime() {
		//get depature time
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		//set depature time
		this.departureTime = departureTime;
	}
	public String getJourneyNumber() {
		//get journey number
		return journeyNumber;
	}
	public void setJourneyNumber(String journeyNumber) {
		//set journey number
		this.journeyNumber = journeyNumber;
	}
	public FloorGrid getSeating() {
		//get seating floor grid
		return seating;
	}
	public void setSeating(FloorGrid seating) {
		//get seating floor grid
		this.seating = seating;
	}
	
	public String toString()
	//returns string of destination city
	{
		return "Destination City: "+destCity;
	}
}
