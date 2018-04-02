
public class Test {

    private final int a = 10;
    private final int s = 13;
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String[] args) throws Exception {
        // read message
        String message = Helper.read(INPUT_FILE, Helper.UTF8);
        // create codec
        ICodec codec = new Codec();
        // make cipher and decipher it
        String weirdo = new Test().weirdEncode(message);
        String cipher = codec.encode(message);
        String decipher = codec.decode(cipher);
        // write result to the file
        Helper.write(OUTPUT_FILE, Helper.UTF8, weirdo + "\n" + cipher + "\n" + decipher);
    }

    String weirdEncode(String message)
    {
        IChar charsHelper = new CharHelper();
        message = message.toUpperCase();
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<message.length(); ++i)
        {
            char c = message.charAt(i);
            int ind = charsHelper.getIndex(c);
            c = charsHelper.getChar((a*ind + s)%charsHelper.alphabetLength());
            builder.append(c);
        }
        return builder.toString();
    }

}
