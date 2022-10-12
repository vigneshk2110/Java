package railwayTicket;

import java.util.Scanner;

public class Passenger {
	
	String name;
	int age;
	int berth;
	
	
	public Passenger(String name, int age, int berth) {
		this.name = name;
		this.age = age;
		this.berth = berth;
	}


	public Passenger(Passenger p) {
		this.name = p.name;
		this.age = p.age;
		this.berth = p.berth;
	}

	public Passenger() {
		// TODO Auto-generated constructor stub
	}


	public static void bookTickets() {
		
		TicketBooker tb = new TicketBooker();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the No of tickets to book");
		int noOfTickets = scan.nextInt();
		
		for (int i = 0; i < noOfTickets; i++) {
			scan.nextLine();
			System.out.println("Enter the Name");
			String name = scan.nextLine();
			
			
			System.out.println("Enter the age");
			int age = scan.nextInt();
			
			System.out.println("Enter the berthPreference \n1. Lower \n2. Upper \n3. Middle");
			int berth = scan.nextInt();
			Passenger p = new Passenger(name, age, berth);
			
			tb.addPassenger(p);
		}
		
	}
	

}
