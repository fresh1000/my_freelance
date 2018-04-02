
import java.util.HashMap;
import java.util.Map;

public class RussianHelper implements ICharHelper {

    private Map<Character, Integer> charToInt;
    private Map<Integer, Character> intToChar;

    public RussianHelper()
    {
    	charToInt = new HashMap<>();
        charToInt.put('_',0);
        charToInt.put('�',1);
        charToInt.put('�',2);
        charToInt.put('�',3);
        charToInt.put('�',4);
        charToInt.put('�',5);
        charToInt.put('�',6);
        charToInt.put('�',7);
        charToInt.put('�',8);
        charToInt.put('�',9);
        charToInt.put('�',10);
        charToInt.put('�',11);
        charToInt.put('�',12);
        charToInt.put('�',13);
        charToInt.put('�',14);
        charToInt.put('�',15);
        charToInt.put('�',16);
        charToInt.put('�',17);
        charToInt.put('�',18);
        charToInt.put('�',19);
        charToInt.put('�',20);
        charToInt.put('�',21);
        charToInt.put('�',22);
        charToInt.put('�',23);
        charToInt.put('�',24);
        charToInt.put('�',25);
        charToInt.put('�',26);
        charToInt.put('�',27);
        charToInt.put('�',28);
        charToInt.put('�',29);
        charToInt.put('�',30);
        charToInt.put('�',31);
        charToInt.put('�',32);

        intToChar = new HashMap<>();
        intToChar.put(0,'_');
        intToChar.put(1,'�');
        intToChar.put(2,'�');
        intToChar.put(3,'�');
        intToChar.put(4,'�');
        intToChar.put(5,'�');
        intToChar.put(6,'�');
        intToChar.put(7,'�');
        intToChar.put(8,'�');
        intToChar.put(9,'�');
        intToChar.put(10,'�');
        intToChar.put(11,'�');
        intToChar.put(12,'�');
        intToChar.put(13,'�');
        intToChar.put(14,'�');
        intToChar.put(15,'�');
        intToChar.put(16,'�');
        intToChar.put(17,'�');
        intToChar.put(18,'�');
        intToChar.put(19,'�');
        intToChar.put(20,'�');
        intToChar.put(21,'�');
        intToChar.put(22,'�');
        intToChar.put(23,'�');
        intToChar.put(24,'�');
        intToChar.put(25,'�');
        intToChar.put(26,'�');
        intToChar.put(27,'�');
        intToChar.put(28,'�');
        intToChar.put(29,'�');
        intToChar.put(30,'�');
        intToChar.put(31,'�');
        intToChar.put(32,'�');

    }

    @Override
    public int getIndex(char c) {
        return charToInt.get(Character.toUpperCase(c));
    }

    @Override
    public char getChar(int index) {
        return intToChar.get(index);
    }

    @Override
    public int alphabetLength() {
        return charToInt.size();
    }
}
