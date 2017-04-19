
/*
 * Main template class with the menu with all the options
 * 
 */
package game;

import java.util.Scanner;

/**
 *
 * @author Arantza
 */
public class GameController {
    
    public static void checkInformation(Room mwRoom) {
        Scanner sc = new Scanner(System.in);
        int row, column;
        System.out.print("Enter row(0-9):");
        row = sc.nextInt();
        System.out.print("Enter colum(0-9):");
        column = sc.nextInt();
        System.out.println();
        if (!mwRoom.isFree(row, column)) {
            System.out.println(mwRoom.getEntities().get(mwRoom.getPosition(row, column)).toString());
        } else {
            System.out.println("empty");
        }
        System.out.println();
    }

    //method for initial room
    public static void initialiseRoom(Room mwRoom) {
        mwRoom.getEntities().add(new Stone(1, 1));
        mwRoom.getEntities().add(new Dragon(1, 5, 95, false));
        mwRoom.getEntities().add(new Hole(2, 3, 15));
        mwRoom.getEntities().add(new Human(3, 1, "Fred", 67));
        mwRoom.getEntities().add(new Monster(3, 7, 5, 87));
        mwRoom.getEntities().add(new Hole(4, 3, 10));
        mwRoom.getEntities().add(new Stone(5, 2));
        mwRoom.getEntities().add(new Human(6, 7, "Matt", 43));
        mwRoom.getEntities().add(new Dragon(7, 0, 50, true));
        mwRoom.getEntities().add(new Human(7, 3, "Sam", 54));
        mwRoom.getEntities().add(new Monster(8, 7, 3, 76));
        mwRoom.getEntities().add(new Monster(9, 3, 5, 34));
    }

    //method for display room
    private static void displayRoom(Room mwRoom) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                if (!mwRoom.isFree(i, j)) {
                    System.out.print(mwRoom.getEntities().get(mwRoom.getPosition(i, j)).getSymbol() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void menu() {

        System.out.println("Enter an option");
        System.out.println("1: Display level");
        System.out.println("2: Move animated entities");
        System.out.println("3: Display the properties of an entity");
        System.out.println("4: Reset the room");
        System.out.println("0: Exit");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Room mwRoom = new Room();

        System.out.println("Initialise the room here");
        initialiseRoom(mwRoom);

        Scanner kb = new Scanner(System.in);
        int option;

        do {
            menu();
            option = kb.nextInt();
            kb.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Option to display room");
                    displayRoom(mwRoom);
                    break;

                case 2:
                    System.out.println(" Option to move all the animated entities ");
                    mwRoom.move();
                    break;
                case 3:
                    System.out.println(" Enter the position of the entity that you want to display ");
                    checkInformation(mwRoom);
                    break;
                case 4:
                    System.out.println("Option to reset the room:");
                    mwRoom.clearRoom();
                    initialiseRoom(mwRoom);
                    break;

                case 0:
                    System.out.println(" Good bye");
                    break;

                default:
                    System.out.println("Sorry wrong option");
            }
        } while (option != 0);

    }

}
