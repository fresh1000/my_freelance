
import java.io.File;
import java.util.*;

public class Second {

    public static final String input_file = "output.txt";

    public static void main(String[] args) throws Exception
    {
        String message = Helper.read(input_file, Helper.UTF8);
        IFrequency count = new Letters();
        List<Map.Entry<String, Integer>> lst = toSortedList(count.tokens(message));
        for (Map.Entry<String, Integer> entry : lst)
        {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        count = new Pairs();
        lst = toSortedList(count.tokens(message));
        for (Map.Entry<String, Integer> entry : lst)
        {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    public static List<Map.Entry<String, Integer>> toSortedList(Map<String, Integer> m)
    {
        List<Map.Entry<String, Integer>> answer = new ArrayList<>(m.entrySet());
        Collections.sort(answer, (o1, o2) ->
        {
            int res = -Integer.compare(o1.getValue(), o2.getValue());
            return res == 0 ? o1.getKey().compareTo(o2.getKey()) : res;
        });
        return answer;
    }

}
