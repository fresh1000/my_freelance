//*******************************************************************
// Author: Yuor name
// Class CalendarDate
// Class for created date, change date, check date, get next day date. 
//*******************************************************************
public class CalendarDate {
	private int year;
	private int month;
	private int day;
	
	public CalendarDate() {
		this.year = 1582;
		this.month = 10;
		this.day = 15;
	}

	public CalendarDate(int year, int month, int day) {
		if(year >= 1582 && year <= 2016) {
			this.year = year;	
		}else {
			System.out.println("ERROR: Invalid Date was entered. Object set to default instead.");
			this.year = 1582;
			this.month = 10;
			this.day = 15;
		}
		
		if(month >= 1 && month <= 12) {
			this.month = month;
		}else {
			System.out.println("ERROR: Invalid Date was entered. Object set to default instead.");
			this.year = 1582;
			this.month = 10;
			this.day = 15;
		}
		
		if((this.month == 1) || (this.month == 3) ||(this.month == 5) || (this.month == 7)|| (this.month == 8) || (this.month == 10) || (this.month == 12)) {
			if(day >= 1 && day <= 31) {
				this.day = day;
			} else {
				System.out.println("ERROR: Invalid Date was entered. Object set to default instead.");
				this.year = 1582;
				this.month = 10;
				this.day = 15;
			}
		}
		
		if(this.month == 2) {
			if((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
				if(day >= 1 && day <= 29){
					this.day = day;
				}else {
					System.out.println("ERROR: Invalid Date was entered. Object set to default instead.");
					this.year = 1582;
					this.month = 10;
					this.day = 15;
				}
			}else if(day >= 1 && day <= 28) {
				this.day = day;
			}else {
				System.out.println("ERROR: Invalid Date was entered. Object set to default instead.");
				this.year = 1582;
				this.month = 10;
				this.day = 15;
			}
		}
		
		if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
			if(day >= 1 && day <= 30) {
				this.day = day;
			}else {
			System.out.println("ERROR: Invalid Date was entered. Object set to default instead.");
			this.year = 1582;
			this.month = 10;
			this.day = 15;
			}
		}
		
	}
	
	public CalendarDate(CalendarDate calendarDate) {
		this.year = calendarDate.year;
		this.month = calendarDate.month;
		this.day = calendarDate.day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year >= 1582 && year <= 2016) {
			this.year = year;	
		}else
			System.out.println("Invalid year!");
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month >= 1 && month <= 12) {
			this.month = month;
		}else 
			System.out.println("Invalid month!");
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if((this.month == 1) || (this.month == 3) ||(this.month == 5) || (this.month == 7)|| (this.month == 8) || (this.month == 10) || (this.month == 12)) {
			if(day >= 1 && day <= 31) {
				this.day = day;
			} else
				System.out.println("Invalid day!");
		}
		if(this.month == 2) {
			if((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
				if(day >= 1 && day <= 29){
					this.day = day;
				}else
					System.out.println("Invalid day!");
			}else if(day >= 1 && day <= 28) {
				this.day = day;
			}else
				System.out.println("Invalid day!");
		}
		if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
			if(day >= 1 && day <= 30) {
			this.day = day;
		}else{
			System.out.println("Invalid day!");
			}
		}
	}
	
	public void setDate(int year, int month, int day) {
		if(isValidDate(year, month, day) == false) {
			System.out.println("Invalid year, month or day!");
		}else
			isValidDate(year, month, day);
	}
	
	public boolean isValidDate(int year, int month, int day) {
		if(year >= 1582 && year <= 2016) {
			this.year = year;
		}else {
			return false;
		}
		
		if(month >= 1 && month <= 12) {
			this.month = month;
		}else {
			return false;
		}
		
		if((this.month % 2 != 0) || this.month == 8) {
			if(day >= 1 && day <= 31) {
				this.day = day;
				return true;
			} else {
				return false;
			}
		}
		
		if(this.month == 2) {
			if((this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0) {
				if(day >= 1 && day <= 29){
					this.day = day;
					return true;
				}else {
					return false;
				}
			}else if(day >= 1 && day <= 28) {
				this.day = day;
				return true;
			}else {
				return false;
			}
		}
		
		if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
			if(day >= 1 && day <= 30) {
				this.day = day;
				return true;
			}
		}
		return false;		
	}
	
	public static boolean isLeapYear(int year) {
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isMagicDate() {
		if(this.day * this.month == this.year%100){
			return true;
		}	
		return false;
	}
	
	public CalendarDate nextDay() {
		CalendarDate calendarDate = new CalendarDate();
		
		if(this.month == 2 && isLeapYear(this.year)) {
			if(this.day >= 1 && this.day <= 28) {
				calendarDate.day = this.day + 1;
				calendarDate.month = this.month;
				calendarDate.year = this.year;
				return calendarDate;
			}else
			  calendarDate.day = 1;
		      calendarDate.month = this.month + 1;
		      calendarDate.year = this.year;
		      return calendarDate;
		}
		
		if(this.month == 2 && !isLeapYear(this.year)) {
			if(this.day >= 1 && this.day <= 27) {
				calendarDate.day = this.day + 1;
				calendarDate.month = this.month;
				calendarDate.year = this.year;
				return calendarDate;
			}else
				calendarDate.day = 1;
		      	calendarDate.month = this.month + 1;
		      	calendarDate.year = this.year;
		      	return calendarDate;
		}
		
		if((this.month == 1) || (this.month == 3) ||(this.month == 5) || (this.month == 7)|| (this.month == 8) || (this.month == 10) || (this.month == 12)) {
			if(this.month == 12 && this.day == 31) {
				calendarDate.day = 1;
		      	calendarDate.month = 1;
		      	calendarDate.year = this.year + 1;
		      	return calendarDate;
			}
			if(this.day >= 1 && this.day <= 30){
				calendarDate.day = this.day + 1;
				calendarDate.month = this.month;
				calendarDate.year = this.year;
				return calendarDate;
			}else
			calendarDate.day = 1;
	      	calendarDate.month = this.month + 1;
	      	calendarDate.year = this.year;
	      	return calendarDate;
		}
		
		if(this.day >= 1 && this.day <= 29){
			calendarDate.day = this.day + 1;
			calendarDate.month = this.month;
			calendarDate.year = this.year;
			return calendarDate;
		}else
		calendarDate.day = 1;
      	calendarDate.month = this.month + 1;
      	calendarDate.year = this.year;
      	return calendarDate;
	}
	
	public boolean equals(CalendarDate calendarDate) {
		return calendarDate.year == this.year && calendarDate.month == this.month && calendarDate.day == this.day;
	}
	
	public String monthToStr() {
		switch (this.month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 3:
			return "March";
		default:
			return "December";
		}
	}

	
	public String toString() {
		return  this.day +" "+ monthToStr().substring(0, 3) + " " + this.year;
	}
	
	
}
