package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import controller.MyConnector;

public class TestInsertRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
	        int idclient = 1;
			int idmaster = 2;
			Date date = new Date(2017-9-27);
			st.executeUpdate("insert into REGISTRATION(IDCLIENT, IDMASTER, DATE) values(" + idclient + ", " + idmaster + ", " + date +")");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
	}
}
