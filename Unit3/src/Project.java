import java.util.ArrayList;

public class Project {

	public static void main(String[] args) {
		
		String[][] salesRegions = {{"Noth"},{"West"},{"East"},{"South"}};
		System.out.println("unit3_task1");
		//print sales region
		for(int i = 0; i < salesRegions.length; i++){
			System.out.println(salesRegions[i][0]);
		}
		System.out.println();
		//new array sales regions with salesman
		String[][] salesRegions1 = {{"Noth","Bob","Will","Ed"},{"West","Rob","Earl", "Bill"},{"East","Mitch","Paul","Ralph"},{"South",
			"Eddy","Hank","Rudy"}};
		System.out.println("unit3_task2");
		//print all sales regions and salesman
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++) {
				if(j == 0) {
					System.out.println("SalesRegion: " + salesRegions1[i][j]);
				}else
					System.out.println("Salesman: " + salesRegions1[i][j]);
				
			}
		}
		System.out.println();
		//create array list
		ArrayList<String> salesTeam = new ArrayList<>();
		salesTeam.add("Bob");//add
		salesTeam.add("Will");//add
		salesTeam.add("Ed");//add
		System.out.println("unit3_task3");
		System.out.println("There are " + salesTeam.size() + " salesman.");//print size list
		
		salesTeam.add("Rob");
		salesTeam.add("Earl");
		salesTeam.add("Bill");
		System.out.println("There are " + salesTeam.size() + " salesman.");
		
		if(salesTeam.contains("Will")) {//contains "Will" in list
			System.out.println("Will is in the list.");
		}else {
			System.out.println("Will is not in the list.");
		}
		
		salesTeam.remove("Ed");//delete "Ed"
		salesTeam.remove("Earl");//delete "Earl"
		System.out.println("There are " + salesTeam.size() + " salesman.");
		//print all salesman in the list
		for (int i = 0; i < salesTeam.size(); i++) {
			if(i == salesTeam.size() - 1) {
				System.out.print(salesTeam.get(i));
			}else {
				System.out.print(salesTeam.get(i) + ",");
			}
		}
	}

}
