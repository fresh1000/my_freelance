package src.lab5.model;

public class Waste implements IWeight {

	@Override
	public float weight() {
		// TODO Auto-generated method stub
		return weight;
	}
	private float weight;
	public Waste(float weight) throws Exception {
		super();
		if (weight <0.020 || weight>20)
			throw new Exception(weight + "is not corect.\n Must be from 0.020 to 0.100");
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Waste [weight()=" + weight() + "]";
	}


}
