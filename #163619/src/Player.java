
import java.util.Scanner;

public class Player {
	private int id;
	private String name;
	private int score;

	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		score = 0;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void printPlayer() {
		System.out.println("Player ID: " + id + "\nPlayer name: " + name + "\nPlayer score: " + score);
	}

	public static Player highest(Player player1, Player player2) {
		if (player1.getScore() > player2.getScore()) {
			return player1;
		} else
			return player2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id1, id2;
		String name1, name2;
		
		System.out.print("Enter first player ID(integer): ");
		id1 = sc.nextInt();
		System.out.print("Enter first player name: ");
		name1 = sc.next();
		
		System.out.print("Enter second player ID(integer): ");
		id2 = sc.nextInt();
		System.out.print("Enter second player name: ");
		name2 = sc.next();
		
		Player player1 = new Player(id1, name1);
		Player player2 = new Player(id2, name2);
		Player highest;
		
		player1.setScore(100);
		player2.setScore(200);
		
		player1.printPlayer();
		System.out.println();
		
		player2.printPlayer();
		System.out.println();
		
		highest = highest(player1, player2);
		System.out.println("Player " + highest.getName() + " win!");
	}

}
