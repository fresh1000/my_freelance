import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartProfitMicrosoft extends Application {
 
    @Override public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Line Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Day");       
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring Microsoft, 2016-2017");
                                
        XYChart.Series series = new XYChart.Series();
        Microsoft microsoft = new Microsoft();
        series.setName("All profit: $" + microsoft.allProfit);
        ArrayList<String> date = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Double> profit = new ArrayList<>();
        date = microsoft.getDate();
        profit = microsoft.getProfit();
        
        for (int i = profit.size() - 1;i >= 0 ; i--) {
        	if(profit.get(i) > 0) {
        		series.getData().add(new XYChart.Data(date.get(i), profit.get(i)));
        	}
        }
        
        
        Scene scene  = new Scene(lineChart,900,700);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}