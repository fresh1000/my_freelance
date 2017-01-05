package src.lab4.store;

import java.util.Arrays;

import src.lab4.store.AbstractStore;
import src.lab5.model.AbstractForm;
import src.lab5.model.IWeight;
import src.lab5.model.Timber;

public class AbstractStore {
	protected Object[] arr = new Object[3];
	protected int count = 0;
	
	public Object[] getArr(){
		return Arrays.copyOf(arr, count);
	}
	public int getCount(){
		return count;
	}
	
	public void add (Object newObject){
		//запобігаємо переповненню масиву
		if(arr.length == count)
			arr = Arrays.copyOf(arr, count + count/2);
		//додаємо новий елемент
		arr[count++] = newObject;
		
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++){
			sb.append(arr[i]).append("\n");
		}
		return sb.toString();
	}
}
