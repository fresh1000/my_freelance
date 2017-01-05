package src.lab5.store;

import java.util.Arrays;

import src.lab5.model.AbstractForm;
import src.lab5.model.IWeight;
import src.lab5.model.Timber;
import src.lab5.store.ProductStore;

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
