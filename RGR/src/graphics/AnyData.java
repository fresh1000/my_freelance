package graphics;

import java.io.Serializable;

public abstract class AnyData implements Serializable {
	protected String name;

	abstract MainDialog showDialog(boolean b);
	
	abstract MainDialog showSonDialog();
	
	@Override
	public String toString() {
		return name;
	}
}
