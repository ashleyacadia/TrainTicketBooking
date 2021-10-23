package trainSeatBookingApplication;
/**
 * An applicaion to book train seats acording to availability, train operator preferences of boking, and customer's choice
 * @author AshleyC
 *
 */
import java.util.Scanner;

public class MainTwo {
	static Scanner scan=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//setting up train journeys
		TrainJourney journeysAuk[]=new TrainJourney[2];
		FloorGrid aukOne=new PetiteFloorGrid();
		FloorGrid aukTwo=new PetiteFloorGrid();
		journeysAuk[0]=new TrainJourney("Auckland","Wellington","07:10","003",aukOne);	
		journeysAuk[1]=new TrainJourney("Auckland","Wellington","16:00","004",aukTwo);
		
		//set journeys WELLINGTON
		TrainJourney journeysWel[]=new TrainJourney[2];
		FloorGrid welOne=new GrandeFloorGrid();
		FloorGrid welTwo=new PetiteFloorGrid();
		journeysWel[0]=new TrainJourney("Wellington","Auckland","12:00","005",welOne);
		journeysWel[1]=new TrainJourney("Wellington","Auckland","14:30","002",welTwo);
		
		//set up train operators
		TrainWay operatorAuckOne=new TrainWay();
		operatorAuckOne.setOperatorName("Train Driver 1");
		TrainSmart operatorAuckTwo=new TrainSmart();
		operatorAuckTwo.setOperatorName("Train Driver 2");
		TrainWay operatorWelOne=new TrainWay();
		operatorWelOne.setOperatorName("Train Driver 3");
		TrainSmart operatorWelTwo=new TrainSmart();
		operatorWelTwo.setOperatorName("Train Driver 4");

		
		System.out.println("------------------------------------------------");
		System.out.println("Welcome to the Train Ticket Booking application");
		System.out.println("------------------------------------------------");

		//setting up journey for input
		TrainJourney newJourney= new TrainJourney();
		newJourney.setSourceCity(selectCity());
		
		int tripNum;
		if(newJourney.getSourceCity()=="Auckland")
		{
			tripNum=selectTrip(newJourney,journeysAuk);
			//setting newJourney details
			newJourney.setDestCity(journeysAuk[tripNum-1].getDestCity());
			newJourney.setDepartureTime(journeysAuk[tripNum-1].getDepartureTime());
			newJourney.setJourneyNumber(journeysAuk[tripNum-1].getJourneyNumber());
			newJourney.setDestCity(journeysAuk[tripNum-1].getDestCity());
			newJourney.setSeating(journeysAuk[tripNum-1].getSeating());
			if (tripNum==1)
			{
				newJourney.getSeating().initalisedFloorGrid();	
				seatSelection(operatorAuckOne,newJourney);
				System.out.println("Your train operator is: "+operatorAuckOne.getOperatorName());
			}
			else if(tripNum==2)
			{
				newJourney.getSeating().initalisedFloorGrid();	
				seatSelection(operatorAuckTwo,newJourney);
				System.out.println("Your train operator is: "+operatorAuckTwo.getOperatorName());
			}
		}
		else if(newJourney.getSourceCity()=="Wellington")
		{
			tripNum=selectTrip(newJourney,journeysWel);
			//setting newJourney details
			newJourney.setDestCity(journeysWel[tripNum-1].getDestCity());
			newJourney.setDepartureTime(journeysWel[tripNum-1].getDepartureTime());
			newJourney.setJourneyNumber(journeysWel[tripNum-1].getJourneyNumber());
			newJourney.setDestCity(journeysWel[tripNum-1].getDestCity());
			newJourney.setSeating(journeysWel[tripNum-1].getSeating());
			if(tripNum==1)
			{
				newJourney.getSeating().initalisedFloorGrid();	
				seatSelection(operatorWelOne,newJourney);
				System.out.println("Your train operator is: "+operatorWelOne.getOperatorName());
			}
			else if(tripNum==2)
			{
				newJourney.getSeating().initalisedFloorGrid();	
				seatSelection(operatorWelTwo,newJourney);
				System.out.println("Your train operator is: "+operatorWelTwo.getOperatorName());
			}
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("Selected journey details:");
		System.out.println(newJourney.getSourceCity()+" to "+newJourney.getDestCity());
		System.out.println(newJourney.getDepartureTime());
		System.out.println("Journey Number: "+newJourney.getJourneyNumber());
		
		scan.close();
	}
	
