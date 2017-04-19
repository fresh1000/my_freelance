package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			String lastname = "Бибик";
			String firstname = "Алла";
			int discountcard = 345678;
			String email = "bibik_alla@ukr.net";
			st.executeUpdate("insert into CLIENT(LASTNAME, FIRSTNAME,DISCOUNTCARD, EMAIL) values('" 
			+ lastname + "', '" + firstname + "', " + discountcard + ", '" + email + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
	}
}
