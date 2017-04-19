package model;

public class Visitor {
	private int id;
	private String grazhdanstvo;
	private String fio;
	private String date_birth;
	@Override
	public String toString() {
		return "Visitor [id=" + id + ", grazhdanstvo=" + grazhdanstvo + ", fio=" + fio
				+ ", date_birth=" + date_birth + "]";
	}

}
