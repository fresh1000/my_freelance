package tests;

import controller.JdbcController;
import view.MainView;
import controller.IController;

public class TestMainView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainView view = new MainView();
		view.setController(new JdbcController());
		view.setVisible(true);
	}
}
