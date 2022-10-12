package railway;

public class TicketBooker {

	static int upper =0, lower = 0, middle = 1, rAC = 1, waitingList = 1;
	static int index = 0;

	public void availableTicktes() {
		System.out.println("---------------" );
		System.out.println("Berth   - Seats" );
		System.out.println("---------------" );
		System.out.println("Upper   -  " + upper);
		System.out.println("Lower   -  " + lower);
		System.out.println("Middle  -  " + middle);
		System.out.println("RAC     -  " + rAC);
		System.out.println("Waiting -  " + waitingList);	
		System.out.println("---------------" );
		System.out.println("Total   -  " + (waitingList+upper+lower+middle+rAC));
		System.out.println("---------------" );
	}

	Passenger p = new Passenger();

	static int totalAvailable = upper+lower+middle+rAC+waitingList;

	public static void addPassenger(Passenger p, Passenger[] tickets, int num, int slNo) {

		p.pNR = num;
		p.slNo = slNo;

		if (p.age>=60 && lower>0 ) {
			p.berth = "Lower";
			lower--;
			p.berth ="LB";
			System.out.println("Lower Berth Alloted");
		}
		else if (p.age<=5) {
			p.berth = "CH";
		}
		else if (p.age>5) {
			if (p.berth.equals("Lower") && lower>0) {
				lower--;
				p.berth ="LB";
				System.out.println("Lower Berth Alloted");
			}
			else if (p.berth.equals("Lower") && lower==0 && middle>0) {
				middle--;
				p.berth = "MB";
				System.out.println("Middle Berth Alloted");
			}
			else if (p.berth.equals("Lower") && lower==0 && upper>0) {
				upper--;
				p.berth = "UB";	
				System.out.println("Upper Berth Alloted");
			}
			else if (p.berth.equals("Upper") && upper>0) {
				upper--;
				p.berth = "UB";	
				System.out.println("Upper Berth Alloted");
			}
			else if (p.berth.equals("Upper") && upper==0 && middle>0) {
				middle--;
				p.berth = "MB";
				System.out.println("Middle Berth Alloted");
			}
			else if (p.berth.equals("Middle") && middle==0 && lower>0) {
				lower--;
				p.berth ="LB";
				System.out.println("Lower Berth Alloted");
			}
			else if (p.berth.equals("Middle") && middle>0) {
				middle--;
				p.berth = "MB";
				System.out.println("Middle Berth Alloted");
			}
			else if (p.berth.equals("Middle") && middle==0 && lower>0) {
				lower--;
				p.berth ="LB";
				System.out.println("Lower Berth Alloted");
			}
			else if (p.berth.equals("Middle") && middle==0 && upper>0) {
				upper--;
				p.berth = "UB";				
				System.out.println("Upper Berth Alloted");
			}
			else if (rAC>0) {
				rAC--;
				p.berth = "RAC";				
				System.out.println("RAC Alloted");
			}
			else if (waitingList>0) {
				waitingList--;
				p.berth = "WL";				
				System.out.println("Waiting List Alloted");
			}
			else {
				System.out.println("No tickets Available");
			}
		}
		tickets[index++] = p;
	}

}
