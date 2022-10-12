package railwayTicket;

public class TicketBooker {

	Passenger [] totalTickets = new Passenger[15];
	int num = 0;
	Passenger [] upperBerth = new Passenger[2];
	Passenger [] lowerBerth = new Passenger[2];
	Passenger [] middleBerth = new Passenger[2];
	Passenger [] rAC = new Passenger[2];
	Passenger [] waitingList = new Passenger[2];
	Passenger [] below5 = new Passenger[5];

	public void availableTickets() {

		System.out.println("Berth   - Availabile");
		int count = 0;
		for (Passenger passenger : upperBerth) {
			if (passenger == null) {
				count++;
			}
		}
		System.out.println("Upper   - " + count);

		count = 0;
		for (Passenger passenger : lowerBerth) {
			if (passenger == null) {
				count++;
			}
		}
		System.out.println("Lower   - " + count);

		count = 0;
		for (Passenger passenger : middleBerth) {
			if (passenger == null) {
				count++;
			}
		}
		System.out.println("Middle  - " + count);

		count = 0;
		for (Passenger passenger : rAC) {
			if (passenger == null) {
				count++;
			}
		}
		System.out.println("RAC     - " + count);

		count = 0;
		for (Passenger passenger : waitingList) {
			if (passenger == null) {
				count++;
			}
		}
		System.out.println("Waiting - " + count);

	}

	public void addPassenger(Passenger p) {
		
		if (p.age<=5) {
			addToBelow5(p);
			return;
		}
		if (p.age >= 60) {
			addToLowerBerth(p);
			return;
		}
		if (p.age < 60 && p.berth == 1) {
			addToLowerBerth(p);
			return;
		}
		else if (p.age < 60 && p.berth == 2) {
			addToMiddleBerth(p);
			return;
		}
		else if (p.age < 60 && p.berth == 3) {
			addToUpperBerth(p);
			return;
		}

	}

	private void addToBelow5(Passenger p) {
		for (int i = 0; i < below5.length; i++) {
			if (below5[i] == null) {
				p.berth = 0;
				below5[i] = new Passenger(p);
				totalTickets[num++] = new Passenger(p);
				System.out.println("Your Berth Alloted to child as well");
				return;
			}
		}

	}

	private void addToLowerBerth(Passenger p) {
		for (int i = 0; i < lowerBerth.length; i++) {
			if (lowerBerth[i] == null) {
				p.berth = 1;
				lowerBerth[i] = new Passenger(p);
				totalTickets[num++] = new Passenger(p);
				System.out.println("Lower Berth Alloted");
				return;
			}
		}
		addToMiddleBerth(p);
		return;

	}

	private void addToMiddleBerth(Passenger p) {
		for (int i = 0; i < middleBerth.length; i++) {
			if (middleBerth[i] == null) {
				p.berth = 2;
				middleBerth[i] = new Passenger(p);
				totalTickets[num++] = new Passenger(p);
				System.out.println("Middle Berth Alloted");
				return;
			}
		}
		addToUpperBerth(p);
		return;
	}

	private void addToUpperBerth(Passenger p) {
		for (int i = 0; i < upperBerth.length; i++) {
			if (upperBerth[i] == null) {
				p.berth = 3;
				upperBerth[i] = new Passenger(p);
				totalTickets[num++] = new Passenger(p);
				System.out.println("Upper Berth Alloted");
				return;
			}
		}
		addTorAC(p);
		return;
	}

	private void addTorAC(Passenger p) {
		for (int i = 0; i < rAC.length; i++) {
			if (rAC[i] == null) {
				p.berth = 4;
				rAC[i] = new Passenger(p);
				totalTickets[num++] = new Passenger(p);
				System.out.println("Added to RAC");
				return;
			}
		}
		addToWaitingList(p);
		return;
	}

	private void addToWaitingList(Passenger p) {
		for (int i = 0; i < waitingList.length; i++) {
			if (waitingList[i] == null) {
				p.berth = 5;
				waitingList[i] = new Passenger(p);
				totalTickets[num++] = new Passenger(p);
				System.out.println("Added to Waiting list");
				return;
			}
		}
		System.out.println("No Tickets Available");
		return;
	}

	public  void bookedTickets() {
		int i = 1;
		System.out.println("No. Name    Age   Berth");
		
		for (int j = 0; j < num; j++) {
			System.out.print((i++) + " ");

			System.out.print(totalTickets[j].name + " ");
			System.out.print(totalTickets[j].age + " ");


			if (totalTickets[j].berth == 0) {
				System.out.print(" " );
			}
			else if (totalTickets[j].berth == 1) {
				System.out.print("Lower");
			}
			else if (totalTickets[j].berth == 2) {
				System.out.print("Middle");
			}
			else if (totalTickets[j].berth == 3) {
				System.out.print("Upper");
			}
			else if (totalTickets[j].berth == 4) {
				System.out.print("RAC");
			}
			else {
				System.out.print("Waiting List");
			}

			System.out.println();
		}

	}


}
