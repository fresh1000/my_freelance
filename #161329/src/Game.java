import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private ArrayList<Player> players = new ArrayList<Player>();

	public Player startGame() {
		String nameUser;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name user:");
		nameUser = sc.nextLine();
		Player player = new Player(nameUser);
		Terning terning = new Terning();
		terning.kast();
		player.setScore(terning.getTall());
		terning.kast();
		player.setScore(terning.getTall() + player.getScore());
		terning.kast();
		player.setScore(terning.getTall() + player.getScore());
		System.out.println("Score: " + player.getScore());
		return player;
	}

	public void gameOnePlay(Player player) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Player: " + player.getName() + " ,Score: " + player.getScore());

		boolean loop = true;
		String choice = "y";

		do {
			if (choice.equals("n") || !choice.equalsIgnoreCase("y")) {
				loop = false;
			}

			System.out.println("Roll the dice again?(y/n)");
			choice = sc.next();

			if (choice.equals("y")) {
				Terning terning = new Terning();
				terning.kast();
				player.setScore(terning.getTall() + player.getScore());
				System.out.println("Score " + player.getName() + " now: " + player.getScore());
			}
			if (player.getScore() > 21) {
				System.out.println("Player " + player.getName() + " lose!" + "\n");
				player.setScore(0);
				loop = false;
			}
			if (choice.equals("n") || !choice.equalsIgnoreCase("y")) {
				loop = false;
			}
		} while (loop);
	}

	public void playersList() {
		Scanner sc = new Scanner(System.in);
		int numberPlayers;
		System.out.println("Enter number players:");
		numberPlayers = sc.nextInt();
		for (int i = 0; i < numberPlayers; i++) {
			System.out.println("Player " + (i + 1));
			Player player = startGame();
			players.add(player);
		}
		System.out.println();
	}

	public void gameAllPlayers() {
		Scanner sc = new Scanner(System.in);
		String endAgain;
		int round = 1;
		boolean endWhile = true;
		while (endWhile) {
			System.out.println("Start round " + round + "!");
			for (int i = 0; i < players.size(); i++) {
				gameOnePlay(players.get(i));
				if (players.get(i).getScore() == 0) {
					System.out.println("Player " + players.get(i).getName() + " removed!" + "\n");
					players.remove(i);
					System.out.println("Players in game: " + players.size() + "\n");
				}
			}
			System.out.println("Find winner with current scores?(y - find winner , n - again roll the dice)");
			endAgain = sc.next();
			if (endAgain.equals("y")) {
				endWhile = false;
			}
			round++;
		}
		checkWin();
	}

	public void checkWin() {
		Player playerWin = new Player("Win");
		int max = Integer.MIN_VALUE;
		if (players.size() == 1) {
			System.out.println("Player " + players.get(0).getName() + " win!" + "\n");
		} else {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getScore() > max) {
					max = players.get(i).getScore();
					playerWin = players.get(i);
				}
			}
			System.out.println("Player " + playerWin.getName() + " win!" + "\n");
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.playersList();
		game.gameAllPlayers();
	}

}
