package model;

public class Client {
	private int id;
	private String lastname;
	private String firstname;
	private int discountcard;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDiscountCard() {
		return discountcard;
	}
	public void setDiscountCard(int discountcard) {
		this.discountcard = discountcard;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", discountcard="
				+ discountcard + ", email=" + email + "]";
	}


}
