import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    public static final String KOI8 = "KOI8_R";
    public static final String ASCII = "ASCII";
    public static final String UTF8 = "UTF8";
    public static final String Windows1251 = "Cp1251";

    public static String read(String filePath, String encoding) throws IOException
    {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), Charset.forName(encoding)))
        {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                builder.append(line);
                builder.append("\n");
            }
            if (builder.length() > 0)
            {
                builder.deleteCharAt(builder.length()-1);
            }

            return builder.toString();
        }
    }

    public static void write(String filePath, String encoding, String content) throws IOException
    {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName(encoding)))
        {
            writer.write(content);
        }
    }

}
