//package trainSeatBookingApplication;
//import java.util.Scanner;
//
//public class TrainSeatBookingApplication {
//
//	private static final Scanner scan = null;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//set journeys AUCKLAND
////				final TrainJourney journeysAuk[]=new TrainJourney[3];
////				journeysAuk[0].sourceCity="Auckland";
////				journeysAuk[0].destCity="Wellington";
////				journeysAuk[0].departureTime="07:10";
////				journeysAuk[0].journeyNumber="003";
////				
////				journeysAuk[1].sourceCity="Auckland";
////				journeysAuk[1].destCity="Wellington";
////				journeysAuk[1].departureTime="16:00";
////				journeysAuk[1].journeyNumber="004";
////				
////				journeysAuk[2].sourceCity="Auckland";
////				journeysAuk[2].destCity="Hamilton";
////				journeysAuk[2].departureTime="13:30";
////				journeysAuk[2].journeyNumber="102";
////		
////				//set journeys WELLINGTON
////				final TrainJourney journeysWel[]=new TrainJourney[2];
////				journeysWel[0].sourceCity="Wellington";
////				journeysWel[0].destCity="Auckland";
////				journeysWel[0].departureTime="12:00";
////				journeysWel[0].journeyNumber="005";
////				
////				journeysWel[1].sourceCity="Wellington";
////				journeysWel[1].destCity="Auckland";
////				journeysWel[1].departureTime="14:30";
////				journeysWel[1].journeyNumber="002";
////				
////				journeysWel[2].sourceCity="Wellington";
////				journeysWel[2].destCity="Hamilton";
////				journeysWel[2].departureTime="09:00";
////				journeysWel[2].journeyNumber="105";
////				
////				//set journeys HAMILTON
////				final TrainJourney journeysHam[]=new TrainJourney[2];
////				journeysHam[0].sourceCity="Hamilton";
////				journeysHam[0].destCity="Wellington";
////				journeysHam[0].departureTime="08:30";
////				journeysHam[0].journeyNumber="013";
//////				journeysHam[0].seating= PetiteFloorGrid;
////				
////				journeysHam[1].sourceCity="Hamilton";
////				journeysHam[1].destCity="Auckland";
////				journeysHam[1].departureTime="07:00";
////				journeysHam[1].journeyNumber="016";
//				
//		System.out.println("------------------");
//		
//		Scanner scan=new Scanner(System.in);
//		TrainJourney newJourney=new TrainJourney();
//		
//		newJourney.setSourceCity(selectCity());
//		newJourney.setDestCity(selectDestCity(newJourney.sourceCity));
//		newJourney.setDepartureTime(selectDepatureTime(newJourney,journeysAuk,journeysWel,journeysHam));
//		
//	//UP TO HERE 
//		System.out.println("Which seat type would you like to book?");
//		//user types in seat type
//		
//		scan.close();
//	}
//	
//	//select source city
//	private static String selectCity()
//	{
//		int num;
//		String city ="\0";
//		System.out.println("Please select which your depature city");
//		//code to select cities
//		System.out.println("[1] Auckland ");
//		System.out.println("[2] Wellington ");
//		System.out.println("[3] Hamilton");
//		num=scan.nextInt();
//		if(num==1)
//		{
//			city="Auckland";
//		}
//		else if(num==2) 
//		{
//			city="Wellington";
//		}
//		else if(num==3)
//		{
//			city="Hamilton";
//		}
//		
//		return city;
//		
//	}
//	
//	//selecting destination city
//	private static String selectDestCity(String sourceCity)
//	{
//		int num=0;
//		String destCity="\0";
//		System.out.println("Please select your destination city ");
//		//code to select cities
//		if(sourceCity=="Auckland")
//		{
//			System.out.println("[1] Wellington ");
//			System.out.println("[2] Hamilton");
//			num=scan.nextInt();
//			if(num==1)
//			{
//				destCity="Wellington";
//			}
//			else if(num==2)
//			{
//				destCity="Hamilton";
//			}
//		}
//		else if(sourceCity=="Wellington") 
//		{
//			System.out.println("[1] Auckland ");
//			System.out.println("[2] Hamilton");
//			num=scan.nextInt();
//			if(num==1)
//			{
//				destCity="Auckland";
//			}
//			else if(num==2)
//			{
//				destCity="Hamilton";
//			}
//
//		}
//		else if(sourceCity=="Hamilton")
//		{
//			System.out.println("[1] Auckland ");
//			System.out.println("[2] Wellington ");
//			num=scan.nextInt();
//			if(num==1)
//			{
//				destCity="Auckland";
//			}
//			else if(num==2)
//			{
//				destCity="Wellington";
//			}
//		}
//		
//		
//		return destCity;
//	}
//	
//	private static String selectDepatureTime(TrainJourney journey, TrainJourney[] Auckland,
//			TrainJourney[] Wellington,TrainJourney[] Hamilton)
//	{
//		int num;
//		String time="\0";
//		System.out.println("Printed below are the available depaure times from "+journey.sourceCity+" to "+journey.destCity);
//		//search for matching cities
//		if(journey.sourceCity=="Auckland")
//		{
//			for(int x=0; x<3;x++)
//			{
//				if(Auckland[x].destCity==journey.destCity)
//					{
//						System.out.println("Avalible depature times: ");
//						System.out.println("[x+1]"+Auckland[x].departureTime);
//					}
//			}
//			System.out.println("Please select a time: ");
//			num=scan.nextInt();
//			time=Auckland[num-1].departureTime;	
//			journey.journeyNumber=Auckland[num-1].journeyNumber;
//		}
//		
//		else if(journey.sourceCity=="Wellington")
//		{
//			for(int x=0; x<3;x++)
//			{
//				if(Wellington[x].destCity==journey.destCity)
//					{
//						System.out.println("Avalible depature times: ");
//						System.out.println(Wellington[x].departureTime);
//					}
//			}
//			System.out.println("Please select a time: ");
//			num=scan.nextInt();
//			time=Wellington[num-1].departureTime;
//			journey.journeyNumber=Wellington[num-1].journeyNumber;
//
//		}
//		else if(journey.sourceCity=="Hamilton")
//		{
//			for(int x=0; x<2;x++)
//			{
//				if(Hamilton[x].destCity==journey.destCity)
//					{
//						System.out.println("Avalible depature times: ");
//						System.out.println(Hamilton[x].departureTime);
//					}
//			}
//			System.out.println("Please select a time: ");
//			num=scan.nextInt();
//			time=Hamilton[num-1].departureTime;
//			journey.journeyNumber=Hamilton[num-1].journeyNumber;
//
//		}
//		return time;
//	}
//
//}
//
