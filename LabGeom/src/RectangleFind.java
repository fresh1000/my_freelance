import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; //Vector
import java.lang.*; //Math


public class RectangleFind extends JFrame {
	JLabel label;
	JPanel buttonPane;
	JButton bReset;
	JButton bFind;
	JButton bStep;

	ConvexHull polygon;
	RectangleArea rectangleArea;
	MyListener myListener;

	public void init() {
		buildUI(getContentPane());
	}

	void buildUI(Container container) {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label = new JLabel("Click within the framed area.");
		container.add(label);

		polygon = new ConvexHull();

		rectangleArea = new RectangleArea(this);

		myListener = new MyListener(this);
		rectangleArea.addMouseListener(myListener);

		container.add(rectangleArea);

		buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		bReset = new JButton("Reset");
		bReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polygon = new ConvexHull();
				rectangleArea.repaint();
				updateLabel(0);
			}
		});
		bFind = new JButton("Find Largest Rectangle");
		bFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				polygon.computeLargestRectangle();
				rectangleArea.displayedRect = 6;
				polygon.status = 16;
				rectangleArea.repaint();
			}
		});

		//bStep = new JButton("Step");
//		bStep.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (polygon.changed) {
//					// System.out.println("caught");
//					polygon.computeLargestRectangle();
//				}
//				// System.out.println(polygon.changed);
//				rectangleArea.displayedRect++;
//				if (rectangleArea.displayedRect == 7) {
//					rectangleArea.displayedRect = 0;
//				}
//				polygon.status = rectangleArea.displayedRect + 10;
//				rectangleArea.repaint();
//			}
//		});

		buttonPane.add(bReset);
		buttonPane.add(Box.createHorizontalStrut(10)); // createHorizontalGlue();
		buttonPane.add(bFind);
		//buttonPane.add(bStep);

		container.add(buttonPane);

		// Align the left edges of the components.
		rectangleArea.setAlignmentX(LEFT_ALIGNMENT);
		label.setAlignmentX(LEFT_ALIGNMENT); // unnecessary, but doesn't hurt
		buttonPane.setAlignmentX(LEFT_ALIGNMENT);
	}

	/* display a predefined message for a given msg state */
	public void updateLabel(int msg) {
		if (msg == 0) {
			label.setText("Click within the framed area to add points");
		} else if (msg == 1) {
			label.setText("Point added, click to add more points");
		} else if (msg == 2) {
			label.setText("point added to polygon");
		} else if (msg == 3) {
			label.setText("point inside not added");
		} else if (msg == 10) {
			label.setText("Largest rectangle with corners on A and C only");
		} else if (msg == 11) {
			label.setText("Largest rectangle with corners on B and D only");
		} else if (msg == 12) {
			label.setText("Largest rectangle with corners on A,B and C");
		} else if (msg == 13) {
			label.setText("Largest rectangle with corners on A,B and D");
		} else if (msg == 14) {
			label.setText("Largest rectangle with corners on A,C and D");
		} else if (msg == 15) {
			label.setText("Largest rectangle with corners on B,C and D");
		} else if (msg == 16) {
			label.setText("Largest rectangle in polygon");
		} else {
			label.setText("Click to add points");
		}

	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("RectangleFind");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		RectangleFind controller = new RectangleFind();
		controller.buildUI(f.getContentPane());
		f.pack();
		f.setVisible(true);
	}

}

