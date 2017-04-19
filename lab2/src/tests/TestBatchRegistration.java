package tests;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.MyConnector;

public class TestBatchRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		Date date = new Date(117, 10, 10);
//		String dateInString = date.toString();
		try {
			PreparedStatement pst = conn.prepareStatement(
					"insert into REGISTRATION(IDCLIENT, IDMASTER, DATE) values(?, ?, ?)");
			pst.setInt(1, 1);
			pst.setInt(2, 1);
		    pst.setDate(3, date);
			pst.addBatch();
			pst.executeBatch();
//			TestPrintTable.main(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
