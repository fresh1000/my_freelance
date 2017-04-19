package tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.MyConnector;

public class TestBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(
					"insert into CLIENT(LASTNAME, FIRSTNAME, DISCOUNTCARD, EMAIL) values(?, ?, ?, ?)");
			pst.setString(1, "Іваненко");
			pst.setString(2, "Світлана");
			pst.setInt(3, 123456);
			pst.setString(4, "ivanenko@gmail.com");
			pst.addBatch();
			pst.setString(1, "Чижова");
			pst.setString(2, "Юлія");
			pst.setInt(3, 456679);
			pst.setString(4, "chij_jul@ukr.net");
			pst.addBatch();
			pst.setString(1, "Ступанок");
			pst.setString(2, "Олена");
			pst.setInt(3, 234567);
			pst.setString(4, "stupanok1983@mail.ru");
			pst.addBatch();
			pst.executeBatch();
//			TestPrintTable.main(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
