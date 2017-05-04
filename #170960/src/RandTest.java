import java.util.Random;

public class RandTest {

	public static void main(String[] args) {
		Random ran = new Random();//object for generate random numbers
		int X = Integer.parseInt(args[0]);//parse first argument from console
		int Y = Integer.parseInt(args[1]);//parse first argument from console
		
		for (int i = 0; i < X; i++) {
			System.out.println(ran.nextInt(Y) + 1);//print random integer 0 to y
		}
	}

}
