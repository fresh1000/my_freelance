package src.lab4.store;


import java.util.Arrays;

import src.lab4.model.Wood;
import src.lab4.store.WoodDirectory;


public class WoodDirectory extends AbstractStore{

	
	{
		arr[0] = new Wood(1, "Модрина", 1.1f);
		arr[1] = new Wood(2, "Ялина", 0.9f);
		arr[2] = new Wood(3, "Сосна", 0.7f);
		count=3;
	}
	
	public Wood get(int id){
		for (int i = 0; i < count; i++){
			Wood wood = (Wood) arr[i];
			if(wood.getId() == id)
			return wood;	
		}
		return null;
	}
	
	public boolean add (Wood newWood){
		//перевірка на унікальність id
		if(get(newWood.getId())!= null){
			System.out.println("\nДеревина з таким id вже є!");
			return false;}
		//запобігаємо переповненню масиву
		super.add(newWood);
		return true;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("\nКаталог деревини:\n");
		sb.append(super.toString());
		return sb.toString();
	}
}
