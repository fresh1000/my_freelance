
import java.io.IOException;
import java.util.Scanner;

public class Third {

    public static final String input_file = "output.txt";

    public static void main(String[] args)
    {
        ICharHelper ruAlpha = new RussianHelper();

        try (Scanner cin = new Scanner(System.in)){
            String cipher = Helper.read(input_file, Helper.UTF8);
            for (int shift=0; shift<ruAlpha.alphabetLength(); ++shift)
            {
                ICodec codec = new Ceasar(ruAlpha, shift);
                String decodedMessage = codec.decodeCeasar(cipher);

                System.out.println(decodedMessage);
                System.out.println("Does this message makes sense? Y/n");

                String ans = cin.next();
                if (ans.toUpperCase().equals("Y"))
                {
                    System.out.printf("Shift for this message is %d characters", shift);
                    break;
                }
            }

        } catch (IOException ex) {
            System.err.println("Error occurred");
            ex.printStackTrace();
        }
    }
}
