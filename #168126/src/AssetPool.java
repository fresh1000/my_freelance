
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class AssetPool maintains the list of all laptops
 * 
 * Responsible for adding laptops to the list, delete a laptop from the list
 * Can provide the list of available laptops and list of assigned laptops
 *
 * @author (Harini Ramadas - 100653718)
 * @version (22nd March 17)
 * @param <T>
 */


public class AssetPool {
	//defining the arraylist "laptops"
	private List<Asset> laptops;
	
	public AssetPool() {
	    /* initializing the array list*/
		laptops = new ArrayList<>();
	}
	/*
	 * Method add to add a laptop to the list
	 * @return : boolean value=true/false
	 */
	public boolean add(Asset laptop){
		return laptops.add(laptop);
	}
	/*
	 * Method add to delete an unassigned laptop from the list
	 * @return : boolean value=true/false
	 */
	public boolean delete(Asset laptop){
		boolean isNotassigned = !laptop.isAssigned();
		if(isNotassigned){
			return laptops.remove(laptop);
		}
		return false;
	}
	/**
	 * Method getLaptop returns the laptop with the unique serial number
	 */
	public Asset getLaptop(String laptopSerialNumber){
		sortAssets();
		Asset searchedOne = null;
		for (Asset laptop : laptops) {
			if(laptop.getSerialNumber().equals(laptopSerialNumber)){
				searchedOne = laptop;
				break;
			}
		}
		return searchedOne;
	}
	/**
	 * Method availableLaptops returns the list of available laptops from the
	 * laptops arraylist
	 */
	public List<Asset> availableLaptops(){
        sortAssets();
		List<Asset> availableLaptops = new ArrayList<>();
		for (Asset laptop : laptops) {
			if(laptop.isAvailable())
				availableLaptops.add(laptop);
		}
		return availableLaptops;
	}
	/**
	 * Method assignedLaptops returns the list of assigned laptops from the
	 * laptops arraylist
	 */
	public List<Asset> assignedLaptops(){
		sortAssets();
		List<Asset> assignedLaptops = new ArrayList<>();
		for (Asset laptop : laptops) {
			if(laptop.isAssigned())
				assignedLaptops.add(laptop);
		}
		return assignedLaptops;
	}
	/*
	 * Sort assets.
	 */
	public void sortAssets() {
		Collections.sort(laptops);
	}
}
