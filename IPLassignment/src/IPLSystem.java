import java.util.List;
import java.util.Scanner;

import pojo.Player;
import pojo.Team;
import service.IPLService;
import service.IPLServiceImpl;

public class IPLSystem {

	public static void main(String[] args) {

		IPLService service = new IPLServiceImpl();
		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("1. Add Team");
			System.out.println("2. Add Player");
			System.out.println("3. Search Team by ID");
			System.out.println("4. Search Team by Name");
			System.out.println("5. Display Players By Team");
			System.out.println("6. Remove Team");
			System.out.println("7. Remove Player");
			System.out.println("9. Exit");

			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				sc.nextLine();

				System.out.print("Enter Team Name : ");
				String teamName = sc.nextLine();

				if (service.addTeam(new Team(teamName)))
					System.out.println("Team Added Successfully");
				else
					System.out.println("UNABLE TO ADD TEAM");

				break;

			case 2:

				System.out.print("Enter Team ID : ");
				int teamId = sc.nextInt();

				sc.nextLine();

				System.out.print("Enter Player Name : ");
				String name = sc.nextLine();

				System.out.print("Enter Jersey Number : ");
				int number = sc.nextInt();

				sc.nextLine();

				System.out.print("Enter Bid : ");
				String bid = sc.nextLine();

				Player player = new Player(name, number, bid);

				if (service.addPlayer(player, teamId))
					System.out.println("Player Added Successfully");
				else
					System.out.println("UNABLE TO ADD PLAYER");

				break;

			case 3:

				System.out.print("Enter Team ID : ");
				teamId = sc.nextInt();

				Team team = service.searchTeam(teamId);

				if (team != null)
					System.out.println(team);
				else
					System.out.println("TEAM NOT FOUND!");

				break;

			case 4:

				sc.nextLine();

				System.out.print("Enter Team Name : ");
				teamName = sc.nextLine();

				team = service.searchTeam(teamName);

				if (team != null)
					System.out.println(team);
				else
					System.out.println("TEAM NOT FOUND!");
				break;

			case 5:
				List<Player> players = service.displayPlayers();
				System.out.print("Enter Team ID : ");
				teamId = sc.nextInt();

				players = service.displayPlayersByTeam(teamId);

				System.out.println("\nPlayer Name\t\tJersey\tBid");

				for (Player p : players)
					System.out.println(p);

				break;

			case 6:

				System.out.print("Enter Team ID : ");
				teamId = sc.nextInt();

				if (service.removeTeam(teamId))
					System.out.println("Team Removed Successfully");
				else
					System.out.println("UNABLE TO REMOVE TEAM");
				break;

			case 7:

				System.out.print("Enter Jersey Number : ");
				number = sc.nextInt();

				if (service.removePlayer(number))
					System.out.println("Player Removed Successfully");
				else
					System.out.println("UNABLE TO REMOVE PLAYER");

				break;

			case 9:

				System.out.println("BYE");
				break;
			default:
				System.out.println("INVALID CHOICE");
			}

		} while (choice != 9);

		sc.close();
	}

}