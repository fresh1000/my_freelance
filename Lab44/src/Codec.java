
import java.util.HashMap;
import java.util.Map;

public class Codec implements ICodec {
    private Map<Character, Character> encodingMap;
    private Map<Character, Character> decodingMap;

    public Codec()
    {
    	encodingMap = new HashMap<>();
        encodingMap.put('_','Ч');
        encodingMap.put('А','Х');
        encodingMap.put('Б','Т');
        encodingMap.put('В','Ц');
        encodingMap.put('Г','Л');
        encodingMap.put('Д','Щ');
        encodingMap.put('Е','Г');
        encodingMap.put('Ж','А');
        encodingMap.put('З','Ъ');
        encodingMap.put('И','Н');
        encodingMap.put('Й','С');
        encodingMap.put('К','Б');
        encodingMap.put('Л','Э');
        encodingMap.put('М','Ж');
        encodingMap.put('Н','Р');
        encodingMap.put('О','В');
        encodingMap.put('П','К');
        encodingMap.put('Р','М');
        encodingMap.put('С','Ь');
        encodingMap.put('Т','О');
        encodingMap.put('У','Д');
        encodingMap.put('Ф','Я');
        encodingMap.put('Х','Й');
        encodingMap.put('Ц','П');
        encodingMap.put('Ч','Ы');
        encodingMap.put('Ш','Е');
        encodingMap.put('Щ','И');
        encodingMap.put('Ъ','У');
        encodingMap.put('Ы','Ш');
        encodingMap.put('Ь','З');
        encodingMap.put('Э','_');
        encodingMap.put('Ю','Ф');
        encodingMap.put('Я','Ю');

        decodingMap = new HashMap<>();
        decodingMap.put('Ч','_');
        decodingMap.put('Х','А');
        decodingMap.put('Т','Б');
        decodingMap.put('Ц','В');
        decodingMap.put('Л','Г');
        decodingMap.put('Щ','Д');
        decodingMap.put('Г','Е');
        decodingMap.put('А','Ж');
        decodingMap.put('Ъ','З');
        decodingMap.put('Н','И');
        decodingMap.put('С','Й');
        decodingMap.put('Б','К');
        decodingMap.put('Э','Л');
        decodingMap.put('Ж','М');
        decodingMap.put('Р','Н');
        decodingMap.put('В','О');
        decodingMap.put('К','П');
        decodingMap.put('М','Р');
        decodingMap.put('Ь','С');
        decodingMap.put('О','Т');
        decodingMap.put('Д','У');
        decodingMap.put('Я','Ф');
        decodingMap.put('Й','Х');
        decodingMap.put('П','Ц');
        decodingMap.put('Ы','Ч');
        decodingMap.put('Е','Ш');
        decodingMap.put('И','Щ');
        decodingMap.put('У','Ъ');
        decodingMap.put('Ш','Ы');
        decodingMap.put('З','Ь');
        decodingMap.put('_','Э');
        decodingMap.put('Ф','Ю');
        decodingMap.put('Ю','Я');
    }


    @Override
    public String encode(String message) {
        message = message.toUpperCase();
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<message.length(); ++i)
        {
            char c = message.charAt(i);
            builder.append(encodingMap.get(c));
        }
        return  builder.toString();
    }

    @Override
    public String decode(String cipher) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<cipher.length(); ++i)
        {
            char c = cipher.charAt(i);
            builder.append(decodingMap.get(c));
        }
        return  builder.toString();
    }
}
