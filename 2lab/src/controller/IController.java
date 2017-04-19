package controller;

public interface IController {

	void createDB();

	JdbcTableModel getModel(String className);

}