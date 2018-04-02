
import java.io.File;
import java.io.IOException;

public class First {

    public static final String input_file = "input.txt";
    public static final String output_file = "output.txt";
    public static final int shift = 5;

    public static void main(String[] args)
    {
        ICharHelper ruAlphaHelper = new RussianHelper();
        ICodec codec = new Ceasar(ruAlphaHelper, shift);

        try {
            String mess = Helper.read(input_file, Helper.UTF8);
            String cip = codec.encodeCeasar(mess);
            Helper.write(output_file, Helper.UTF8, cip);
            System.out.println(cip);
            System.out.println();

            String decoded = codec.decodeCeasar(cip);
            System.out.println(decoded);

        } catch (IOException ex) {
            System.err.println("Error occurred");
            ex.printStackTrace();
        }
    }

}
