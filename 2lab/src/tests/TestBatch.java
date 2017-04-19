package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.MyConnector;

public class TestBatch {

	public static void main(String[] args) {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(
					"insert into ROOM(NAME) values(?)");
			pst.setString(1, "Mid");
			pst.addBatch();
			pst.setString(1, "Vip");
			pst.addBatch();
			pst.executeBatch();
			TestPrintTable.main(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
