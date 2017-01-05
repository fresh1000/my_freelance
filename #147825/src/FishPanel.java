import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FishPanel extends JFrame {
	private ArrayList<GeneralFish> fishes;
	private ArrayList<GeneralFish> fishesR = new ArrayList<>();
	public final static int POND_W = 580;
	public final static int POND_H = 420;
	public final static int POND_X = 0;
	public final static int POND_Y = 0;
	private int countShark = 0;
	int time = 0;
	private int bubbleHeight;
	private Rectangle2D.Double pond;
	private Timer timer;
	private Hook hook;
	private GeneralFish toRemove;
	
	public FishPanel() {
		hook = new Hook(-1, -1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pond = new Rectangle2D.Double();
		pond.setFrame(POND_X, POND_Y, POND_W, POND_H);
		setSize(600, 450);
		createStopStart();
		createMainPanel();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void createStopStart() {
		JMenuBar jmb = new JMenuBar();
		JMenu jmAction = new JMenu("Action");
		JMenuItem jmi = new JMenuItem("Stop/Start");
		jmi.addActionListener((e) -> {
			if (timer.isRunning()) {
				timer.stop();
			} else {
				timer.start();
			}
		});
		jmAction.add(jmi);
		jmb.add(jmAction);
		setJMenuBar(jmb);
	}
	
	public void bubblesMove() {
		bubbleHeight = bubbleHeight + 1;
		if (bubbleHeight == 190) bubbleHeight = 0;
	}
	
	public void drawObjects(Graphics2D g) {
		g.setColor((new Color(255, 255, 102)));
		g.fillRect(POND_X, POND_Y + 260, POND_W, POND_H - 260);
		g.setColor(Color.green);
		CubicCurve2D.Double rock = new CubicCurve2D.Double();
		rock.setCurve(POND_X + 40, POND_Y + 270, POND_X + 50, POND_Y + 220, POND_X + 70, POND_Y + 240, POND_X + 80, POND_Y + 270);
		CubicCurve2D.Double rock2 = new CubicCurve2D.Double();
		rock2.setCurve(POND_X + 60, POND_Y + 265, POND_X + 70, POND_Y + 250, POND_X + 80, POND_Y + 250, POND_X + 90, POND_Y + 265);
		g.setColor(Color.CYAN);
		g.fillOval(POND_X + 60, POND_Y + 190 - bubbleHeight, 15, 15);
		g.fillOval(POND_X + 80, POND_Y + 200 - bubbleHeight, 20, 20);
		g.fillOval(POND_X + 70, POND_Y + 230 - bubbleHeight, 10, 10);
		g.setColor((new Color(192, 192, 192)));
		g.drawOval(POND_X + 57, POND_Y + 190 - bubbleHeight, 15, 15);
		g.drawOval(POND_X + 77, POND_Y + 200 - bubbleHeight, 20, 20);
		g.drawOval(POND_X + 67, POND_Y + 230 - bubbleHeight, 10, 10);
		g.setColor(Color.CYAN);
		g.fillOval(POND_X + 400, POND_Y + 240 - bubbleHeight, 15, 15);
		g.fillOval(POND_X + 380, POND_Y + 250 - bubbleHeight, 20, 20);
		g.fillOval(POND_X + 390, POND_Y + 280 - bubbleHeight, 10, 10);
		g.setColor((new Color(192, 192, 192)));
		g.drawOval(POND_X + 397, POND_Y + 240 - bubbleHeight, 15, 15);
		g.drawOval(POND_X + 377, POND_Y + 250 - bubbleHeight, 20, 20);
		g.drawOval(POND_X + 387, POND_Y + 280 - bubbleHeight, 10, 10);
		g.setColor((new Color(192, 192, 192)));
		g.fill(rock2);
		g.setColor(Color.BLACK);
		g.draw(rock2);
		g.setColor((new Color(192, 192, 192)));
		g.fill(rock);
		g.setColor(Color.BLACK);
		g.draw(rock);
	}
	
	private void createMainPanel() {
		JPanel jpMain = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(new Color(0, 200, 200));
				g2.fill(pond);
				drawObjects(g2);
				AffineTransform oldXForm = g2.getTransform();
				for (GeneralFish fish : fishes) {
					if (fish != null) {
						fish.drawFish(g2);
						g2.setTransform(oldXForm);
					}
				}
				if (toRemove != null) {
					toRemove.setSpeedX(-toRemove.getSpeedX()); // Shrink fish.
					g2.rotate(90, toRemove.getX(), toRemove.getY());
					toRemove.drawFish(g2);
				}
				g2.setTransform(oldXForm);
				bubblesMove();
				if (hook.getShrinkCount() <= 0) {
					toRemove = null;
					hook.setShrinkCount(200);
					hook.setAllowCatch(true);
				}

				/*
	             * Make hook disappeared outside the pond.
				 */
				if (hook.getX() > POND_X && hook.getX() < POND_W + POND_X &&
						hook.getY() > POND_Y && hook.getY() < POND_Y + POND_H) {
					hook.drawHook(g2);
				}
			}
		};
		jpMain.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent me) {
				int x = me.getX();
				int y = me.getY();

				/*
                 * Allow the user to drag hook.
				 */
				hook.setX(x);
				hook.setY(y);
				/**
				 * Adjust coordinates to achieve the center of hook.
				 */
				y += 90;
				x -= 10;
				if (toRemove != null) {
					toRemove.setX(x);
					toRemove.setY(y);
					if (toRemove.getY() < POND_Y - 10) {
						toRemove = null;
					}
				}

				/*
                 * Check whether the hook and fish are collided.
				 */
				for (int i = 0; i < fishes.size(); i++) {
					float dif = (float) ((fishes.get(i).getRadius() + 10) -
							Math.sqrt(Math.pow(fishes.get(i).getX() - x, 2) +
									(Math.pow(fishes.get(i).getY() - y, 2))));
					if (dif > 0 && hook.isAllowCatch()) { // If difference between the distance from center of fish and
						// center of hook is less than sum of their radiuses.
						removeFish(fishes.get(i));
						hook.setAllowCatch(false);
					}
				}
			}
			
			@Override
			public void mouseMoved(MouseEvent me) {
				hook.setX(me.getX());
				hook.setY(me.getY());
			}
		});
		jpMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent me) {
				hook.setAllowCatch(true);
				if (toRemove != null) {
					addFish();
				}
			}
		});
		add(jpMain);
	}
	
	public void removeFish(GeneralFish fish) {
		toRemove = fish;
		fishes.remove(fish);
	}
	
	public void addFish() {
		fishes.add(toRemove);
		toRemove = null;
	}
	
	public void startTimer(ArrayList<GeneralFish> fishes) {
		this.fishes = fishes;
		timer = new Timer(20, (e) -> {
			applyBouncing();
			repaint();
			respawn();
		});
	}
	
	private void applyBouncing() {
		List<GeneralFish[]> collided = isCollision();
		if (!collided.isEmpty()) {
			resolveCollision(collided);
		}
		for (GeneralFish fish : fishes) {
			if (fish.getClass().toString().equals("class Shark")) {
				fish.setX(fish.getX() + fish.getSpeedX());
				fish.setY((float) (fish.getY() + (5 * Math.sin(fish.getX()))));
			} else {
				fish.setX(fish.getX() + fish.getSpeedX());
				fish.setY(fish.getY() + fish.getSpeedY());
			}

			/*
             * Avoid moving out the borders.
			 */
			if (fish.getX() + fish.getRadius() > POND_W + 50) {
				fishesR.add(fish);
			}
			if (fish.getX() - fish.getRadius() < POND_X - 50) {
				fishesR.add(fish);
			}
			if (fish.getY() + fish.getRadius() > POND_H + POND_Y + 50) {
				fishesR.add(fish);
			}
			if (fish.getY() - fish.getRadius() < POND_Y - 50) {
				fishesR.add(fish);
			}
			fish.updateSpeeds();
		}
		remove2All();
	} // method
	
	private void remove2All() {
		for (GeneralFish gf : fishesR) {
			fishes.remove(gf);
			if (gf.getClass().toString().equals("class Shark")) {
				countShark = countShark - 1;
			}
		}
		fishesR.clear();
	}
	
	public List<GeneralFish[]> isCollision() {
		List<GeneralFish[]> list = new ArrayList<>();
		GeneralFish[] collided = null;
		for (int a = 0; a < fishes.size(); a++) {
			for (int b = a; b < fishes.size(); b++) {
				if (a != b) {
					GeneralFish fish1 = fishes.get(a);
					GeneralFish fish2 = fishes.get(b);
					if (fish1 != null && fish2 != null) {
						float dif = (float) ((fish1.getRadius() + fish2.getRadius()) -
								Math.sqrt(Math.pow(fish1.getX() - fish2.getX(), 2) +
										(Math.pow(fish1.getY() - fish2.getY(), 2))));
						if (dif > 0) { // If current fishes are collided.
							collided = new GeneralFish[2];
							collided[0] = fish1;
							collided[1] = fish2;
							list.add(collided);
						} // if
					}
				} // if a != b
			} // for inner
		} // for outer
		return list;
	}
	
	private void resolveCollision(List<GeneralFish[]> list) {
		for (GeneralFish[] fishes : list) {
			if (fishes[0].canEat(fishes[1])) {
				this.fishes.remove(fishes[1]);
				fishes[0].radius = fishes[0].radius + 10;
				repaint();
				return;
			}
			if (fishes[1].canEat(fishes[0])) {
				this.fishes.remove(fishes[0]);
				repaint();
				fishes[1].radius = fishes[1].radius + 10;
				return;
			}
			int i2 = 0;
			int angle1 = fishes[0].getMoveAngle();
			int angle2 = fishes[1].getMoveAngle();
			double k1 = (fishes[1].getY() - fishes[0].getY()) / (fishes[1].getX() - fishes[0].getX());
			double k2 = -1 / k1;
			int angleToX = (int) (Math.toDegrees(Math.atan(k2)));
			angleToX = (angleToX < 0 ? -angleToX : (angleToX == 0 ? 0 : 180 - angleToX));
			if (angleToX == 0 || angleToX == 90 || angleToX == 180) {
				fishes[0].setMoveAngle((int) (angle2));
				fishes[1].setMoveAngle((int) (angle1));
			} else if (fishes[0].getY() < fishes[1].getY()) {
				fishes[0].setMoveAngle((int) (180 - angleToX));
				fishes[1].setMoveAngle((int) (360 - angleToX));
			} else if (fishes[0].getY() > fishes[1].getY()) {
				fishes[0].setMoveAngle((int) (360 - angleToX));
				fishes[1].setMoveAngle((int) (180 - angleToX));
			} else {
				fishes[0].setMoveAngle((int) (angle2));
				fishes[1].setMoveAngle((int) (angle1));
			}
			if (fishes[0].getSpeed() == 0) {
				fishes[0].setSpeed(fishes[1].getSpeed());
				if (angleToX == 0 || angleToX == 90 || angleToX == 180) {
					fishes[0].setMoveAngle((int) (angle2));
					fishes[1].setMoveAngle((int) (angle2 + 180));
				} else if (angleToX < 90) {
					fishes[0].setMoveAngle(90 + angleToX);
					fishes[1].setMoveAngle(fishes[1].getY() > fishes[0].getY() ? fishes[0].getMoveAngle() + 90 : fishes[0].getMoveAngle() - 90);
				} else {
				}
			}
			if (fishes[1].getSpeed() == 0) {
				fishes[1].setSpeed(fishes[0].getSpeed());
				if (angleToX == 0 || angleToX == 90 || angleToX == 180) {
					fishes[1].setMoveAngle((int) (angle1));
					fishes[0].setMoveAngle((int) (angle1 + 180));
				} else if (angleToX < 90) {
					System.out.println("hit");
					fishes[1].setMoveAngle(90 + angleToX);
					fishes[0].setMoveAngle(fishes[0].getY() > fishes[1].getY() ? fishes[1].getMoveAngle() + 90 : fishes[1].getMoveAngle() - 90);
				} else {
				}
			}
			fishes[0].updateSpeeds();
			fishes[1].updateSpeeds();
		}
	}
	
	public void setFishes(ArrayList<GeneralFish> fishes) {
		this.fishes = fishes;
	}
	
	private class Hook {
		private int x;
		private int shrinkCount = 200; // Initial number of shrinks. If zero - fish is disappeared.
		private int y;
		private boolean allowCatch = true;
		private Stroke strokeBase;
		private Stroke strokeMin;
		private Stroke strokeMax;
		private Stroke strokeCur;
		
		public Hook(int x, int y) {
			this.x = x;
			this.y = y;
			strokeBase = new BasicStroke(3);
			strokeMin = new BasicStroke(1);
			strokeMax = new BasicStroke(5);
			strokeCur = strokeBase;
		}
		
		public void setX(int x) {
			this.x = x;
		}
		
		public void setY(int y) {
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public void drawHook(Graphics2D g) {
			g.setColor(Color.BLACK);
			if (!allowCatch) {
				g.setStroke(strokeCur.equals(strokeBase) || strokeCur.equals(strokeMin) ?
						(strokeCur = strokeMax) : (strokeCur = strokeMin));
				shrinkCount--;
				System.out.println(shrinkCount);
			} else {
				shrinkCount = 200;
				g.setStroke(strokeBase);
				strokeCur = strokeBase;
			}
			g.drawLine(x, y, x, y + 100);
			g.drawArc(x - 20, y + 90, 20, 20, 180, 180);
		}
		
		public boolean isAllowCatch() {
			return allowCatch;
		}
		
		public void setAllowCatch(boolean allowCatch) {
			this.allowCatch = allowCatch;
		}
		
		public int getShrinkCount() {
			return shrinkCount;
		}
		
		public void setShrinkCount(int shrinkCount) {
			this.shrinkCount = shrinkCount;
		}
	}
	
	private void respawn() {
		time++;
		if (time > 15) {
			time = 0;
			if (this.fishes.size() < 10) {
				Random rand = new Random();
				int Side = rand.nextInt(2);
				int angle = (rand.nextInt(90) + 315) + (180 * Side);
				if (countShark < 2) {
					fishes.add(new Shark(((Side * (POND_W - 50)) + 10), (rand.nextInt(POND_H - 50) + 10), 35, (angle % 360), 2, 1));
					countShark++;
				} else {
					fishes.add(new HerbivoreFish(((Side * (POND_W - 50)) + 10), (rand.nextInt(POND_H - 50) + 10), 35, (angle % 360), 2, 1));
				}
			}
		}
	}
} // class
