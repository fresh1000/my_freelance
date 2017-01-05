package src.lab4.store;

import java.util.Arrays;

import src.lab4.model.AbstractForm;
import src.lab4.model.Timber;
import src.lab4.model.IWeight;
import src.lab4.store.ProductStore;

public class ProductStore extends AbstractStore{
	
	public void add (IWeight newProduct){
		super.add(newProduct);
		
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("\n¬м≥ст сховища продукт≥в:\n");
		sb.append(super.toString());
		return sb.toString();
	}
}
