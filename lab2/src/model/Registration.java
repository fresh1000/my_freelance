package model;

import java.sql.Date;
import java.sql.Time;

public class Registration {
	
	private int id;
	private Client client;
	private Master master;
	private Date date;
	private String service;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", client=" + client + ", master=" + master + ", date=" + date + ", service=" + service + "]";
	}


}
