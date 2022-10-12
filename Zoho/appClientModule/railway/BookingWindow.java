package railway;

import java.util.Scanner;

public class BookingWindow {

	public static void main(String[] args) {
		TicketBooker tb = new TicketBooker();
		Passenger [] tickets = new Passenger[20];
		Passenger p = new Passenger();

		int option = welcome();
	
		while (option<5 && option>0) {
		

			switch (option) {
			case 1:
				tb.availableTicktes();
				break;
			case 2:
				p.bookTickets(tickets);
				break;

			case 3:
				p.printBookedTicktes(tickets);
				break;

			case 4:
				p.cancelTickets(tickets);
				break;

			default:
				break;
			}
			
			option = welcome();
		}
	}

	public static int welcome() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select the desired option \n"
				+ "1. Check Availability \n"
				+ "2. Book Tickets \n"
				+ "3. Booked Tickets \n"
				+ "4. Cancel Ticket" );
		int	option = scan.nextInt();
		return option;

	}
}
