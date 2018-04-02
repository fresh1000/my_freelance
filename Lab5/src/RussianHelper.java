
import java.util.HashMap;
import java.util.Map;

public class RussianHelper implements ICharHelper {

    private Map<Character, Integer> charToInt;
    private Map<Integer, Character> intToChar;

    public RussianHelper()
    {
    	charToInt = new HashMap<>();
        charToInt.put('_',0);
        charToInt.put('À',1);
        charToInt.put('Á',2);
        charToInt.put('Â',3);
        charToInt.put('Ã',4);
        charToInt.put('Ä',5);
        charToInt.put('Å',6);
        charToInt.put('Æ',7);
        charToInt.put('Ç',8);
        charToInt.put('È',9);
        charToInt.put('É',10);
        charToInt.put('Ê',11);
        charToInt.put('Ë',12);
        charToInt.put('Ì',13);
        charToInt.put('Í',14);
        charToInt.put('Î',15);
        charToInt.put('Ï',16);
        charToInt.put('Ð',17);
        charToInt.put('Ñ',18);
        charToInt.put('Ò',19);
        charToInt.put('Ó',20);
        charToInt.put('Ô',21);
        charToInt.put('Õ',22);
        charToInt.put('Ö',23);
        charToInt.put('×',24);
        charToInt.put('Ø',25);
        charToInt.put('Ù',26);
        charToInt.put('Ú',27);
        charToInt.put('Û',28);
        charToInt.put('Ü',29);
        charToInt.put('Ý',30);
        charToInt.put('Þ',31);
        charToInt.put('ß',32);

        intToChar = new HashMap<>();
        intToChar.put(0,'_');
        intToChar.put(1,'À');
        intToChar.put(2,'Á');
        intToChar.put(3,'Â');
        intToChar.put(4,'Ã');
        intToChar.put(5,'Ä');
        intToChar.put(6,'Å');
        intToChar.put(7,'Æ');
        intToChar.put(8,'Ç');
        intToChar.put(9,'È');
        intToChar.put(10,'É');
        intToChar.put(11,'Ê');
        intToChar.put(12,'Ë');
        intToChar.put(13,'Ì');
        intToChar.put(14,'Í');
        intToChar.put(15,'Î');
        intToChar.put(16,'Ï');
        intToChar.put(17,'Ð');
        intToChar.put(18,'Ñ');
        intToChar.put(19,'Ò');
        intToChar.put(20,'Ó');
        intToChar.put(21,'Ô');
        intToChar.put(22,'Õ');
        intToChar.put(23,'Ö');
        intToChar.put(24,'×');
        intToChar.put(25,'Ø');
        intToChar.put(26,'Ù');
        intToChar.put(27,'Ú');
        intToChar.put(28,'Û');
        intToChar.put(29,'Ü');
        intToChar.put(30,'Ý');
        intToChar.put(31,'Þ');
        intToChar.put(32,'ß');

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
