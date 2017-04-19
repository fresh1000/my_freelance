package model;

public class Master {
	private int id;
	private String lastname;
	private String firstname;
	private String activity;
	private String email;
	
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
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
	@Override
	public String toString() {
		return "Master [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", activity=" + activity
				+ ", email=" + email + "]";
	}
	
}
