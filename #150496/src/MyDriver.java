
public class MyDriver {

	public static void main(String[] args) {
		CalendarDate date = new CalendarDate();
		System.out.println("Default constructor: " + date.toString());
		
		CalendarDate date1 = new CalendarDate(date);
		System.out.println("Constructor with parametr object: " + date1.toString());
		
		CalendarDate date2 = new CalendarDate(2011, 12, 31);
		System.out.println("Constrctor with parametrs: " + date2.toString());
		
		System.out.println("Month date2 to string: " + date2.monthToStr());
		System.out.println("Next day after object date2: " + date2.nextDay());
		System.out.println("Magic date: " + date2.isMagicDate());
		System.out.println("Leap year(2000): " + CalendarDate.isLeapYear(2000));
		System.out.println("Equals date1 and date2: " + date1.equals(date2));
		
		CalendarDate date3 = new CalendarDate(2000, 2, 30);//leap year
		CalendarDate date4 = new CalendarDate(2001, 2, 29);//don't leap year
		System.out.println(date3.toString());//default 
		System.out.println(date4.toString());//default
	}

}
