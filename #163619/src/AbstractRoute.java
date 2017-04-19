
public abstract class AbstractRoute implements InterfaceRoute {
	 static int routePos;

	public AbstractRoute(int routePos) {
		this.routePos = routePos;
	}

	public int getPosition() {
		return routePos;
	}

	public void setRoutePos(int routePos) {
		this.routePos = routePos;
	}
	
}
