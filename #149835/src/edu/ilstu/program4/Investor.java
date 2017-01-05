package edu.ilstu.program4;

public class Investor {
	private String accountNumber;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phomeNumber;
	
	public Investor(String accountNumber, String firstName, String lastName, String streetAddress, String city,
			String state, String zipCode, String phomeNumber) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phomeNumber = phomeNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAdress) {
		this.streetAddress = streetAdress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhomeNumber() {
		return phomeNumber;
	}

	public void setPhomeNumber(String phomeNumber) {
		this.phomeNumber = phomeNumber;
	}
	
	public String formatAddress() {
		return this.streetAddress + " " + this.city + " " + this.state + " " + this.zipCode;
	}
	
	public String formatPhoneNumber() {
		return " " + this.phomeNumber;
		
	}
}
