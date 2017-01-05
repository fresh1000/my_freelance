import java.util.Scanner;

public class CDateMenu_Driver
{
   public static void main(String[] args)
   {
      System.out.println("Welcome to the Menu Driver...");
      Scanner keyboard = new Scanner(System.in);
      boolean keep_going = true;
      CalendarDate date1, date2;
      int day, month, year;
      
      //Begin by testing Constructors (as many times as you would like)
      //You should try entering in both valid and invalid information
      //to check and make sure that appropriate error messages are produced.
      while(keep_going)
      {
         switch(PrintMenu(1))
         {
            case 1:  System.out.println("**Testing Default Constructor: ");
                     date1 = new CalendarDate();
                     System.out.println("  " + date1);
                     break;
                     
            case 2:  System.out.print("Please enter a year, month, and day: ");
                        year = keyboard.nextInt();
                        month = keyboard.nextInt();
                        day = keyboard.nextInt();
                     System.out.println("**Testing Constructor w/ Parameters: ");
                     date1 = new CalendarDate(year, month, day);
                     System.out.println("  " + date1);
                     break;
                     
            case 3:  System.out.println("**Testing 'Copy' Constructor: ");
                     date2 = new CalendarDate(2004, 11, 23); //my son's bday :)
                     date1 = new CalendarDate(date2);
                     System.out.println("  " + date1);
                     break;
                     
            default: keep_going = false; //to exit Constructor testing
         }
      }
  
      //Now test all of your methods.  Some dates will be preset for testing 
      //purposes while others will allow user input for testing.
      //You should try entering in both valid and invalid information
      //to check and make sure that appropriate error messages are produced.
      keep_going = true;
      while(keep_going)
      {
         switch(PrintMenu(2))
         {
            case 1:  date1 = Ask4Date();   
                     System.out.print("Please enter a year: ");
                        year = keyboard.nextInt();
                     System.out.println("**Testing setYear(): ");
                     System.out.println("Before Change: " + date1);
                     date1.setYear(year);
                     System.out.println("After Change: " + date1);
                     break;
                     
            case 2:  date1 = Ask4Date();   
                     System.out.print("Please enter a month: ");
                        month = keyboard.nextInt();
                     System.out.println("**Testing setMonth(): ");
                     System.out.println("Before Change: " + date1);
                     date1.setMonth(month);
                     System.out.println("After Change: " + date1);
                     break;
                     
            case 3:  date1 = Ask4Date();   
                     System.out.print("Please enter a day: ");
                        day = keyboard.nextInt();
                     System.out.println("**Testing setDay(): ");
                     System.out.println("Before Change: " + date1);
                     date1.setDay(day);
                     System.out.println("After Change: " + date1);
                     break;
                     
            case 4:  date1 = Ask4Date();  
                     System.out.println("**Testing getYear(): ");
                     System.out.println("The year of " + date1 + " is " + date1.getYear());
                     break;
                     
            case 5:  date1 = Ask4Date();   
                     System.out.println("**Testing getMonth(): ");
                     System.out.println("The month of " + date1 + " is " + date1.getMonth());
                     break;
                     
            case 6:  date1 = Ask4Date();   
                     System.out.println("**Testing getDay(): ");
                     System.out.println("The day of " + date1 + " is " + date1.getDay());
                     break;
                     
            case 7:  date1 = Ask4Date();
                     System.out.println("**Testing nextDay(): ");
                     date2 = date1.nextDay();
                     System.out.println("If the date was " + date1 + ",\"tomorrow\" would be " + date2);
                     break;
                     
            case 8: System.out.print("Please enter a year: ");
                        year = keyboard.nextInt();
                     System.out.println("**Testing isLeapYear(): ");
                     System.out.println("The year " + year + " is " + ((CalendarDate.isLeapYear(year))? "" : "NOT ") + "a Leap Year.");
                     break;
                     
            case 9: System.out.print("Please enter a month(int): ");
                        month = keyboard.nextInt();
                     date1 = new CalendarDate(1999, month, 1);
                     System.out.println("**Testing monthToStr(): ");
                     System.out.println("The numeric month " + month + " is more commonly known as " + date1.monthToStr() + ".");
                     break;
                     
            case 10: date1 = new CalendarDate();   //default constructor  
                     System.out.print("Please enter a year, month, and day: ");
                        year = keyboard.nextInt();
                        month = keyboard.nextInt();
                        day = keyboard.nextInt();
                     System.out.println("**Testing setDate(): ");
                     System.out.println("Before Change: " + date1);
                     date1.setDate(year, month, day);
                     System.out.println("After Change: " + date1);
                     break;
                     
            case 11: date1 = Ask4Date();
                     System.out.println("**Testing isMagicDate(): ");
                     System.out.println("The date " + date1 + " is " + ((date1.isMagicDate())? "" : "NOT ") + "a Magic Date.");
                     break;
                     
            case 12: date1 = Ask4Date();
                     System.out.println("**Testing toString(): ");
                     System.out.println("The date is " + date1 + ".");  //toString is truly being tested in most all methods
                     break;                                             //remember it is tested when we try to print using just the object's name 
                     
            case 13: date1 = Ask4Date();
                     date2 = Ask4Date();
                     System.out.println("**Testing equals(): ");
                     System.out.println("The dates " + date1 + " and " + date2 + " are " + ((date1.equals(date2))? "" : "NOT ") + "Equal dates.");
                     break;      
                     
            default: keep_going = false; //to exit Method testing
         }//end of switch
      }//end of while
   }//end of main
   
