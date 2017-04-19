package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.TableModel;

import model.*;

public class JdbcController implements IController {
	MyConnector connector = new MyConnector();
	
	/* (non-Javadoc)
	 * @see controller.IController#createDB()
	 */
	@Override
	public void createDB() {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			st.addBatch("create table MASTER (" 
					+ " ID integer generated always as identity," 
					+ " LASTNAME varchar(30) default '' not null," 
					+ " FIRSTNAME varchar(30) default '' not null,"
					+ " ACTIVITY varchar(30) default '' not null,"
					+ " EMAIL varchar(30) default '' not null,"
					+ " primary key (ID))");
			st.addBatch("create table REGISTRATION (" 
					+ " ID integer generated always as identity," 
					+ " IDCLIENT integer, IDMASTER integer," 
					+ " DATE date ,"
					+ " SERVICE varchar(30) default '' not null,"
					+ " primary key (ID))");
			st.addBatch("alter table REGISTRATION " 
					+ " add constraint FK_REGISTRATION_MASTER " 
					+ "	foreign key (IDMASTER)"
					+ " references MASTER (ID) on delete cascade");
			st.addBatch("alter table REGISTRATION " 
					+ " add constraint FK_REGISTRATION_CLIENT " 
					+ " foreign key (IDCLIENT) "
					+ " references CLIENT (ID) on delete cascade");
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
		if (className.equals ("Client"))
			sql = "select * from CLIENT";
		else if (className.equals ("Master"))
			sql = "select * from MASTER";
		if (className.equalsIgnoreCase("Registration")) {
			sql = "select REGISTRATION.ID as ID, MASTER.LASTNAME as MASTER," 
					+ " CLIENT.LASTNAME as CLIENT, REGISTRATION.DATE, REGISTRATION.SERVICE"
					+ " from REGISTRATION,MASTER,CLIENT"
					+ " where REGISTRATION.IDMASTER = MASTER.ID "
					+ " and  REGISTRATION.IDCLIENT = CLIENT.ID";
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
	
	public void add(Object obj) {
		if (obj == null)
			return;
		Connection conn = connector.getConnection();
		PreparedStatement pst = null;
		try {
			if (obj instanceof Client) {
				pst = conn.prepareStatement(
	"insert into CLIENT(LASTNAME, FIRSTNAME, DISCOUNTCARD, EMAIL) values(?,?,?,?)");
				pst.setString(1, ((Client) obj).getLastname());
				pst.setString(2, ((Client) obj).getFirstname());
				pst.setInt(3, ((Client) obj).getDiscountCard());
				pst.setString(4, ((Client) obj).getEmail());
			} else if (obj instanceof Master) {
				pst = conn.prepareStatement(
	"insert into MASTER(LASTNAME, FIRSTNAME, ACTIVITY, EMAIL) values(?,?,?,?)");
				pst.setString(1, ((Master) obj).getLastname());
				pst.setString(2, ((Master) obj).getFirstname());
				pst.setString(3, ((Master) obj).getActivity());
				pst.setString(4, ((Master) obj).getEmail());
			} else if (obj instanceof Registration) {
				Master master = ((Registration) obj).getMaster();
				int id_master = master.getId();
				Client client = ((Registration) obj).getClient();
				int id_client = client.getId();
				pst = conn.prepareStatement(
	"insert into REGISTRATION(IDMASTER, IDCLIENT, DATE, SERVICE) values(?,?,?,?)");
				pst.setObject(1, id_master);
				pst.setObject(2, id_client);
				pst.setDate(3, ((Registration) obj).getDate());
				pst.setString(4, ((Registration) obj).getService());
			}
			if (pst != null) {
				pst.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
	}
	public void edit(int id, Object obj) {
		if (obj == null)
			return;
		Connection conn = null;
		try {
			conn = connector.getConnection();
			PreparedStatement pst = null;
			if (obj instanceof Client) {
				pst = conn.prepareStatement(
	"update CLIENT set LASTNAME = ?, FIRSTNAME = ?, DISCOUNTCARD = ?, EMAIL = ? where ID = ?");
				pst.setInt(5, id);
				pst.setString(1, ((Client) obj).getLastname());
				pst.setString(2, ((Client) obj).getFirstname());
				pst.setInt(3, ((Client) obj).getDiscountCard());
				pst.setString(4, ((Client) obj).getEmail());
			} else if (obj instanceof Master) {
				pst = conn.prepareStatement(
	"update MASTER set LASTNAME = ?, FIRSTNAME = ?, ACTIVITY = ?, EMAIL = ? where ID = ?");
				pst.setInt(5, id);
				pst.setString(1, ((Master) obj).getLastname());
				pst.setString(2, ((Master) obj).getFirstname());
				pst.setString(3, ((Master) obj).getActivity());
				pst.setString(4, ((Master) obj).getEmail());
			} else if (obj instanceof Registration) {
//			    Master master = ((Registration) obj).getMaster();
//				int id_master = master.getId();
//				Client client = ((Registration) obj).getClient();
//				int id_client = client.getId();
				pst = conn.prepareStatement(
	"update REGISTRATION set DATE = ?, where ID =?");
				pst.setInt(2, id);
				pst.setDate(1, ((Registration) obj).getDate());
			}
			if (pst != null) {
				pst.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
	}
	
	
	public void delete(int id, String className) {
		Connection conn = null;
		try {
			conn = connector.getConnection();
			PreparedStatement pst = null;
			if (className.equals("Client"))
				pst = conn.prepareStatement(
"DELETE FROM CLIENT WHERE CLIENT.ID = ?");
			else if (className.equals("Master"))
				pst = conn.prepareStatement(
"DELETE FROM MASTER WHERE MASTER.ID = ?");
			else if (className.equals("Registration"))
				pst = conn.prepareStatement(
"DELETE FROM REGISTRATION WHERE REGISTRATION.ID = ?");
			if (pst != null) {
				pst.setInt(1, id);
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
}
	public TableModel doQuery1() {
		String sql = "select CLIENT.LASTNAME as CLIENT, REGISTRATION.DATE, REGISTRATION.SERVICE"
				+ " from REGISTRATION,CLIENT"
				+ " where REGISTRATION.IDCLIENT = CLIENT.ID"
				+ " and REGISTRATION.SERVICE = 'Стрижка'";
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
	public TableModel doQuery2() {
		String sql = "select MASTER.LASTNAME as MASTER, REGISTRATION.DATE, REGISTRATION.SERVICE"
				+ " from REGISTRATION,MASTER"
				+ " where REGISTRATION.IDMASTER = MASTER.ID"
				+ " and REGISTRATION.DATE < '2017-5-10'";
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
