import java.util.ArrayList;

public class MainMult {

	public static void main(String[] args) {
		ArrayList<AbstractRoute> route = new ArrayList<>();

		CommonRoute commonRoute = new CommonRoute(0);
		StartRoute startR = new StartRoute(0);

		for (int i = 0; i < 20; i++) {
			if (i == 6 || i == 9 || i == 13 || i == 18) {
				route.add(startR);
			} else
				route.add(commonRoute);
		}

		Player player1 = new Player(0, "John");
		Player player2 = new Player(1, "Sam");
		Terning tern = new Terning();
		System.out.println("Player 1: " + player1.getName());
		System.out.println("Player 2: " + player2.getName());
		System.out.println("Start game");
		boolean loop = true;
		while (loop) {
			int pos1;
			int dice1;
			int pos2;
			int dice2;
			tern.kast();
			dice1 = tern.getTall();
			System.out.println("Dice player 1: " + dice1);
			pos1 = player1.getScore() + dice1;
			player1.setScore(pos1);
			if (pos1 >= 20) {
				System.out.println("Player 1 move to: " + player1.getScore());
				System.out.println("Finish");
				loop = false;
			} else {
				route.get(pos1).flyttHit(player1);
			}

			tern.kast();
			dice2 = tern.getTall();

			System.out.println("Dice player 2: " + dice2);
			pos2 = player2.getScore() + dice2;
			player2.setScore(pos2);
			if (pos2 >= 20) {
				System.out.println("Player 2 move to: " + player2.getScore());
				//System.out.println("Player 2 win.");
				System.out.println("Finish");
				loop = false;
			} else {
				route.get(pos2).flyttHit(player2);
			}

		}
		if(player1.getScore() > player2.getScore()) {
			System.out.println("Player 1 win.");
		}else
			System.out.println("Player 2 win.");
	}

}
