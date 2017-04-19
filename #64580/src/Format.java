import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Format {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String contin = "";
			while(!contin.equals("no")){
			System.out.println("Time in 24 hour format(example 23:12):");
			String _24HourTime = sc.nextLine();
			SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
			SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
			Date _24HourDt = _24HourSDF.parse(_24HourTime);
			System.out.println(_12HourSDF.format(_24HourDt));
			System.out.println("Entet your answer(yes continue, no: stop the program):");
			contin = sc.nextLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
