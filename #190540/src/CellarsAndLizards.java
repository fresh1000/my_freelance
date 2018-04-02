public class CellarsAndLizards {
	private static int numGames = 0;
	public static String mapName = "KingsCastle";
	private String cellarMaster;
	private int numPlayers;

	public CellarsAndLizards(String mainMaster, int numPlayers){
		CellarsAndLizards.numGames += 1;
		this.cellarMaster = mainMaster;
		this.numPlayers = numPlayers;
	}

		// Getters and Setters
	public static int getNumGames(){
		return CellarsAndLizards.numGames;
	}
	
	public String getCellarMaster(){
		return this.cellarMaster;
	}
	
	public int getNumPlayers(){
		return this.numPlayers;
	}
	
	public void setNumPlayers(int numPlayers){
		if(numPlayers > 0){
			this.numPlayers = numPlayers;
		}
	}
}