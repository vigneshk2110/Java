package railwayTicket;

import java.util.Scanner;

public class BookingWindow {

	public static void main(String[] args) {

		TicketBooker tb = new TicketBooker();
		Passenger p = new Passenger();
		System.out.println(" 	!!!Welcome!!! " );
		int option;
		do
		{

			option = welcomeMenu();

			switch (option) {
			case 1:{
				tb.availableTickets();
				//welcomeMenu();
			}break;
			case 2:{
				Passenger.bookTickets();
//				welcomeMenu();
			}break;
			case 3:{
				tb.bookedTickets();
//				welcomeMenu();
			}break;
			case 5:
				System.out.println("thank you....");
				break;
			default:
				System.out.println("Enter the valid option");
			}

		}while(option!=5);
	}

	public static int welcomeMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please select the desired option \n"
				+ "1. Check Availability \n"
				+ "2. Book Tickets \n"
				+ "3. Booked Tickets \n"
				+ "4. Cancel Ticket" );
		int option = scan.nextInt();
		return option;
	}


}
