import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Test.run();

	}

	public static void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Cellars and Lizards!");
		printStats();
		System.out.println("Join our campaign!");
		System.out.print("Who is your cellar master? ");
		String manager = sc.nextLine();
		System.out.print("How many people in your party? ");
		int numPeople = sc.nextInt();
		CellarsAndLizards game = new CellarsAndLizards(manager, numPeople);
		System.out.println();
		System.out.println("Welcome to the campaign!");
		System.out.print("Your cellar master is ");
		System.out.println(game.getCellarMaster());
		System.out.print("Your party is " + game.getNumPlayers());
		System.out.println(" people strong");

		printStats();
	}

	public static void printStats() {
		System.out.println();
		System.out.println("Current Cellars and Lizards Stats");
		System.out.println("");
		System.out.print("Current Map: ");
		System.out.println(CellarsAndLizards.mapName);
		System.out.println("Number of parties in the campaign: ");
		System.out.println(CellarsAndLizards.getNumGames());
		System.out.println();
	}

}
