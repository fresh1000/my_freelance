
import java.util.HashMap;
import java.util.Map;

public class CharHelper implements IChar {

    private Map<Character, Integer> charToInt;
    private Map<Integer, Character> intToChar;

    public CharHelper()
    {
    	charToInt = new HashMap<>();
        charToInt.put('_',0);
        charToInt.put('А',1);
        charToInt.put('Б',2);
        charToInt.put('В',3);
        charToInt.put('Г',4);
        charToInt.put('Д',5);
        charToInt.put('Е',6);
        charToInt.put('Ж',7);
        charToInt.put('З',8);
        charToInt.put('И',9);
        charToInt.put('Й',10);
        charToInt.put('К',11);
        charToInt.put('Л',12);
        charToInt.put('М',13);
        charToInt.put('Н',14);
        charToInt.put('О',15);
        charToInt.put('П',16);
        charToInt.put('Р',17);
        charToInt.put('С',18);
        charToInt.put('Т',19);
        charToInt.put('У',20);
        charToInt.put('Ф',21);
        charToInt.put('Х',22);
        charToInt.put('Ц',23);
        charToInt.put('Ч',24);
        charToInt.put('Ш',25);
        charToInt.put('Щ',26);
        charToInt.put('Ъ',27);
        charToInt.put('Ы',28);
        charToInt.put('Ь',29);
        charToInt.put('Э',30);
        charToInt.put('Ю',31);
        charToInt.put('Я',32);

        intToChar = new HashMap<>();
        intToChar.put(0,'_');
        intToChar.put(1,'А');
        intToChar.put(2,'Б');
        intToChar.put(3,'В');
        intToChar.put(4,'Г');
        intToChar.put(5,'Д');
        intToChar.put(6,'Е');
        intToChar.put(7,'Ж');
        intToChar.put(8,'З');
        intToChar.put(9,'И');
        intToChar.put(10,'Й');
        intToChar.put(11,'К');
        intToChar.put(12,'Л');
        intToChar.put(13,'М');
        intToChar.put(14,'Н');
        intToChar.put(15,'О');
        intToChar.put(16,'П');
        intToChar.put(17,'Р');
        intToChar.put(18,'С');
        intToChar.put(19,'Т');
        intToChar.put(20,'У');
        intToChar.put(21,'Ф');
        intToChar.put(22,'Х');
        intToChar.put(23,'Ц');
        intToChar.put(24,'Ч');
        intToChar.put(25,'Ш');
        intToChar.put(26,'Щ');
        intToChar.put(27,'Ъ');
        intToChar.put(28,'Ы');
        intToChar.put(29,'Ь');
        intToChar.put(30,'Э');
        intToChar.put(31,'Ю');
        intToChar.put(32,'Я');

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
