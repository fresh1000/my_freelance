package tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestPrintTable {

	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from ROOM";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			connector.closeConnection();
		}

	}

}
