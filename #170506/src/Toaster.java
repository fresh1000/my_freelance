
public class Toaster {
	private boolean isOn;
	
	public Toaster() {
		isOn = false;
	}
	
	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean on) {
		isOn = on;
		if(on) {
			System.out.println("Toaster on.");
		}else
			System.out.println("Toaster off.");
	}
	
}
