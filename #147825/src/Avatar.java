import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Avatar extends GeneralFish {

	public Avatar(int x, int y, int radius, int moveAngle, int speed, int id) {
		super(x, y, radius, moveAngle, speed, id);
	}
	
	public boolean canEat(GeneralFish fish) {
        float res = this.getY() - fish.getY();
        float res2 = this.getX() - fish.getX();
        if (res < 5) {
        	if (res2<5){
       		float ang = ((this.getMoveAngle() + fish.getMoveAngle()) + 180) / 180;
            if ((ang) < 120) {
                return true;
            }
          }
        }
        return false;
    }
	
	public void drawFish(Graphics2D g2) {
		g2.translate(x - 10, y);
        if (speedX > 0)
            setAttributes();
        else
            setMirroredAttributes();
        AffineTransform oldXForm = g2.getTransform();
        g2.scale(radius / 30, radius / 30);
        g2.setColor(colors[0]);
        g2.fill(fine1);
        g2.fill(fine2);
        g2.fill(tail);
        g2.setColor(colors[0]);
        g2.draw(fine1);
        g2.draw(fine2);
        g2.draw(tail);
        g2.setColor(colors[0]);
        g2.fill(head);
        g2.fill(body);
        g2.setColor(colors[0]);
        g2.fill(lens);
        g2.setColor(colors[0]);
        g2.fill(eye);
        g2.setColor(colors[0]);
        g2.draw(body);
        g2.draw(head);
        g2.draw(stripe1);
        g2.draw(stripe2);
        g2.setTransform(oldXForm);
	}

}
