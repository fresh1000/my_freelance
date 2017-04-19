
public class Subject {
	private String sCode;
	private String session;
	private int year;
	
	public Subject() {
		this.sCode = null;
		this.session = null;
		this.year = 0;
	}
	
	public Subject(Subject other) {
		this(other.getsCode(), other.getSession(), other.getYear());
	}
	
	public Subject(String sCode, String session, int year) {
		this.sCode = sCode;
		this.session = session;
		this.year = year;
	}
	
	public void displaySubjectInfo() {
		System.out.println("ENROLMENT");
		System.out.println("  Subject code: " + sCode);
		System.out.println("  Session: " + session);
		System.out.println("  Year: " + year);
	}

	public String getsCode() {
		return sCode;
	}

	public String getSession() {
		return session;
	}

	public int getYear() {
		return year;
	}

	public void setsCode(String sCode) {
		this.sCode = sCode;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
