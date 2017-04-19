package tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MyConnector;

public class TestCreateTable {
	public static void main(String[] args) {
	MyConnector connector = new MyConnector();
	Connection conn = connector.getConnection();
	
	try {
		Statement st = conn.createStatement();
		st.executeUpdate("create table CLIENT ("
				+ "ID integer generated always as identity,"
				+ "LASTNAME varchar(30) default '' not null, " 
				+ "FIRSTNAME varchar(30) default '' not null, " 
				+ "DISCOUNTCARD integer, " 
				+ "EMAIL varchar(30) default '' not null,"
				+ "primary key (ID))");
	} catch (SQLException e) {		
		e.printStackTrace();
	}finally{
		connector.closeConnection();
	}
}
}
