package source;

public abstract class AnyData {
	protected String name;

	public String toString() {
		return name;
	}
	
	public abstract Dlg showDialog(boolean b);
	public abstract Dlg showSonDialog();
}
