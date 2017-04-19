
public class StartRoute extends AbstractRoute implements InterfaceRoute {

	public StartRoute(int routePos) {
		super(routePos);
	}

	
	public void flyttHit(Player player) {
		System.out.println("Player move to:" + player.getScore());
		System.out.println("Position sets to 0\n");	
		routePos = 0;
		player.setScore(0);
	}

}
