import java.util.ArrayList;

public class MainSingle {

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

		Player player = new Player(0, "John");
		Terning tern = new Terning();
		System.out.println("Start game");
		boolean loop = true;

		while (loop) {
			int pos;
			int dice;
			tern.kast();
			dice = tern.getTall();
			System.out.println("Dice: " + dice);
			pos = player.getScore() + dice;
			player.setScore(pos);
			if (pos >= 20) {
				System.out.println("Player move to: " + player.getScore());
				System.out.println("Finish");
				loop = false;
			} else {
				route.get(pos).flyttHit(player);
			}

		}

	}

}
