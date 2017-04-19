package model;

public class Room {
	private int id;
	private int name;
	private String category;
	private int count_person;
	private double price;


	@Override
	public String toString() {
		return "Room [id=" + id + ",name=" + name + ", category=" + category + ", count_person=" + count_person + ", price="
				+ price + "]";
	}
}
