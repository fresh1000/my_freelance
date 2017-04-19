
public class Roman {

	public static void main(String[] args) {
		
		int counter = 1;
		while (counter <= 100) {
			String roman = "";
			int first, second;
			first = counter / 10;
			second = counter % 10;
			if(first == 1) {
				roman = "X";
			}else if(first == 2){
				roman ="XX";
			}else if(first == 3){
				roman ="XXX";
			}else if(first == 3){
				roman ="XXX";
			}else if(first == 4){
				roman ="XL";
			}else if(first == 5){
				roman ="L";
			}else if(first == 6){
				roman ="LX";
			}else if(first == 7){
				roman ="LXX";
			}else if(first == 8){
				roman ="LXXX";
			}else if(first == 9){
				roman ="XC";
			}
			else if(first == 10){
				roman ="C";
			}
			
			if(second == 0) {
				roman += "";
			}else if(second == 1) {
				roman += "I";
			}else if(second == 2) {
				roman += "II";
			}else if(second == 3) {
				roman += "III";
			}else if(second == 4) {
				roman += "IV";
			}else if(second == 5) {
				roman += "V";
			}else if(second == 6) {
				roman += "VI";
			}else if(second == 7) {
				roman += "VII";
			}else if(second == 8) {
				roman += "VIII";
			}else if(second == 9) {
				roman += "IX";
			}
			
			if(roman != null) {
				
				System.out.println(counter + ": " + roman);
			}
			counter++;
		}
		
	}

}
