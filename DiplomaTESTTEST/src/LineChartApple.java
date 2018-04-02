import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LineChartApple extends Application{
 
	//Button button;
	
	
    @Override public void start(Stage stage) throws FileNotFoundException {
        stage.setTitle("Line Chart Sample");
        //button = new Button();
		//button.setText("Click");
		//button.setOnAction(this);
		
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Day");       
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Monitoring Apple, 2016-2017");
                                
        XYChart.Series series = new XYChart.Series();
        series.setName("Apple");
        Apple dis = new Apple();
        ArrayList<String> date = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        date = dis.getDate();
        price = dis.getPrice();
        
        for (int i = date.size() - 1;i >= 0 ; i -= 10) {
        	series.getData().add(new XYChart.Data(date.get(i), price.get(i)));
        }
        
        //StackPane layout = new StackPane();
		//layout.getChildren().add(lineChart);
        //layout.getChildren().add(button);
        Scene scene  = new Scene(lineChart,900,700);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }

}