   /**************************************************
    Method to prompt and gather date information from 
    the user.  It creates a CalendarDate Object and 
    returns that for use in the main method.
   **************************************************/
   public static CalendarDate Ask4Date()
   {
      Scanner scan = new Scanner(System.in);
      System.out.print("Please enter a year, month, and day: ");
      return new CalendarDate(scan.nextInt(), scan.nextInt(), scan.nextInt());
   }//end of Ask4Date
   
   /**************************************************
    Method to display the menu options to the user 
    and prompt for their selection choice.  A valid 
    selection will be returned to the main for use in 
    testing apprepriate Worker class methods.
   **************************************************/
   public static int PrintMenu(int option)
   {
      Scanner scan = new Scanner(System.in);
      int selection;
      if(option == 1)
      {  System.out.println("\t|-------------------------------------------------------|");
         System.out.println("\t| Please select from the following Constructor options: |");
         System.out.println("\t|\t1. CalendarDate()                               |");
         System.out.println("\t|\t2. CalendarDate(int, int, int)                  |");
         System.out.println("\t|\t3. CalendarDate(CalendarDate)                   |");
         System.out.println("\t|\t4. QUIT                                         |");
         System.out.println("\t|-------------------------------------------------------|");
         System.out.print("Please enter your selection: ");
         selection = scan.nextInt();
         while(selection < 1 || selection > 4)
         {
            System.out.print("ERROR:  Selection out of Range.  Try again:  ");
            selection = scan.nextInt();
         }
         return selection;
      }
      else if(option == 2)
      {
         //Note: isValidDate() is not an option since it was meant to be a support method instead of a 
         //      service method and therefore cannot be used outside of the CalendarDate Class
         System.out.println("\t|------------------------------------------------------------------------" 
                              + "-----------------------------------------|");
         System.out.println("\t| Please select from the following method options:   \t\t\t\t\t\t\t          |");
         System.out.print("\t|\t1. setYear(int): void");
         System.out.print("\t\t\t2. setMonth(int): void");
         System.out.println("\t\t\t3. setDay(int): void      |");
         System.out.print("\t|\t4. getYear( ): int");
         System.out.print("\t\t\t5. getMonth( ): int");
         System.out.println("\t\t\t6. getDay( ): int         |");
         System.out.print("\t|\t7. nextDay( ):  CalendarDate");
         System.out.print("\t\t8. isLeapYear(int): boolean");
         System.out.println("\t\t9. monthToStr( ): String  |");
         System.out.print("\t|\t10. setDate(int, int, int): void");
         System.out.print("\t11. isMagicDate( ): boolean");
         System.out.println("\t\t12. toString( ): String   |");
         System.out.print("\t|\t13. equals(CalendarDate): boolean");
         System.out.println("\t14. QUIT\t                                                  |");
         System.out.println("\t|------------------------------------------------------------------------" 
                              + "-----------------------------------------|");
         System.out.print("Please enter your selection: ");
         selection = scan.nextInt();
         while(selection < 1 || selection > 14)
         {
            System.out.print("ERROR:  Selection out of Range.  Try again:  ");
            selection = scan.nextInt();
         }
         return selection;
      }
      return 0;
   }//end of PrintMenu
}//end of TobiasDriver