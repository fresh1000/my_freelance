package AutoFactory;

import java.util.ArrayList;

abstract class Automobile {
	String mark;//mark auto
	String model;//model auto
	String price;//price auto
	ArrayList<String> luxuryBundle  = new ArrayList<>();//list luxury bundle
	ArrayList<String> performanceBundle = new ArrayList<>();//list performance bundle
	abstract void printMarkModel();//print information
}
