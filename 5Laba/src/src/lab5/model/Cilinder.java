package src.lab5.model;

public class Cilinder extends AbstractForm {
	
	

	private float length;
	private float diameter;
	
	
	public Cilinder(Wood wood, float lenght, float diametr) throws Exception {
		super();
		if ((lenght <1 || lenght>10) || (diametr<1 || diametr>10))
			throw new Exception("is not corect.\n Must be from 1 to 10\n");
		this.wood=wood;
		this.length = length;
		this.diameter = diameter;
	}
	
	public float volume(){
		return (float) (length*diameter*Math.PI);
	}

	public float getLength() {
		return length;
	}

	public float getDiameter() {
		return diameter;
	}


	@Override
	public String toString() {
		return "Cilinder [wood=" + wood + "length=" + length + ", diameter=" + diameter + ", volume()=" + volume()+ ",weight()=" +weight() + "]";
	}



	
	
	
	
}
