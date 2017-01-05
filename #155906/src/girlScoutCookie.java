
/**
* Final Exam
* Final Exam Challenge Girl Scout Cookies
*
* @author 
* Date:
* Filename: gilScoutCookie.java
*
* This is the girlScoutCookie program which contains the girlScoutCookie class.
* This class stores customer information about the customer and the cookies they
* looking to order.
*
* @param �
* @return �
*/
import java.util.ArrayList;

public class girlScoutCookie {
	private String title;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNum;
	private ArrayList<Integer> cookie = new ArrayList<Integer>(8);
	
	//constructor with all parametrs with validation 
	public girlScoutCookie(String title, String firstName, String lastName, String address, String city, String state,
			String zipCode, String phoneNum, ArrayList<Integer> cookie) {
		if (title.length() <= 4) {
			this.title = title;
		} else {
			System.out.println("Invalid title");
			System.exit(0);
		}
		if (firstName.length() <= 15) {
			this.firstName = firstName;
		} else {
			System.out.println("Invalid firstName");
			System.exit(0);
		}
		if (lastName.length() <= 15) {
			this.lastName = lastName;
		} else {
			System.out.println("Invalid lastName");
			System.exit(0);
		}
		if (address.length() <= 20) {
			this.address = address;
		} else {
			System.out.println("Invalid address");
			System.exit(0);
		}
		if (city.length() <= 15) {
			this.city = city;
		} else {
			System.out.println("Invalid city");
			System.exit(0);
		}
		if (state.length() <= 2) {
			this.state = state;
		} else {
			System.out.println("Invalid state");
			System.exit(0);
		}
		if (zipCode.length() <= 5) {
			this.zipCode = zipCode;
		} else {
			System.out.println("Invalid zipCode");
			System.exit(0);
		}
		if (phoneNum.length() <= 12) {
			this.phoneNum = phoneNum;
		} else {
			System.out.println("Invalid phoneNum");
			System.exit(0);
		}
		this.cookie = cookie;
	}

	public String toString() {
		return title + "," + firstName + "," + lastName + "," + address + "," + city + "," + state + "," + zipCode + ","
				+ phoneNum + "," + cookie.get(0) + "," + cookie.get(1) + "," + cookie.get(2) + "," + cookie.get(3) + ","
				+ cookie.get(4) + "," + cookie.get(5) + "," + cookie.get(6) + "," + cookie.get(7);
	}
	//all getter and setter methods
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public ArrayList<Integer> getCookie() {
		return cookie;
	}

	public void setCookie(ArrayList<Integer> cookie) {
		this.cookie = cookie;
	}

}