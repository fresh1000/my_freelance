package tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestPrintTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {	
			Statement st = conn.createStatement();
			String sql = "select * from CLIENT";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getString(3) +
						"\n    email:" +  rs.getString(5)+ "  card# " + rs.getInt(4));
		} catch (SQLException e) {		
			e.printStackTrace();
		}finally{
			connector.closeConnection();
		}
	}
}