package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbsController implements IController {
	
	MyConnector connector = new MyConnector();
	
	/* (non-Javadoc)
	 * @see controller.IController#createDB()
	 */
	@Override
	public void createDB() {
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			st.addBatch("create table ROOM (" 
					+ " ID_ROOM integer generated always as identity,"
					+ " NAME varchar(30) default '' not null," 
					+ " CATEGORY varchar(30) default '' not null," 
					+ " COUNT_PERSON int(30) default '' not null,"
					+ " PRISE double(30) default '' not null,"
					+ " primary key (ID_ROOM)) ");
			st.addBatch("create table VISITOR (" 
					+ " ID_Visitor	 integer generated always as identity," 
					+ " FIO string," 
					+ " GRAZHDANSTVO string,"
					+ " DATE_BIRTH string,"
					+ " primary key (ID_PASPORTA))");
			st.addBatch("create table ADMIN (" 
					+ " ID_ADMIN integer generated always as identity," 
					+ " ID_ROOM integer," 
					+ " FIO_ADMIN string,"
					+ " stag int,"
					+ " primary key (ID_ADMIN))");
			st.addBatch("alter table ADMIN " ////связывание вторичных ключей
					+" add constraint FK_ADMIN_ROOM " 
					+ "	foreign key (IDROOM)"
					+ " references ROOM(ID) on delete cascade");
			st.addBatch("alter table MARKS " 
					+ " add constraint FK_ADMIN_VISITOR " 
					+ " foreign key (IDVISITOR) "
					+ " references VISITOR(ID)  on delete cascade");
			st.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
	}
	/* (non-Javadoc)
	 * @see controller.IController#getModel(java.lang.String)
	 */
	@Override
	public JdbcTableModel getModel(String className) {
		String sql = null;
		if (className.equals ("Visitor"))
			sql = "select * from Visitor";
		else if (className.equals ("Room"))
			sql = "select * from Room";
		if (className.equalsIgnoreCase("Admin")) {
			sql = "select Admin.ID from Admin," ;
		}
		if (sql == null)
			return null;
		try {
			Connection conn = connector.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			return new JdbcTableModel(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			connector.closeConnection();
		}
	}

}
