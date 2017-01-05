import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.QuadCurve2D;
public class Shark extends GeneralFish {
    private QuadCurve2D.Double tail1;
    private QuadCurve2D.Double tail2;
    int g2 = 0;

    public Shark(int x, int y, int radius, int moveAngle, int speed, int id) {
        super(x, y, radius, moveAngle, speed, id);
        tail1 = new QuadCurve2D.Double();
        tail2 = new QuadCurve2D.Double();
    }
    protected void setAttributes() {
        super.setAttributes();
        head.setArc(-20, 0, HEAD_WIDTH + 50, HEAD_WIDTH, -100, 200, Arc2D.PIE);
        tail1.setCurve(-15, 10, -25, 30, -10, 10);
        tail2.setCurve(-15, 10, -25, -20, -10, 10);
        fine2.setCurve(10, 5, -15, -15, 15, 0);
        fine1.setCurve(10, 15, -15, 30, 20, 15);
    }
    protected void setMirroredAttributes() {
        super.setMirroredAttributes();
        head.setArc(0 - 30, 0, HEAD_WIDTH + 50, HEAD_WIDTH, 80, 200, Arc2D.PIE);
        tail1.setCurve(15 + HEAD_WIDTH, 10, 25 + HEAD_WIDTH, 30, 10 + HEAD_WIDTH, 10);
        tail2.setCurve(15 + HEAD_WIDTH, 10, 25 + HEAD_WIDTH, -20, 10 + HEAD_WIDTH, 10);
        fine2.setCurve(-10 + HEAD_WIDTH, 5, 15 + HEAD_WIDTH, -15, -15 + HEAD_WIDTH, 0);
        fine1.setCurve(-10 + HEAD_WIDTH, 15, 15 + HEAD_WIDTH, 30, -20 + HEAD_WIDTH, 15);
    }
    @Override
    public boolean canEat(GeneralFish fish) {
        float res = this.getY() - fish.getY();
        float res2 = this.getX() - fish.getX();
        if (res < 5) {
            if (res2<5){
            float ang = ((this.getMoveAngle() + fish.getMoveAngle()) + 180) / 180;
            if ((ang) < 120) {
                return true;
            }
        }}
        return false;
    }
    @Override
    public void drawFish(Graphics2D g2) {
        g2.translate(x - 10, y);
        if (speedX > 0)
            setAttributes();
        else
            setMirroredAttributes();
        AffineTransform oldXForm = g2.getTransform();
        g2.scale(radius / 30, radius / 30);
        g2.setColor(Color.BLACK);
        g2.fill(fine1);
        g2.fill(fine2);
        g2.fill(tail1);
        g2.fill(tail2);
        g2.draw(fine1);
        g2.draw(fine2);
        g2.draw(tail1);
        g2.draw(tail2);
        g2.setColor(Color.GRAY);
        g2.fill(head);
        g2.fill(body);
        g2.setColor(Color.BLACK);
        g2.fill(lens);
        g2.setColor(Color.WHITE);
        g2.fill(eye);
        g2.setColor(Color.BLACK);
        g2.draw(body);
        g2.draw(head);
        g2.draw(stripe1);
        g2.draw(stripe2);
        g2.setTransform(oldXForm);
    }
}
