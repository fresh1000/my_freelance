package model;

public class Admin {
	private int id;
	private Admin fio_admin;
	private Room id_room;
	private String date_input;
	private int stag;
	@Override
	public String toString() {
		return "Admin [id=" + id +", fio_admin=" + fio_admin + ", id_room=" + id_room + ", stag=" + stag
				+ ",date_input=" + date_input +",]";
	}

}
