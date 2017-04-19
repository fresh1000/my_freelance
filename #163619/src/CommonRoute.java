
public class CommonRoute extends AbstractRoute implements InterfaceRoute {

	public CommonRoute(int routePos) {
		super(routePos);
	}

	public void flyttHit(Player player) {
		//System.out.println("Player moved from: " + player.getScore());
		//Terning tern = new Terning();
		//System.out.println("Dice: " + tern.getTall());
		routePos = player.getScore();
		player.setScore(routePos);
		System.out.println("Player moved to: " + player.getScore() + "\n");
	}

}
