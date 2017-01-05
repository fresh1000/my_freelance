package src.lab4.model;

public abstract class AbstractForm implements IWeight {

	protected Wood wood;
	
	public AbstractForm() {
		super();
	}

	public Wood getWood() {
		return wood;
	}

	/* (non-Javadoc)
	 * @see lab3.model.IWeight#weight()
	 */
	@Override
	public float weight() {
		return wood.getDensity()*volume();
	}

	public abstract float volume();

}