package tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.RowSet;

import com.sun.rowset.CachedRowSetImpl;

import controller.MyConnector;

public class TestCashed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from ROOM";
			ResultSet rs = st.executeQuery(sql);
			RowSet rws = null;
			rws = new CachedRowSetImpl();
			((CachedRowSetImpl) rws).populate(rs);
			TestPrintTable.main(null);
			rws.absolute(2);
			System.out.println("Record 2 is " + rws.getString("name"));
			rws.previous();
			System.out.println("Previous is " + rws.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}

	}

}
