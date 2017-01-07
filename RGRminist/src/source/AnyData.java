package source;

import java.io.Serializable;

public abstract class AnyData implements Serializable {
	protected String name;

	public String toString() {
		return name;
	}
	
	public abstract Dlg showDialog(boolean b);
	public abstract Dlg showSonDialog();
}
