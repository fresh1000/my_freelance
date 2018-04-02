import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javafx.scene.chart.XYChart;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This program demonstrates how to draw line chart with CategoryDataset
 * using JFreechart library.
 * @author www.codejava.net
 *
 */
public class CChart extends JFrame {
	
	
	
    public CChart() {
        super("Line Chart Apple");
 
        JPanel chartPanel = createChartPanel();
        getContentPane().add(chartPanel, BorderLayout.CENTER);
        
        JButton btnOk = new JButton("Ok");
        btnOk.setBounds(0, 418, 79, 23);
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        		dispose();
        	}
        });
        chartPanel.setLayout(null);
        chartPanel.add(btnOk);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    private JPanel createChartPanel() {
    	String chartTitle = "Apple stock prices";
        String categoryAxisLabel = "Date";
        String valueAxisLabel = "Price";
     
        CategoryDataset dataset = createDataset();
     
        JFreeChart chart = ChartFactory.createLineChart(chartTitle,
                categoryAxisLabel, valueAxisLabel, dataset);
     
        return new ChartPanel(chart);
    }
 
    private CategoryDataset createDataset() {
    	 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
 	    String series1 = "Apple";
 	    Apple ap = new Apple();
 	    
 	   for (int i = ap.profit.size() - 1;i >= 0 ; i--) {
 		  if(ap.profit.get(i) > 0) {
 		  dataset.addValue(ap.profit.get(i), series1, ap.date.get(i));
 		  }		   
       }
 	 
 	    return dataset;
    }
 
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CChart().setVisible(true);
            }
        });
    }
}