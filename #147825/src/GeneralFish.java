import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.util.Random;
public abstract class GeneralFish {
    protected float x;
    protected float y;
    protected int radius;
    private int moveAngle;
    private int speed;
    protected float speedX, speedY;
    protected Color[] colors;
    private int id;
    protected Arc2D.Double head;
    protected Arc2D.Double body;
    protected Ellipse2D.Double eye;
    protected Ellipse2D.Double lens;
    protected QuadCurve2D.Double fine1;
    protected QuadCurve2D.Double fine2;
    protected CubicCurve2D.Double tail;
    protected CubicCurve2D.Double stripe1;
    protected CubicCurve2D.Double stripe2;
    protected final int HEAD_WIDTH = 20;
    public final static Random RANDOM = new Random();
    public final static Color[] COLORS = {Color.RED, Color.ORANGE, Color.WHITE, Color.BLACK};
    public GeneralFish(int x, int y, int radius, int moveAngle, int speed, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.radius = radius;
        this.moveAngle = moveAngle;
        this.speed = speed;
        colors = new Color[6];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = getRandomColor();
        }
        updateSpeeds();
        lens = new Ellipse2D.Double();
        head = new Arc2D.Double();
        eye = new Ellipse2D.Double();
        body = new Arc2D.Double();
        fine1 = new QuadCurve2D.Double();
        fine2 = new QuadCurve2D.Double();
        tail = new CubicCurve2D.Double();
        stripe1 = new CubicCurve2D.Double();
        stripe2 = new CubicCurve2D.Double();
    }
    public void updateSpeeds() {
        this.speedX = (float) (Math.cos(Math.toRadians(moveAngle)) * speed);
        this.speedY = -(float) (Math.sin(Math.toRadians(moveAngle)) * speed);
    }
    protected void setAttributes() {
        head.setArc(0, 0, HEAD_WIDTH + 10, HEAD_WIDTH, -100, 200, Arc2D.PIE);
       
        eye.setFrame(HEAD_WIDTH / 2 + 15, HEAD_WIDTH / 2 - 2, 2, 2);
        lens.setFrame(HEAD_WIDTH / 2 + 10, HEAD_WIDTH / 2 - 4, 7, 7);
        body.setArc(-10, 0, HEAD_WIDTH + 30, HEAD_WIDTH, -95, -170, Arc2D.PIE);
        fine2.setCurve(-5, 5, 5, -10, 10, 0);
        tail.setCurve(0, 15, -30, -40, -30, +30, 0, 15);
        fine1.setCurve(-5, 15, -10, 30, 5, 15);
        stripe1.setCurve(15, 10, 4, -10 + HEAD_WIDTH, -5, -5 + HEAD_WIDTH, -7, 15);
        stripe2.setCurve(13, 5, 4, -15 + HEAD_WIDTH, -5, -10 + HEAD_WIDTH, -8, 13);
    }
    protected void setMirroredAttributes() {
        head.setArc(0 - 10, 0, HEAD_WIDTH + 10, HEAD_WIDTH, 80, 200, Arc2D.PIE);
        eye.setFrame(-HEAD_WIDTH / 2 + 5, HEAD_WIDTH / 2 - 2, 2, 2);
        lens.setFrame(-HEAD_WIDTH / 2 + 5, HEAD_WIDTH / 2 - 4, 7, 7);
        body.setArc(-20, 0, HEAD_WIDTH +
                30, HEAD_WIDTH, 85, -170, Arc2D.PIE);
        fine2.setCurve(5 + HEAD_WIDTH, 5, -5 + HEAD_WIDTH, -10, -10 + HEAD_WIDTH, 0);
        tail.setCurve(0 + HEAD_WIDTH, 15, 30 + HEAD_WIDTH, -40, 30 + HEAD_WIDTH, 30, 0 + HEAD_WIDTH, 15);
        fine1.setCurve(5 + HEAD_WIDTH, 15, 10 + HEAD_WIDTH, 30, -5 + HEAD_WIDTH, 15);
        stripe1.setCurve(-15 + HEAD_WIDTH, 10, -4 + HEAD_WIDTH, -10 + HEAD_WIDTH, 5 + HEAD_WIDTH, -5 + HEAD_WIDTH, 7 + HEAD_WIDTH, 15);
        stripe2.setCurve(-13 + HEAD_WIDTH, 5, -4 + HEAD_WIDTH, -15 + HEAD_WIDTH, 5 + HEAD_WIDTH, -10 + HEAD_WIDTH, 8 + HEAD_WIDTH, 13);
    }
    protected Color getRandomColor() {
        return COLORS[RANDOM.nextInt(COLORS.length)];
    }
    protected void drawFish(Graphics2D g2) {
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
        g2.setColor(colors[1]);
        g2.draw(fine1);
        g2.draw(fine2);
        g2.draw(tail);
        g2.setColor(colors[2]);
        g2.fill(head);
        g2.fill(body);
        g2.setColor(colors[3]);
        g2.fill(lens);
        g2.setColor(colors[4]);
        g2.fill(eye);
        g2.setColor(colors[5]);
        g2.draw(body);
        g2.draw(head);
        g2.draw(stripe1);
        g2.draw(stripe2);
        g2.setTransform(oldXForm);
    }
    public int getMoveAngle() {
        return moveAngle;
    }
    public void setMoveAngle(int moveAngle) {
        this.moveAngle = moveAngle;
    }
    public int getRadius() {
        return radius;
    }
    public int getSpeed() {
        return speed;
    }
    public float getSpeedX() {
        return speedX;
    }
    public float getSpeedY() {
        return speedY;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public int getId() {
        return id;
    }
    public boolean detectCollision(GeneralFish fish) {
        float dif = (float) ((this.getRadius() + fish.getRadius()) -
                Math.sqrt(Math.pow(this.getX() - fish.getX(), 2) +
                        (Math.pow(this.getY() - fish.getY(), 2))));
        if (dif > 0) { // If current fishes are collided.
            return true;
        } // if
        return false;
    }

    protected boolean canEat(GeneralFish fish) {
        return false;
    }
    public void addRadius() {
        radius = radius + 5;
    }
}