	public static String selectCity()
	{
//		Scanner secScan=new Scanner(System.in);
		int num;
		String city ="\0";
		
		System.out.println("Please select your depature city");
		//code to select cities
		System.out.println("[1] Auckland ");
		System.out.println("[2] Wellington ");
		
		num=scan.nextInt();
		while(num>2||num<1)
		{
			System.out.println("Incorrect output please try again");
			num=scan.nextInt();
		}
		if(num==1)
		{
			city="Auckland";
		}
		else if(num==2) 
		{
			city="Wellington";
		}
		return city;
	}
	
	
	public static int selectTrip(TrainJourney newJourney, TrainJourney journeys[])
	{
		int keyboard=0;
	
		System.out.println("Trips available:");
			
		for(int x=0; x<2; x++) 
		{
			System.out.println("["+(x+1)+"] Destination: "+journeys[x].getDestCity());
			System.out.println("["+(x+1)+"] Depature Time: "+journeys[x].getDepartureTime());
			System.out.println();
		}
		System.out.println("Which journey number would you like to select?");
		keyboard =scan.nextInt();
		while(keyboard<1||keyboard>2)
		{
			System.out.println("Incorrect output please try again");
			keyboard=scan.nextInt();
		}
		return keyboard;
	}
	
	public static void seatSelection(TrainOperator operator, TrainJourney selected)
	{
		boolean seatBooked=false;
				while(!seatBooked)
				{
		System.out.println(selected.getSeating().toString());
		System.out.println("Please select which seat type you would like:");
		System.out.println("[1] Window");
		System.out.println("[2] Aisle");
		System.out.println("[3] Middle");
		int seatType=scan.nextInt();

		SeatType selectedType=null;
		if(seatType==1)
		{
			selectedType=SeatType.WINDOW;
		}
		else if(seatType==2)
		{
			selectedType=SeatType.AISLE;
		}
		else if(seatType==3)
		{
			selectedType=SeatType.MIDDLE;
		}
		System.out.println("------------------------------------------------");
		System.out.println("Please select seating class: ");
		System.out.println("[1] First class");
		System.out.println("[2] Economy");
		int input=scan.nextInt();
		while(input<1||input>2)
		{
			System.out.println("Incorrect output please try again");
			input=scan.nextInt();
		}
		Seat reservedSeat=new Seat();
		if(input==1)
		{
			System.out.println("Avalible First class seat: ");
			Seat seatQuery = new Seat();
			seatQuery=selected.getSeating().queryAvailableFirstClassSeat(selectedType);
			System.out.println(seatQuery.toDescription());
			System.out.println("Would you like to book this seat?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			int yesNoInput=scan.nextInt();
			while(yesNoInput<1||yesNoInput>2)
			{
				System.out.println("Incorrect output please try again");
				yesNoInput=scan.nextInt();
			}
			if(yesNoInput==1)
			{
				reservedSeat=operator.reserveFirstClass(selected, selectedType);
				seatBooked=true;
			}
			else if(yesNoInput==2)
			{
				System.out.print("Please select another seat");
			}
			
		}
		else if(input==2)
		{
			System.out.println("Available Economy class seat: ");
			reservedSeat=operator.reserveEconomy(selected, selectedType);
			Seat seatQuery = new Seat();
			seatQuery=selected.getSeating().queryAvailableEconomySeat(selectedType);
			System.out.println(seatQuery.toDescription());
			System.out.println("Would you like to book this seat?");
			System.out.println("[1] Yes");
			System.out.println("[2] No");
			int yesNoInput=scan.nextInt();
			while(yesNoInput<1||yesNoInput>2)
			{
				System.out.println("Incorrect output please try again");
				yesNoInput=scan.nextInt();
			}
			if(yesNoInput==1)
			{
				reservedSeat=operator.reserveFirstClass(selected, selectedType);
				seatBooked=true;
			}
			else if(yesNoInput==2)
			{
				System.out.print("Please select another seat");
			}
		}
		System.out.println(selected.getSeating().toString());
		System.out.println(reservedSeat.toDescription());
		
	}}
}
