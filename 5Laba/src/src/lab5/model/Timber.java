package src.lab5.model;
import src.lab5.model.Timber;
import src.lab5.model.Wood;


public class Timber extends AbstractForm {
	
	private float length;
	private float height;
	private float width;
	
	public Timber(Wood wood, float length, float height, float width) throws Exception {
		if ((length <1 || length>10) || (height<1 || height>10 || width<1 || width>10))
			throw new Exception("is not corect.\n Must be from 1 to 10\n");

		this.wood = wood;
		this.length = length;
		this.height = height;
		this.width = width;
	}

	public void setWood(Wood wood) {
		this.wood = wood;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public  float volume(){
		return length*height*width;
	}
	public String toString(){
		return "Timber [wood = " + wood.getName() + ", weight = " + weight() + "]";
	}
}
