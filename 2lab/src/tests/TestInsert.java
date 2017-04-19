package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestInsert {

	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			String name = "Vip";
			st.executeUpdate("insert into ROOM(NAME) values('" + name + "')");
			String sql = 
		"insert into ROOM(NAME) values(" + "'mid'" + ")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}

	}

}
