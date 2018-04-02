
public class Chars {
	private String stringLine;
	private char[] vowels = {'a', 'e', 'i', 'o', 'u'};//vowels array
	private char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
			'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};//consonants array
	//constructor
	public Chars(String str) {
		this.stringLine = str;
	}
	
	public int vowelsCount() {
		int count = 0;
		//for to stringLine string
		for (int i = 0; i < this.stringLine.length(); i++) {
			//for to vowels array
			for (int j = 0; j < this.vowels.length; j++) {
				if (this.stringLine.charAt(i) == this.vowels[j]) {
					count++;
				}
			}
		}
		return count;
	}

	public int consonantsCount() {
		int count = 0;
		//for to stringLine string
		for (int i = 0; i < this.stringLine.length(); i++) {
			//for to consonants array
			for (int j = 0; j < this.consonants.length; j++) {
				if (this.stringLine.charAt(i) == this.consonants[j]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public int bothCount() {
		//return sum counts
		int both = consonantsCount() + vowelsCount();
		return both;
	}
	
	//getter
	public String getStringLine() {
		return stringLine;
	}
	//setter
	public void setStringLine(String stringLine) {
		this.stringLine = stringLine;
	}
	
}
