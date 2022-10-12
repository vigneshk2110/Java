package railway;

import java.util.Scanner;

public class Passenger {

	int pNR = 0;
	String name;
	int age;
	String berth;
	int slNo = 0;

	//	Primary Constructor
	public Passenger(String name, int age, String berth) {
		this.name = name;
		this.age = age;
		this.berth = berth;
	}

	//	Copy Constructor
	public Passenger(Passenger p) {
		this.name = p.name;
		this.age = p.age;
		this.berth = p.berth;
	}

	//	Default Constructor
	public Passenger() {
	}

	public void bookTickets(Passenger[] tickets) {
		int ticketsAvailble = TicketBooker.totalAvailable;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the No of tickets to book");
		int noOfTickets = scan.nextInt();
		if (ticketsAvailble < noOfTickets) {
			System.out.println(ticketsAvailble + " Seats only availble - Sorry for Inconvience");
			BookingWindow.welcome();
		}
		
		else {

			pNR++;

			for (int i = 0; i < noOfTickets; i++) {
				scan.nextLine();
				System.out.println("Enter the Name");
				String name = scan.nextLine();


				System.out.println("Enter the age");
				int age = scan.nextInt();
				if (age <= 5 && i==0) {
					System.out.println("Please enter the details of an adult, then book for child");
					i--;
				}

				scan.nextLine();
				System.out.println("Enter the berthPreference \n1. Lower \n2. Upper \n3. Middle");
				int option = scan.nextInt();
				String berth = "";
				if (option == 1) {
					berth = "Lower";
				}
				else if (option == 2) {
					berth = "Upper";
				}
				else {
					berth = "Middle";
				}

				Passenger p = new Passenger(name, age, berth);

				TicketBooker.addPassenger(p, tickets, pNR, ++slNo);
			}
		}
	}

	public void printBookedTicktes(Passenger[] tickets) {
		System.out.println("---------------------");
		System.out.println("PNR  slNo age  Berth Name");
		for (Passenger passenger : tickets) {

			if (passenger == null) {
				continue;
			}

			System.out.print(passenger.pNR + "     ");
			System.out.print(passenger.slNo + "   ");
			System.out.print(passenger.age + "    ");
			System.out.print(passenger.berth + "   ");
			System.out.println(passenger.name);

		}
		System.out.println("---------------------");
	}

	public void cancelTickets(Passenger[] tickets) {
		int count = 0, index = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the PNR to Cancel the ticket");
		int pnr = scan.nextInt();


		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i] == null) {
				continue;
			}
			if (tickets[i].pNR == pnr ) {
				index = i;
				count++;
			}
		}
		int startIndex = (index+1)-count;
		System.out.println("---------------------");
		System.out.println("PNR  slNo age  Berth Name");
		
		for (int i = startIndex; i < startIndex+count; i++) {
			System.out.print(tickets[i].pNR + "     ");
			System.out.print(tickets[i].slNo + "   ");
			System.out.print(tickets[i].age + "    ");
			System.out.print(tickets[i].berth + "   ");
			System.out.println(tickets[i].name);
		}

		System.out.println("---------------------");
		System.out.println("Enter the Sl.No of tickets to Cancel");
		int serialNo = scan.nextInt();
		
		int cancelIndex = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i] == null) {
				continue;
			}
			if (tickets[i].slNo == serialNo) {
				cancelIndex = i;
				break;
			}
		}
		String b = new String(tickets[cancelIndex].berth);
		int sNo = new Integer(tickets[cancelIndex].slNo);
		Passenger toCancel = new Passenger(tickets[cancelIndex]);
		toCancel.berth = b;
		toCancel.slNo = sNo;
		
		int rACIndex = 0;
		for (int i = 0; i < tickets.length; i++) {

			if (tickets[i] == null) {
				continue;
			}
			if (tickets[i].berth.equals("RAC")) {
				rACIndex = i;
				break;
			}
		}
		
		String b1 = new String(tickets[rACIndex].berth);
		int sNo1 = new Integer(tickets[rACIndex].slNo);
		tickets[cancelIndex] = tickets[rACIndex];
		tickets[cancelIndex].berth = b1;
		tickets[cancelIndex].slNo = sNo1;

		if (count == 2 && tickets[cancelIndex +1 ]  != null && tickets[cancelIndex+1].berth.equals("CH")) {
			tickets[cancelIndex+1] = null;
		}
		
		for (int i = rACIndex; i < tickets.length-1; i++) {

			if (tickets[i+1] == null) {
				continue;
			}	
			
			String b2 = new String(tickets[i].berth);
			int sNo2 =new Integer(tickets[i].slNo);
			
			tickets[i]= tickets[i+1];
			tickets[i].berth = b2;
			tickets[i].slNo = sNo2;
		}
		for (int i = tickets.length-1; i >= 0; i--) {
			if (tickets[i] == null) {
				continue;
			}
			else if (tickets[i].berth.equals("WL")) {
				tickets[i] = null;
				break;
			}
		}
		TicketBooker.waitingList++; 
		TicketBooker.index--; 
		pNR--;
	}
}
