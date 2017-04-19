package tests;
import java.sql.Connection;

import controller.MyConnector;

public class TestCreateDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		System.out.println(conn);
		connector.closeConnection();

	}

}
