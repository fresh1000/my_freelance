import java.awt.Color;

public class Snowman {
	
	private Circle bottom;
	private Circle middle;
	private Circle head;
	private Rectangle hat;
	private Circle leftEye;
	private Circle rightEye;
	private Rectangle mouth;
	
	
	public Snowman() {
		
	}
	
	public Snowman(Circle bottom, Circle middle, Circle head, Rectangle hat, Circle leftEye, Circle rightEye, Rectangle mouth) {
		this.bottom = bottom;
		this.middle = middle;
		this.head = head;
		this.hat = hat;
		this.leftEye = leftEye;
		this.rightEye = rightEye;
		this.mouth = mouth;
	}
	
	public void draw() {
		bottom.draw();
		middle.draw();
		head.draw();
		hat.draw();
		leftEye.draw();
		rightEye.draw();
		mouth.draw();
	}
	
	
	public void setBottom( Circle newBottom) {
		this.bottom = newBottom;
	}
	
	public void setMiddle(Circle newMiddle) {
		this.middle = newMiddle;
	}
	
	public void setHead (Circle newHead) {
		this.head = newHead;
	}
	
	public void setLeftEye(Circle left) {
		this.leftEye = left;
	}
	
	public void setRightEye(Circle right) {
		this.rightEye = right;
	}
	
	public void setMouth( Rectangle newMouth) {
		this.mouth = newMouth;
	}
	
	public void setHat(Rectangle newHat) {
		this.hat = newHat;
	}

}
