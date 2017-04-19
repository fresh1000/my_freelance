
public class Terning {
	private int tall;
	
	public Terning() {
		kast();
	}
	
	public void kast() {
		tall = 1 + (int)(Math.random()*6);
	}
	
	public int getTall () {
		return tall;
	}
	
	public String toString() {
		return "Terning med verdi: " + tall;
	}
	
	public static void main(String[] args) {
		Terning terning;
		terning = new Terning();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
		terning.kast();
		System.out.println(terning.toString());
	}

}
