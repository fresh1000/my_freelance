package Exercise1;

public class RoomCarpet {
	private RoomDimension room;
	private double carpetCost;
	private double totalCost;
	
	public RoomCarpet(RoomDimension r, double cost) {
		this.room = r;
		this.carpetCost = cost;
		totalCost = room.getLength() * room.getWidth() * carpetCost;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public String toString() {
		return room.toString() + " Carpet Cost ($per sq.ft):" + carpetCost +
				" Total cost ($): " + getTotalCost();
	}
	
	public boolean costsMore(RoomCarpet other) {
		if(this.getTotalCost() > other.getTotalCost()) {
			return true;
		}else
			return false;
	}
}
